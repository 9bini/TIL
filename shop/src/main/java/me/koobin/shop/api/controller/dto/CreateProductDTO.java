package me.koobin.shop.api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.koobin.shop.domain.ProductGender;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class CreateProductDTO {
    @NotNull(message = "카테고리는 필수 입니다.")
    private Long categoryId;

    @NotNull(message = "상품 성별은 필수 입니다.")
    private ProductGender productGender;

    @Max(value = 100)
    @NotNull(message = "노출 상품명은 필수 입니다.")
    private String exposedProductName;

    @Max(value = 100)
    @NotNull(message = "업체상품명은 필수 입니다.")
    private String companyProductName;

    private String additionalText;

    @NotNull(message = "브랜드는 필수 입니다.")
    private Long brand;

    private String productPrecautions;
    private String orderPrecautions;
    private String deliveryPrecautions;
    private String basicExplanation;
    private List<ModelSizeInfoDto> modelSizeInfoDtos = new ArrayList<>();
    private List<SizeChartDto> sizeCharts = new ArrayList<>();

    // TODO 리스트에서 문자열로 변경 서버에서 문자열을 짤라서 처리
    private List<String> tags;

    private List<Long> seasons = new ArrayList<>();
    private List<Long> forms = new ArrayList<>();
    private List<Long> colors = new ArrayList<>();
    private List<Long> sizes = new ArrayList<>();

    private String productName;
    private String manufacturer;
    private String countryManufacture;
    private String inquiry;

    @NotNull(message = "정가는 필수 입니다.")
    private Long netPrice;
    @NotNull(message = "판매가는 필수 입니다.")
    private Long sellingPrice;

    private List<OptionDTO> optionDTOs = new ArrayList<>();
    private List<OptionDetailDTO> optionDetailDTOs = new ArrayList<>();


}
