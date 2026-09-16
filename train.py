import pandas as pd
from sklearn.ensemble import RandomForestClassifier
import joblib

data = pd.DataFrame({
    "age": [30,50,60,45,35],
    "bmi": [22,31,34,28,36],
    "heartRate": [70,95,100,85,110],
    "smoker": [0,1,1,0,1],
    "family": [0,1,1,0,1],
    "risk": [0,1,1,0,1]
})

X = data.drop("risk", axis=1)
y = data["risk"]

model = RandomForestClassifier()
model.fit(X, y)

joblib.dump(model, "model.pkl")
print("Model trained & saved successfully")
