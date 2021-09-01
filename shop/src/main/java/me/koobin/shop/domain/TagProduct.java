package me.koobin.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import me.koobin.shop.embedded.BaseTimeEntity;

import javax.persistence.*;

@Entity @NoArgsConstructor
public class TagProduct {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TAG_ID", nullable = false)
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    public TagProduct(Tag tag, Product product) {
        this.tag = tag;
        this.product = product;
    }

    @Entity
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Product {
        @Id
        @GeneratedValue
        private Long id;

        @ManyToOne
        @JoinColumn(name = "CATEGORY_ID", nullable = false)
        private TagRepository.Category category;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private ProductGender productGender;

        @Column(length = 100, nullable = false)
        private String exposedProductName;

        @Column(length = 100, nullable = false)
        private String companyProductName;

        @Column(length = 20, nullable = false)
        private String additionalText;

        @ManyToOne
        @JoinColumn(name = "BRAND_ID", nullable = false)
        private Brand brand;

        private String productPrecautions;
        private String orderPrecautions;
        private String deliveryPrecautions;
        private String basicExplanation;

        @Column(nullable = false)
        private String productName;
        @Column(nullable = false)
        private String manufacturer;
        @Column(nullable = false)
        private String countryManufacture;
        @Column(nullable = false)
        private String inquiry;
        @Column(nullable = false)
        private Long netPrice;
        @Column(nullable = false)
        private Long sellingPrice;
        @Column(nullable = false)
        private Long discountRate;
        @Column(nullable = false)
        private Long mileage;


        @Embedded
        private BaseTimeEntity baseTimeEntity;


        public static Product newProduct(TagRepository.Category category, Brand brand, ProductGender productGender, String exposedProductName
                , String companyProductName, String additionalText, String productPrecautions, String orderPrecautions
                , String deliveryPrecautions, String basicExplanation, String productName, String manufacturer
                , String countryManufacture, String inquiry, Long netPrice, Long sellingPrice, Long discountRate) {
            // THING 마일리지 값을 저장해서 처리하는 것이 좋을까 아니면 사용자 등급에 따라 마일리지를 처리하는게 좋을 까
            // THING 이것도 물로 운영치침에 따라 변경되 겠지
            return Product.builder()
                    .category(category)
                    .brand(brand)
                    .productGender(productGender)
                    .exposedProductName(exposedProductName)
                    .companyProductName(companyProductName)
                    .additionalText(additionalText)
                    .productPrecautions(productPrecautions)
                    .orderPrecautions(orderPrecautions)
                    .deliveryPrecautions(deliveryPrecautions)
                    .basicExplanation(basicExplanation)
                    .productName(productName)
                    .manufacturer(manufacturer)
                    .countryManufacture(countryManufacture)
                    .inquiry(inquiry)
                    .netPrice(netPrice)
                    .sellingPrice(sellingPrice)
                    .discountRate(discountRate)
                    .mileage(1L)
                    .build();
        }

    }

    @Table(name = "brand")
    @Entity
    public static class Brand {
        @Id
        @Column(name = "id", nullable = false)
        @GeneratedValue
        private Long id;


    }
}
