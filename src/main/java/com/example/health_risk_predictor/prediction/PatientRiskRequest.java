package com.example.health_risk_predictor.prediction;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientRiskRequest {

    @Min(1)
    @Max(120)
    private int age;

    @Min(10)
    @Max(60)
    private double bmi;

    @Min(40)
    @Max(200)
    private int heartRate;

    private boolean smoker;

    private boolean familyHistory;
}
