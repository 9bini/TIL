package me.koobin.shop.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentificationCodeRepository extends JpaRepository<IdentificationCode, Long> {
    Optional<IdentificationCode> findByCode(String code);
}
