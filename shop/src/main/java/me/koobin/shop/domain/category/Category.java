package me.koobin.shop.domain.category;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.koobin.shop.utils.BaseTimeEntity;

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