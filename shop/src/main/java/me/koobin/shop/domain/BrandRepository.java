package me.koobin.shop.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<TagProduct.Brand, Long> {
}
