package me.koobin.shop.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CreateProductDTO;
import me.koobin.shop.domain.Product;
import me.koobin.shop.domain.Tag;
import me.koobin.shop.domain.TagProduct;
import me.koobin.shop.domain.TagProductRepository;
import me.koobin.shop.domain.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gutaegyun
 */
@Service @Transactional
@RequiredArgsConstructor
public class TagProductService {
  private final TagRepository tagRepository;
  private final TagProductRepository tagProductRepository;

  public void insertTags(CreateProductDTO createProductDTO, Product product) {
    String[] tagTitles = createProductDTO.getTag().split(",");
    List<Tag> tags = tagRepository.findByTitleIn(Arrays.asList(tagTitles));
    Set<String> setTitle = new HashSet<>(List.of(tagTitles));

    for (Tag tag : tags)setTitle.remove(tag.getTitle());

    for (String title : setTitle) {
      Tag tag = tagRepository.save(Tag.builder().title(title).build());
      tagProductRepository.save(new TagProduct(tag, product));
    }
  }
}
