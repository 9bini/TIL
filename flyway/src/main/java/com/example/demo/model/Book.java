package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter @Setter
@Table(name = "books")
public class Book {
    @Id
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String author;
}
