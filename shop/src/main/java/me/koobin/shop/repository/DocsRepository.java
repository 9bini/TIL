package me.koobin.shop.repository;

import me.koobin.shop.entity.Docs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface DocsRepository extends JpaRepository<Docs, Long> {
}
