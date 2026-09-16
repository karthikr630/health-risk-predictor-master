from fastapi import FastAPI
import joblib

app = FastAPI()
model = joblib.load("model.pkl")

@app.post("/predict")
def predict(data: dict):
    X = [[
        data["age"],
        data["bmi"],
        data["heartRate"],
        int(data["smoker"]),
        int(data["familyHistory"])
    ]]

    risk = model.predict(X)[0]
    score = float(model.predict_proba(X)[0][1])

    return {
        "riskScore": score,
        "riskLevel": "HIGH" if risk == 1 else "LOW"
    }
