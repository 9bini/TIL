package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Book {
    @Id
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String author;
}
