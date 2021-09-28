package me.koobin.shop.domain;

import java.util.Base64;
import javax.persistence.Entity;
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
public class SizeChart extends BaseTimeEntity {

  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PRODUCT_ID")
  private Product product;

  private Integer sizeName; // 사이즈명
  private Integer totalLength; // 총길이
  private Integer shoulderWidth; // 어깨 너비
  private Integer chestWidth;// 가슴 너비
  private Integer sleeveLength; // 소매 길이
  private Integer waistWidth; // 허리 너비
  private Integer hipWidth; // 엉덩이 너비
  private Integer riseWidth; // 밑위 너비
  private Integer crotchWidth; // 가랑이 너비
  private Integer hemWidth; // 밑단 너비

  @Builder
  public SizeChart(Product product, Integer sizeName, Integer totalLength,
      Integer shoulderWidth, Integer chestWidth, Integer sleeveLength, Integer waistWidth,
      Integer hipWidth, Integer riseWidth, Integer crotchWidth, Integer hemWidth) {
    this.product = product;
    this.sizeName = sizeName;
    this.totalLength = totalLength;
    this.shoulderWidth = shoulderWidth;
    this.chestWidth = chestWidth;
    this.sleeveLength = sleeveLength;
    this.waistWidth = waistWidth;
    this.hipWidth = hipWidth;
    this.riseWidth = riseWidth;
    this.crotchWidth = crotchWidth;
    this.hemWidth = hemWidth;
    product.getSizeCharts().add(this);
  }
}