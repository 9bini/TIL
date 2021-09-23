package me.koobin.shop.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByParent_Id(Long parentID);
}
