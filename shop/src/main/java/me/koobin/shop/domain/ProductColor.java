package me.koobin.shop.domain;

import javax.persistence.Column;
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
import me.koobin.shop.utils.BaseTimeEntity;

/**
 * @author gutaegyun
 */
@Entity @NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"product_id", "colorType"}))
public class ProductColor extends BaseTimeEntity {

  @Id
  @GeneratedValue
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ColorType colorType;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "product_id")
  private Product product;

  public ProductColor(ColorType colorType, Product product) {
    this.colorType = colorType;
    this.product = product;
  }
}
