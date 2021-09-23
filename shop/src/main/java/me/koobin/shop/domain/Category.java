package me.koobin.shop.domain;

import lombok.*;
import me.koobin.shop.utils.BaseTimeEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder @Getter
public class Category  extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;


    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category parent;

    public void update(String name, Category parent){
        this.name = name;
        this.parent = parent;
    }
}