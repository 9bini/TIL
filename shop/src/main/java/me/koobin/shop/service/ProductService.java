package me.koobin.shop.service;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.*;
import me.koobin.shop.domain.*;
import me.koobin.shop.entity.Brand;
import me.koobin.shop.entity.Category;
import me.koobin.shop.entity.Product;
import me.koobin.shop.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private final IdentificationDetailCodeRepository identificationDetailCodeRepository;
    private final SearchFilterContentProductRepository searchFilterContentProductRepository;
    private final ProductOptionRepository productOptionRepository;
    private final ProductOptionDetailRepository productOptionDetailRepository;
    private final ProductOptionValueRepository productOptionValueRepository;


    public void newProduct(CreateProductDTO createProductDTO) {
        Product product = getNewProduct(createProductDTO);
        productRepository.save(product);
        insertModelSize(product, createProductDTO.getModelSizeInfoDtos());
        insertSizeChart(product, createProductDTO.getSizeCharts());
        insertKeyWord(product, createProductDTO.getTags());
        processSearchFilter(product, createProductDTO);
        insertProductOption(product, createProductDTO);
    }

    private void insertProductOption(Product product, CreateProductDTO createProductDTO) {
        List<OptionDTO> optionDTOs = createProductDTO.getOptionDTOs();
        List<OptionDetailDTO> optionDetailDTOs = createProductDTO.getOptionDetailDTOs();
        for (OptionDTO optionDTO : optionDTOs) {
            ProductOption productOption = productOptionRepository.save(new ProductOption(product
                    , optionDTO.getOptionName(), optionDTO.getRequire()));

            for (OptionValueDTO optionValueDTO : optionDTO.getOptionValueDTOs()) {
                ProductOptionValue productOptionValue = productOptionValueRepository.save(new ProductOptionValue(productOption, optionValueDTO.getValue()
                        , optionValueDTO.getAdditionalAmount(), optionValueDTO.getSupplyPrice()));
                for (OptionDetailDTO optionDetailDTO : optionDetailDTOs) {
                    if (optionDTO.getIndex() == optionDetailDTO.getOptionIndex()
                            && optionValueDTO.getIndex() == optionDetailDTO.getOptionValueIndex()){
                        productOptionDetailRepository.save(new ProductOptionDetail(productOption, productOptionValue
                                , optionDetailDTO.getOptionAdditionalPrice(), optionDetailDTO.getMaxPurchaseQuantity(),optionDetailDTO.getMaxUnlimited(), optionDetailDTO.getSalesStatus(), optionDetailDTO.getQuantityUnlimited(), optionDetailDTO.getQuantity()));

                    }
                }
            }

        }

    }

    private void processSearchFilter(Product product, CreateProductDTO createProductDTO) {
        List<Long> colors = createProductDTO.getColors();
        callRepetitionInsertSearchFilterContentProduct(product, colors);
        List<Long> seasons = createProductDTO.getSeasons();
        callRepetitionInsertSearchFilterContentProduct(product, seasons);
        List<Long> forms = createProductDTO.getForms();
        callRepetitionInsertSearchFilterContentProduct(product, forms);
        List<Long> sizes = createProductDTO.getSizes();
        callRepetitionInsertSearchFilterContentProduct(product, sizes);
    }

    private void callRepetitionInsertSearchFilterContentProduct(Product product, List<Long> identificationDetailCodeIds) {
        for (Long identificationDetailCodeId : identificationDetailCodeIds) {
            IdentificationDetailCode identificationDetailCode = identificationDetailCodeRepository.findById(identificationDetailCodeId).orElseThrow(IllegalArgumentException::new);
            searchFilterContentProductRepository.save(new SearchFilterContentProduct(identificationDetailCode, product));
        }
    }

    private List<Tag> insertKeyWord(Product product, List<String> tags) {
        List<Tag> result = new ArrayList<>();
        for (String tag : tags) {
            Tag tagEntity = getTag(tag);
            tagProductRepository.save(new TagProduct(tagEntity, product));
        }
        return result;
    }

    private Tag getTag(String tag) {
        Optional<Tag> byTitle = tagRepository.findByTitle(tag);
        return !byTitle.isPresent() ? tagRepository.save(Tag.builder().title(tag).build()) : byTitle.orElseThrow(IllegalArgumentException::new);
    }

    private List<SizeChart> insertSizeChart(Product product, List<SizeChartDto> sizeCharts) {
        List<SizeChart> result = new ArrayList<>();
        for (SizeChartDto sizeChartDto : sizeCharts) {
            SizeChart save = sizeChartRepository.save(SizeChart.builder()
                    .product(product)
                    .sizeName(sizeChartDto.getSizeName())
                    .crotchWidth(sizeChartDto.getCrotchWidth())
                    .hemWidth(sizeChartDto.getHemWidth())
                    .hipWidth(sizeChartDto.getHipWidth())
                    .shoulderWidth(sizeChartDto.getShoulderWidth())
                    .sleeveLength(sizeChartDto.getSleeveLength())
                    .thighWidth(sizeChartDto.getThighWidth())
                    .totalLength(sizeChartDto.getTotalLength())
                    .waistWidth(sizeChartDto.getWaistWidth())
                    .build());
            result.add(save);
        }
        return result;
    }

    private List<ModelSizeInfo> insertModelSize(Product product, List<ModelSizeInfoDto> modelSizeInfoDtos) {
        List<ModelSizeInfo> result = new ArrayList<>();
        for (ModelSizeInfoDto modelSizeInfoDto : modelSizeInfoDtos) {
            ModelSizeInfo save = modelSizeInfoRepository.save(ModelSizeInfo.builder()
                    .product(product)
                    .gender(modelSizeInfoDto.getGender())
                    .height(modelSizeInfoDto.getHeight())
                    .weight(modelSizeInfoDto.getWeight())
                    .wearingSize(modelSizeInfoDto.getWearingSize())
                    .fitType(modelSizeInfoDto.getFitType())
                    .build());
            result.add(save);
        }
        return result;

    }

    private Product getNewProduct(CreateProductDTO createProductDTO) {
        Category category = categoryRepository
                .findById(createProductDTO.getCategoryId())
                .orElseThrow(NotFoundException::new);
        Brand brand = brandRepository
                .findById(createProductDTO.getBrand())
                .orElseThrow(NotFoundException::new);

        ProductGender productGender = createProductDTO.getProductGender();

        String exposedProductName = createProductDTO.getExposedProductName();// 노출 상품명
        String companyProductName = createProductDTO.getCompanyProductName();// 회사 상품명
        String additionalText = createProductDTO.getAdditionalText();
        String productPrecautions = createProductDTO.getProductPrecautions(); // 상품 유의사항
        String orderPrecautions = createProductDTO.getOrderPrecautions(); // 제품 유의사항
        String deliveryPrecautions = createProductDTO.getDeliveryPrecautions();// 배송 유의사항
        String basicExplanation = createProductDTO.getBasicExplanation();// 상품 기본 설정
        String productName = createProductDTO.getProductName();

        String manufacturer = createProductDTO.getManufacturer(); // 제조사
        String countryManufacture = createProductDTO.getCountryManufacture(); // 제조국
        String inquiry = createProductDTO.getInquiry(); //

        Long netPrice = createProductDTO.getNetPrice();
        Long sellingPrice = createProductDTO.getSellingPrice();
        Long discountRate = getDiscountRate(sellingPrice, netPrice);

        return Product.newProduct(category,
                brand,
                productGender,
                exposedProductName,
                companyProductName,
                additionalText,
                productPrecautions,
                orderPrecautions,
                deliveryPrecautions,
                basicExplanation,
                productName,
                manufacturer,
                countryManufacture,
                inquiry,
                netPrice,
                sellingPrice,
                discountRate);
    }

    private Long getDiscountRate(Long sellingPrice, Long netPrice) {
        return sellingPrice > netPrice ? 0L : 100L - ((sellingPrice / netPrice) * 100);
    }


}
