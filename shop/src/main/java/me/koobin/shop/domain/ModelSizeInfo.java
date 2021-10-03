package me.koobin.shop.domain;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import me.koobin.shop.utils.BaseTimeEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ModelSizeInfo extends BaseTimeEntity {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "PRODUCT_ID")
  private Product product;

  @Enumerated
  private Gender gender;
  private Float height;
  private Float weight;
  private String wearingSize;

  @Enumerated
  private FitType fitType;

  @Builder
  public ModelSizeInfo(Product product, Gender gender, Float height, Float weight,
      String wearingSize, FitType fitType) {
    this.product = product;
    this.gender = gender;
    this.height = height;
    this.weight = weight;
    this.wearingSize = wearingSize;
    this.fitType = fitType;
    product.getModelSizeInfos().add(this);
  }
}
