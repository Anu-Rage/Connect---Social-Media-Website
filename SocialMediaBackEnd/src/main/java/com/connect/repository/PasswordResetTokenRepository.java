package com.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.connect.model.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {

	PasswordResetToken findByToken(String token);

}
