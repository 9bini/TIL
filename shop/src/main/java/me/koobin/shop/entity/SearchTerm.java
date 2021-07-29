package me.koobin.shop.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SearchTerm {

    @Id
    @GeneratedValue
    private Long id;

    private String term;
}
