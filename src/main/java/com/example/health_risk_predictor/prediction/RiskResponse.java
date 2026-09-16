package com.example.health_risk_predictor.prediction;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiskResponse {

    private double riskScore;
    private String riskLevel;
    private String recommendation;
}
