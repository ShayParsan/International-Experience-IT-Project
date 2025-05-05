from flask import Flask, request, jsonify
from flask_cors import CORS
import pickle
import numpy as np
import pandas as pd
import requests

app = Flask(__name__)
CORS(app)

# Load the trained model
with open('model.pkl', 'rb') as file:
    model = pickle.load(file)

@app.route('/predictDays/<int:days>', methods=['GET'])
def predict_days(days):
    # Fetch latest data
    response = requests.get("http://localhost:8080/inputVariables")
    data = response.json()
    df = pd.DataFrame(data)
    df['time'] = pd.to_datetime(df['time'])
    df.sort_values('time', inplace=True)

    # Prepare a copy to simulate forward
    sim_df = df.copy()
    predictions = []

    for i in range(days):
        last_row = sim_df.iloc[-1].copy()  # Use the last row to simulate the next day
        future_time = last_row['time'] + pd.Timedelta(days=1)

        # Seasonal features
        sin_doy = np.sin(2 * np.pi * future_time.dayofyear / 365)
        cos_doy = np.cos(2 * np.pi * future_time.dayofyear / 365)

        # Construct input row with only the features used during training
        model_input = pd.DataFrame([{
            'sin_doy': sin_doy,
            'cos_doy': cos_doy
        }])

        # Predict growth
        predicted_growth = model.predict(model_input)[0]

        # Store prediction
        predictions.append({
            'day': i + 1,
            'time': future_time.strftime('%Y-%m-%d'),
            'prediction': predicted_growth
        })

        # Append simulated row for the next iteration
        sim_df = pd.concat([sim_df, pd.DataFrame([{
            'time': future_time,
            'waterHyacinthGrowth': predicted_growth
        }])], ignore_index=True)

    return jsonify(predictions)

if __name__ == '__main__':
    app.run(debug=True)