package me.koobin.shop.api.controller.dto;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.koobin.shop.domain.ClothingForm;
import me.koobin.shop.domain.ColorType;
import me.koobin.shop.domain.ProductGender;
import me.koobin.shop.domain.Season;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private Long brandId;

    private String productImportantNotes;
    private String orderImportantNotes;
    private String deliveryImportantNotes;
    private String basicExplanation;
    @Builder.Default
    private List<ModelSizeInfoDto> modelSizeInfoDtos = new ArrayList<>();
    @Builder.Default
    private List<SizeChartDto> sizeCharts = new ArrayList<>();

    @NotEmpty
    private String tag;
    @Builder.Default
    private List<Season> seasons = new ArrayList<>();
    @Builder.Default
    private List<ClothingForm> clothingForm = new ArrayList<>();
    @Builder.Default
    private List<ColorType> colorTypes = new ArrayList<>();
    private List<Long> sizes;

    private String productName;
    private String manufacturer;
    private String countryManufacture;
    private String inquiry;

    @NotNull(message = "정가는 필수 입니다.")
    private Long netPrice;
    @NotNull(message = "판매가는 필수 입니다.")
    private Long sellingPrice;

    private List<OptionDTO> optionDTOs;
    private List<OptionDetailDTO> optionDetailDTOs;
}
