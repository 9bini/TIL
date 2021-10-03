package me.koobin.shop.service;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CreateProductDTO;
import me.koobin.shop.api.controller.dto.ProductOptionDto;
import me.koobin.shop.api.controller.dto.ProductOptionValueDto;
import me.koobin.shop.api.controller.dto.ProductOptionValueGroupOptionDto;
import me.koobin.shop.domain.product.ClothingForm;
import me.koobin.shop.domain.productoptionvaluegroup.ProductOptionValueGroup;
import me.koobin.shop.domain.productoptionvaluegroupoption.ProductOptionValueGroupOption;
import me.koobin.shop.domain.productoptionvaluegroupoption.ProductOptionValueGroupOptionRepository;
import me.koobin.shop.domain.productoptionvaluegroup.ProductOptionValueGroupRepository;
import me.koobin.shop.domain.product.Season;
import me.koobin.shop.domain.brand.Brand;
import me.koobin.shop.domain.category.Category;
import me.koobin.shop.domain.product.Product;
import me.koobin.shop.domain.product.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  private final CategoryService categoryService;
  private final TagProductService tagProductService;
  private final BrandService brandService;
  private final ModelSizeInfoService modelSizeInfoService;
  private final SizeChartService sizeChartService;


  private final ProductColorService productColorService;
  private final SizeService sizeService;
  private final ProductOptionService productOptionService;
  private final ProductOptionValueGroupOptionService productOptionValueGroupOptionService;

  public Product processCreate(CreateProductDTO createProductDTO) {

    Category category = categoryService.category(createProductDTO.getCategoryId());
    Brand brand = brandService.brand(createProductDTO.getBrandId());
    Product product = productRepository.save(newProduct(createProductDTO, category, brand));

    modelSizeInfoService.insertModelSizeInfos(createProductDTO, product);
    sizeChartService.insertSizeCharts(createProductDTO, product);
    tagProductService.insertTags(createProductDTO, product);
    addSeasons(createProductDTO, product);
    addClothingForms(createProductDTO, product);
    productColorService.insertProductColors(createProductDTO, product);
    sizeService.insertSizes(createProductDTO, product);

    productOptionService.saveNewProductOptions(createProductDTO);
    productOptionValueGroupOptionService.processProductOptionValueGroupOption(createProductDTO);

    return product;
  }

  private void addClothingForms(CreateProductDTO createProductDTO, Product product) {
    for (ClothingForm clothingForm : createProductDTO.getClothingForm()) {
      product.getSetClothingForm().add(clothingForm);
    }
  }

  private void addSeasons(CreateProductDTO createProductDTO, Product product) {
    for (Season season : createProductDTO.getSeasons()) {
      product.getSetSeason().add(season);
    }
  }

  private Product newProduct(CreateProductDTO createProductDTO, Category category, Brand brand) {
    return Product.builder()
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
        .build();
  }
}
