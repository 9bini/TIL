package me.koobin.shop.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Long> {

  List<Color> findByProduct(Product product);
}
