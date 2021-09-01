package me.koobin.shop.domain;

import me.koobin.shop.converter.BooleanToYNConverter;
import me.koobin.shop.embedded.BaseTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag,Long> {
    Optional<Tag> findByTitle(String tag);

    @Entity
    class Category {
        @Id
        @GeneratedValue
        private Long id;

        @Column(nullable = false)
        private String name;

        @ManyToOne
        @JoinColumn(name = "CATEGORY_ID")
        private Category parent;

        // 카테고리 순서를 정하기 위해서
        private Long sort;

        @Convert(converter = BooleanToYNConverter.class)
        @Column(nullable = false)
        private Boolean disabled;

        private Double sellingCommission;

        @Embedded
        private BaseTimeEntity baseTimeEntity;


    }
}
