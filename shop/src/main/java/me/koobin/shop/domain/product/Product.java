package me.koobin.shop.domain.product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.koobin.shop.domain.modelsize.ModelSizeInfo;
import me.koobin.shop.domain.sizechart.SizeChart;
import me.koobin.shop.domain.brand.Brand;
import me.koobin.shop.domain.category.Category;
import me.koobin.shop.utils.BaseTimeEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Product extends BaseTimeEntity {

  @Id
  @GeneratedValue
  private Long id; // 상품 아이디

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "CATEGORY_ID", nullable = false)
  private Category category; // 상품 카테고리

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private ProductGender productGender;

  @NotEmpty
  @Column(length = 100, nullable = false)
  private String exposedProductName; // 노출 상품명

  @NotEmpty
  @Column(length = 100, nullable = false)
  private String companyProductName; // 업체 상품명

  @Column(length = 20)
  private String additionalText; // 추가 상품명

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "BRAND_ID", nullable = false)
  private Brand brand; // 상품 브랜드

  private String productImportantNotes; // 상품 유의사항
  private String orderImportantNotes; // 주문 유의사항
  private String deliveryImportantNotes; // 배송 유의사항
  private String basicExplanation; // 상품 기본 설명

  @OneToMany(mappedBy = "product")
  @Builder.Default
  private List<ModelSizeInfo> modelSizeInfos = new ArrayList<>();

  @OneToMany(mappedBy = "product")
  @Builder.Default
  private List<SizeChart> sizeCharts = new ArrayList<>();

  @ElementCollection
  @CollectionTable(name = "product_season", joinColumns = @JoinColumn(name = "product_id"))
  @Column
  @Builder.Default
  private Set<Season> setSeason = new HashSet<>();

  @ElementCollection
  @CollectionTable(name = "clothing_form", joinColumns = @JoinColumn(name = "product_id"))
  @Column
  @Builder.Default
  private Set<ClothingForm> setClothingForm = new HashSet<>();

  @Column(nullable = false)
  @NotEmpty
  private String productName;
  @Column(nullable = false)
  private String manufacturer;
  @Column(nullable = false)
  private String countryManufacture;
  @Column(nullable = false)
  private String inquiry; // 문의
  @Column(nullable = false)
  private Long netPrice;
  @Column(nullable = false)
  private Long sellingPrice;


}

