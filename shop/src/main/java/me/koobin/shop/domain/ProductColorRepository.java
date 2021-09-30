package me.koobin.shop.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductColorRepository extends JpaRepository<ProductColor, Long> {

  List<ProductColor> findByProduct(Product product);
}
