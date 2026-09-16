package com.example.health_risk_predictor.auth;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")   // 👈 IMPORTANT
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String role;
}
