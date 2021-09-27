package me.koobin.shop.domain;

import lombok.*;
import me.koobin.shop.utils.BaseTimeEntity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category parent;

    @Builder
    public Category(String name, Category parent) {
        this.name = name;
        this.parent = parent;
        if (parent != null)parent.getChildren().add(this);
    }

    @OneToMany(mappedBy = "parent")
    private List<Category> children = new ArrayList<>();

    public void update(String name, Category parent) {
        this.name = name;
        this.parent = parent;
    }
}