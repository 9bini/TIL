package me.koobin.shop.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<ProductColor, Long> {

  List<ProductColor> findByProduct(Product product);
}
