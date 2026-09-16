package com.example.health_risk_predictor.prediction;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PredictionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;
    private double bmi;
    private int heartRate;
    private boolean smoker;
    private boolean familyHistory;

    private double riskScore;
    private String riskLevel;

    private String username;
    private LocalDateTime predictedAt;
}
