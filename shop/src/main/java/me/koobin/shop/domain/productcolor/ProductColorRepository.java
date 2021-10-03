package me.koobin.shop.domain.productcolor;

import java.util.List;
import me.koobin.shop.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductColorRepository extends JpaRepository<ProductColor, Long> {

  List<ProductColor> findByProduct(Product product);
}
