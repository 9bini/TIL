package me.koobin.shop.domain;

import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag,Long> {
    List<Tag> findByTitleIn(Collection<String> title);


}
