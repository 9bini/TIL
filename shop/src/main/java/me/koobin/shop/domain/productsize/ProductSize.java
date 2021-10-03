package me.koobin.shop.domain.productsize;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.NoArgsConstructor;
import me.koobin.shop.domain.product.Product;
import me.koobin.shop.utils.BaseTimeEntity;

/**
 * @author gutaegyun
 */
@Entity @NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "sizeType"}))
public class ProductSize extends BaseTimeEntity {

  @Id @GeneratedValue
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "product_id")
  private Product product;


  @Enumerated(EnumType.STRING)
  private SizeType sizeType;

  public ProductSize(Product product, SizeType sizeType) {
    this.product = product;
    this.sizeType = sizeType;
  }
}
