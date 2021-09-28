package me.koobin.shop.api.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class SizeChartDto {

  private Integer sizeName; // 사이즈명
  private Integer totalLength; // 총길이
  private Integer shoulderWidth; // 어깨 너비
  private Integer chestWidth;// 가슴 너비
  private Integer sleeveLength; // 소매 길이
  private Integer waistWidth; // 허리 너비
  private Integer hipWidth; // 엉덩이 너비
  private Integer riseWidth; // 밑위 너비
  private Integer crotchWidth; // 가랑이 너비
  private Integer hemWidth; // 밑


}
