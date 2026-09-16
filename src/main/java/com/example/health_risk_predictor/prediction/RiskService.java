package com.example.health_risk_predictor.prediction;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RiskService {

    private final WebClient webClient;
    private final PredictionHistoryRepository historyRepository;

    public RiskResponse calculateRisk(PatientRiskRequest req) {

        Map<String, Object> response = webClient.post()
                .uri("/predict")
                .bodyValue(req)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        double riskScore = ((Number) response.get("riskScore")).doubleValue();
        String riskLevel = (String) response.get("riskLevel");

        String username = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        PredictionHistory history = new PredictionHistory();
        history.setAge(req.getAge());
        history.setBmi(req.getBmi());
        history.setHeartRate(req.getHeartRate());
        history.setSmoker(req.isSmoker());
        history.setFamilyHistory(req.isFamilyHistory());
        history.setRiskScore(riskScore);
        history.setRiskLevel(riskLevel);
        history.setUsername(username);
        history.setPredictedAt(LocalDateTime.now());

        historyRepository.save(history);

        return RiskResponse.builder()
                .riskScore(riskScore)
                .riskLevel(riskLevel)
                .recommendation("AI-generated preventive recommendation")
                .build();
    }
}
