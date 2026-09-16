package com.example.health_risk_predictor.prediction;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PredictionHistoryRepository
        extends JpaRepository<PredictionHistory, Long> {

    List<PredictionHistory> findByUsername(String username);
}
