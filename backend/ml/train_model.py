import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestRegressor
import pickle
import requests
from sklearn.metrics import mean_squared_error, r2_score
import numpy as np

# Fetch data from API
response = requests.get("http://localhost:8080/inputVariables")
data = response.json()
df = pd.DataFrame(data)

# Convert "time" column to datetime
df['time'] = pd.to_datetime(df['time'])
df.sort_values('time', inplace=True)

# Create lag features
df['growth_lag_1'] = df['waterHyacinthGrowth'].shift(1)

# Rolling features
df['tds_rolling'] = df['tds'].rolling(window=3, min_periods=1).mean()
df['ph_rolling'] = df['ph'].rolling(window=3, min_periods=1).mean()
df['temp_rolling'] = df['temperature'].rolling(window=3, min_periods=1).mean()

# Seasonality features
df['day_of_year'] = df['time'].dt.dayofyear
df['sin_doy'] = np.sin(2 * np.pi * df['day_of_year'] / 365)
df['cos_doy'] = np.cos(2 * np.pi * df['day_of_year'] / 365)

# Drop rows with missing data due to lag/rolling
df.dropna(inplace=True)

# Select features and target
feature_cols = [
    'tds', 'ph', 'temperature',
    'tds_rolling', 'ph_rolling', 'temp_rolling',
    'growth_lag_1', 'sin_doy', 'cos_doy'
]
X = df[feature_cols]
y = df['waterHyacinthGrowth']

# Split the data into training and testing sets
X_train, X_test = X.iloc[:int(0.8*len(X))], X.iloc[int(0.8*len(X)):]
y_train, y_test = y.iloc[:int(0.8*len(y))], y.iloc[int(0.8*len(y)):]

# Train the model
model = RandomForestRegressor(n_estimators=100, random_state=42)
model.fit(X_train, y_train)

# Evaluate the model
y_pred = model.predict(X_test)
print("Mean Squared Error:", mean_squared_error(y_test, y_pred))
print("R² Score:", r2_score(y_test, y_pred))

# Save the trained model
with open('model.pkl', 'wb') as f:
    pickle.dump(model, f)

print("Model trained and saved.")