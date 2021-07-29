package me.koobin.shop.entity;


import javax.persistence.*;

@Entity
public class PurchaseOption {

    @Id @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private ProductState productState;

    private String productStatusDetails;

    private Long sellingPrice;

    private Double standardPriceDiscountRate;

    private Long inventoryQuantity;

    private String detailedDescription;

    private String barCodeNumber;

    private String sellerProductCode;

    private String modelNumber;


    @OneToOne
    @JoinColumn(name = "representative_image_ID")
    private RepresentativeImage representativeImage;

}
