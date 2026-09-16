package com.example.health_risk_predictor.prediction;

import com.example.health_risk_predictor.common.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/risk")
@RequiredArgsConstructor
public class RiskController {

    private final RiskService riskService;
    private final PredictionHistoryRepository historyRepository;

    @PostMapping("/predict")
    public ApiResponse<RiskResponse> predict(
            @Valid @RequestBody PatientRiskRequest request) {

        return new ApiResponse<>(
                true,
                riskService.calculateRisk(request),
                "Risk calculated successfully"
        );
    }

    @GetMapping("/history")
    public ApiResponse<List<PredictionHistory>> history(
            @AuthenticationPrincipal UserDetails user) {

        return new ApiResponse<>(
                true,
                historyRepository.findByUsername(user.getUsername()),
                "Prediction history fetched"
        );
    }
}
