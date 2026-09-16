package com.example.health_risk_predictor.patient;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;
    private String gender;
    private double bmi;

    private int systolicBP;
    private int diastolicBP;

    private int heartRate;
    private boolean smoker;
    private boolean diabeticFamilyHistory;
}
