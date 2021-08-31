package me.koobin.shop.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IdentificationCodeRepository extends JpaRepository<IdentificationCode, Long> {
    Optional<IdentificationCode> findByCode(String code);
}
