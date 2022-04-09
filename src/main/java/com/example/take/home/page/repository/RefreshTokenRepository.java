package com.example.take.home.page.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.example.take.home.page.model.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    void deleteByToken(String token);
}
