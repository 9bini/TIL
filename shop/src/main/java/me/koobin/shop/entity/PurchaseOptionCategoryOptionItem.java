package me.koobin.shop.entity;

import javax.persistence.*;

@Entity
public class PurchaseOptionCategoryOptionItem {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "purchase_option_id")
    private PurchaseOption purchaseOption;

    @ManyToOne
    @JoinColumn(name = "category_option_item_id")
    private CategoryOptionItem categoryOptionItem;

}
