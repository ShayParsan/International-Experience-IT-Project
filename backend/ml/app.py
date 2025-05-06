from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from matplotlib import pyplot as plt
import pandas as pd
import requests
from prophet import Prophet
from datetime import datetime, timedelta

app = FastAPI()

origins = [
    "http://localhost:5000",  # Replace with your frontend's origin
    "http://localhost:8080",
    "http://127.0.0.1:5500"
    # Add other origins as needed
]

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"] , 
    allow_credentials=False,
    allow_methods=["*"],  # Allows all HTTP methods
    allow_headers=["*"],  # Allows all headers
)

@app.get("/predictDays/{days}")
def predict_days(days: int):
    # Load data from your local API
    response = requests.get("http://localhost:8080/inputVariables")
    if response.status_code != 200:
        return {"error": "Could not fetch input data."}
    
    raw_data = response.json()

    # Convert to DataFrame
    df = pd.DataFrame(raw_data)
    df["ds"] = pd.to_datetime(df["time"]).dt.tz_localize(None)  # Remove timezone information
    df["y"] = df["waterHyacinthGrowth"]
    df = df[["ds", "y"]]

    # Train Prophet model
    model = Prophet(yearly_seasonality=True, daily_seasonality=False)
    model.fit(df)

    # Future dataframe
    future = model.make_future_dataframe(periods=days)
    forecast = model.predict(future)

    # Filter only future predictions
    forecast = forecast.tail(days)

    results = []
    last_date = df["ds"].max()
    for i, row in enumerate(forecast.itertuples(), start=1):
        results.append({
            "day": i,
            "prediction": round(row.yhat, 4),
            "time": row.ds.strftime("%Y-%m-%d")
        })

    # Plot predictions
    # plot_predictions(df, forecast)

    return results

# def plot_predictions(df, forecast):
#     """Plot the actual data and predictions."""
#     plt.figure(figsize=(12, 6))
#     plt.plot(df["ds"], df["y"], label="Actual Data", marker="o")
#     plt.plot(forecast["ds"], forecast["yhat"], label="Predicted Data", linestyle="--")
#     plt.fill_between(
#         forecast["ds"],
#         forecast["yhat_lower"],
#         forecast["yhat_upper"],
#         color="gray",
#         alpha=0.2,
#         label="Uncertainty Interval"
#     )
#     plt.xlabel("Date")
#     plt.ylabel("Water Hyacinth Growth")
#     plt.title("Water Hyacinth Growth Predictions")
#     plt.legend()
#     plt.grid()
#     plt.savefig("predictions_plot.png")  # Save the plot as an image
#     plt.close()  # Close the plot to free memory
