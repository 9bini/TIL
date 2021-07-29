package me.koobin.shop.entity;


import javax.persistence.*;

@Entity
public class PurchaseOptionSearchTerm {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "purchase_option_id")
    private PurchaseOption purchaseOption;

    @ManyToOne
    @JoinColumn(name = "search_term_id")
    private SearchTerm searchTerm;
}
