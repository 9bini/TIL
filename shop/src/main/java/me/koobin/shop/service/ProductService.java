package me.koobin.shop.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CreateProductDTO;
import me.koobin.shop.api.controller.dto.ModelSizeInfoDto;
import me.koobin.shop.api.controller.dto.ProductOptionDetailDto;
import me.koobin.shop.api.controller.dto.ProductOptionDto;
import me.koobin.shop.api.controller.dto.ProductOptionValueDto;
import me.koobin.shop.api.controller.dto.SizeChartDto;
import me.koobin.shop.domain.Brand;
import me.koobin.shop.domain.BrandRepository;
import me.koobin.shop.domain.Category;
import me.koobin.shop.domain.CategoryRepository;
import me.koobin.shop.domain.ModelSizeInfo;
import me.koobin.shop.domain.ModelSizeInfoRepository;
import me.koobin.shop.domain.Product;
import me.koobin.shop.domain.ProductColor;
import me.koobin.shop.domain.ProductColorRepository;
import me.koobin.shop.domain.ProductOption;
import me.koobin.shop.domain.ProductOptionRepository;
import me.koobin.shop.domain.ProductOptionValue;
import me.koobin.shop.domain.ProductOptionValueRepository;
import me.koobin.shop.domain.ProductRepository;
import me.koobin.shop.domain.ProductSize;
import me.koobin.shop.domain.ProductSizeRepository;
import me.koobin.shop.domain.SizeChart;
import me.koobin.shop.domain.SizeChartRepository;
import me.koobin.shop.domain.Tag;
import me.koobin.shop.domain.TagProduct;
import me.koobin.shop.domain.TagProductRepository;
import me.koobin.shop.domain.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;
  private final BrandRepository brandRepository;
  private final ModelSizeInfoRepository modelSizeInfoRepository;
  private final SizeChartRepository sizeChartRepository;
  private final TagRepository tagRepository;
  private final TagProductRepository tagProductRepository;
  private final ProductColorRepository productColorRepository;
  private final ProductSizeRepository productSizeRepository;
  private final ProductOptionRepository productOptionRepository;
  private final ProductOptionValueRepository productOptionValueRepository;

  public Product create(CreateProductDTO createProductDTO) {
    Category category = categoryRepository.findById(createProductDTO.getCategoryId())
        .orElseThrow(IllegalArgumentException::new);

    Brand brand = brandRepository.findById(createProductDTO.getBrandId())
        .orElseThrow(IllegalArgumentException::new);

    Product product = productRepository.save(
        Product.builder()
            .productGender(createProductDTO.getProductGender())
            .exposedProductName(createProductDTO.getExposedProductName())  // 노출 상품명
            .companyProductName(createProductDTO.getCompanyProductName()) // 업체 상품명
            .productImportantNotes(createProductDTO.getProductImportantNotes()) // 상품 유의사항
            .orderImportantNotes(createProductDTO.getOrderImportantNotes()) // 주문 사항
            .deliveryImportantNotes(createProductDTO.getDeliveryImportantNotes()) // 배송 유의 사항
            .basicExplanation(createProductDTO.getBasicExplanation()) // 상품 기본 설명
            .category(category)
            .brand(brand)
            .productName(createProductDTO.getProductName())
            .manufacturer(createProductDTO.getManufacturer())
            .countryManufacture(createProductDTO.getCountryManufacture())
            .inquiry(createProductDTO.getInquiry())
            .netPrice(createProductDTO.getNetPrice())
            .sellingPrice(createProductDTO.getSellingPrice())
            .build()
    );

    for (ModelSizeInfoDto modelSizeInfoDto : createProductDTO.getModelSizeInfoDtos()) {
      modelSizeInfoRepository.save(ModelSizeInfo.builder()
          .fitType(modelSizeInfoDto.getFitType()) // 착용 사이즈 핏
          .gender(modelSizeInfoDto.getGender()) // 성별
          .wearingSize(modelSizeInfoDto.getWearingSize()) // 모델
          .product(product)
          .height(modelSizeInfoDto.getHeight()) // 키
          .weight(modelSizeInfoDto.getWeight()) // 무게
          .build());
    }

    for (SizeChartDto sizeChart : createProductDTO.getSizeCharts()) {
      sizeChartRepository.save(SizeChart.builder()
          .product(product)
          .sizeName(sizeChart.getSizeName())  // 사이즈명
          .totalLength(sizeChart.getTotalLength())  // 총길이
          .shoulderWidth(sizeChart.getShoulderWidth())  // 어깨 너비
          .chestWidth(sizeChart.getChestWidth())  // 가슴너비
          .sleeveLength(sizeChart.getSleeveLength())  // 소매 길이
          .hipWidth(sizeChart.getHipWidth())  //  엉덩이 너비
          .riseWidth(sizeChart.getRiseWidth()) // 밑위 너비
          .crotchWidth(sizeChart.getCrotchWidth()) //가랑이 너비
          .hemWidth(sizeChart.getHemWidth()) // 밑단 너비
          .build());
    }

    String[] tagTitles = createProductDTO.getTag().split(",");
    List<Tag> tags = tagRepository.findByTitleIn(Arrays.asList(tagTitles));
    Set<String> setTitle = new HashSet<>(List.of(tagTitles));

    for (Tag tag : tags) {
      setTitle.remove(tag.getTitle());
    }
    for (String s : setTitle) {
      Tag tag = tagRepository.save(Tag.builder().title(s).build());
      tagProductRepository.save(new TagProduct(tag, product));
    }

    createProductDTO.getSeasons().forEach(season -> product.getSetSeason().add(season));
    createProductDTO.getClothingForm()
        .forEach(clothingForm -> product.getSetClothingForm().add(clothingForm));

    createProductDTO.getColorTypes().stream().map(colorType -> new ProductColor(colorType, product))
        .forEach(productColorRepository::save);

    createProductDTO.getSizes().stream().map(size -> new ProductSize(product, size))
        .forEach(productSizeRepository::save);

    for (ProductOptionDto productOptionDto : createProductDTO.getProductOptionDtos()) {
      ProductOption productOption = productOptionRepository.save(
          ProductOption.builder()
              .requireOption(productOptionDto.getRequire())
              .name(productOptionDto.getOptionName())
              .build()
      );

      for (ProductOptionValueDto productOptionValueDto : productOptionDto.getProductOptionValueDtos()) {
        ProductOptionValue productOptionValue = productOptionValueRepository.save(
            ProductOptionValue.builder()
                .productOption(productOption)
                .additionalAmount(productOptionValueDto.getAdditionalAmount())
                .valueName(productOptionValueDto.getValueName())
                .supplyPrice(productOptionValueDto.getSupplyPrice())
                .build()
        );
        productOptionValueDto.setEntityId(productOptionValue.getId());
      }
    }

    return product;
  }
}
