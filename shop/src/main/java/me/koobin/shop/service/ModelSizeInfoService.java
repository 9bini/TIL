package me.koobin.shop.service;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CreateProductDTO;
import me.koobin.shop.api.controller.dto.ModelSizeInfoDto;
import me.koobin.shop.domain.ModelSizeInfo;
import me.koobin.shop.domain.ModelSizeInfoRepository;
import me.koobin.shop.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gutaegyun
 */
@Service @RequiredArgsConstructor @Transactional
public class ModelSizeInfoService {

  private final ModelSizeInfoRepository modelSizeInfoRepository;

  public void insertModelSizeInfos(CreateProductDTO createProductDTO, Product product) {
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
  }

}
