package me.koobin.shop.service;

import java.util.ArrayList;
import java.util.List;
import me.koobin.shop.api.controller.dto.CreateProductDTO;
import me.koobin.shop.api.controller.dto.ModelSizeInfoDto;
import me.koobin.shop.api.controller.dto.SizeChartDto;
import me.koobin.shop.domain.Brand;
import me.koobin.shop.domain.BrandRepository;
import me.koobin.shop.domain.Category;
import me.koobin.shop.domain.CategoryRepository;
import me.koobin.shop.domain.ClothingForm;
import me.koobin.shop.domain.Color;
import me.koobin.shop.domain.ColorRepository;
import me.koobin.shop.domain.FitType;
import me.koobin.shop.domain.Gender;
import me.koobin.shop.domain.Product;
import me.koobin.shop.domain.ProductRepository;
import me.koobin.shop.domain.Season;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class ProductServiceTest {

  @Autowired
  ProductService productService;
  @Autowired
  ProductRepository productRepository;
  @Autowired
  CategoryRepository categoryRepository;
  @Autowired
  BrandRepository brandRepository;

  @Autowired
  ColorRepository colorRepository;

  @Test
  void create() {
    Category category = categoryRepository.save(Category.builder()
        .name("상품 등록용 카테고리")
        .build());

    Brand brand = brandRepository.save(Brand.builder()
        .name("상품 등록용 브랜드")
        .build());

    List<ModelSizeInfoDto> modelSizeInfoDtos = new ArrayList<>();
    modelSizeInfoDtos.add(ModelSizeInfoDto.builder()
        .fitType(FitType.OVER)
        .gender(Gender.MALE)
        .wearingSize("착용 사이즈")
        .height(180.1F)
        .weight(80.0F)
        .build());

    List<SizeChartDto> sizeChartDtos = new ArrayList<>();
    sizeChartDtos.add(SizeChartDto.builder()
        .sizeName(10) // 사이즈명
        .totalLength(10) // 총길이
        .shoulderWidth(10) // 어깨 너비
        .chestWidth(10) // 가슴너비
        .sleeveLength(10) // 소매 길이
        .hipWidth(10) //  엉덩이 너비
        .riseWidth(10)// 밑위 너비
        .crotchWidth(10)//가랑이 너비
        .hemWidth(10)// 밑단 너비
        .build());

    List<Season> seasonTypes = new ArrayList<>();
    seasonTypes.add(Season.CHANGE_SEASONS);

    List<ClothingForm> clothingForms = new ArrayList<>();
    clothingForms.add(ClothingForm.KNIT_SWEATER);
    List<Color> colors = new ArrayList<>();
    colors.add(Color.WHITE);

    Product product = productService.create(CreateProductDTO.builder()
        .exposedProductName("노출 상품명")
        .companyProductName("업체 상품명")
        .productImportantNotes("상품 유의사항")
        .orderImportantNotes("주문 유의사항")
        .deliveryImportantNotes("배송 유의 사항")
        .basicExplanation("상품 기본 설명")
        .categoryId(category.getId())
        .brandId(brand.getId())
        .modelSizeInfoDtos(modelSizeInfoDtos)
        .sizeCharts(sizeChartDtos)
        .tag("테그,")
        .seasons(seasonTypes)
        .clothingForm(clothingForms)
        .colors(colors)
        .build());

    // todo: 상품에 필수 데이터는 넣고 생각해보자
    // List<Color> colors = colorRepository.findByProduct(product);
    //Assertions.assertEquals(1, colors.size());

    Assertions.assertEquals(category, product.getCategory());
    Assertions.assertNotNull(product.getModelSizeInfos());
    Assertions.assertEquals(1, product.getModelSizeInfos().size());
    Assertions.assertEquals(1, product.getSizeCharts().size());
    Assertions.assertEquals(1, product.getSetSeason().size());
    Assertions.assertTrue(product.getSetSeason().contains(Season.CHANGE_SEASONS));
    Assertions.assertEquals(1, product.getSetClothingForm().size());
    Assertions.assertTrue(product.getSetClothingForm().contains(ClothingForm.KNIT_SWEATER));


  }

}