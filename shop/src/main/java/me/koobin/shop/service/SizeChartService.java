package me.koobin.shop.service;

import lombok.RequiredArgsConstructor;
import me.koobin.shop.api.controller.dto.CreateProductDTO;
import me.koobin.shop.api.controller.dto.SizeChartDto;
import me.koobin.shop.domain.product.Product;
import me.koobin.shop.domain.sizechart.SizeChart;
import me.koobin.shop.domain.sizechart.SizeChartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gutaegyun
 */
@Service
@RequiredArgsConstructor @Transactional
public class SizeChartService {

  private final SizeChartRepository sizeChartRepository;

  public void insertSizeCharts(CreateProductDTO createProductDTO, Product product) {
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
  }
}
