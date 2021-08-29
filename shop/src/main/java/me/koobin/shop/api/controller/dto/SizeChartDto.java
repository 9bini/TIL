package me.koobin.shop.api.controller.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class SizeChartDto {
    private Integer sizeName;
    private Integer totalLength;
    private Integer shoulderWidth;
    private Integer sleeveLength;
    private Integer waistWidth;
    private Integer hipWidth;
    private Integer crotchWidth;
    private Integer thighWidth;
    private Integer hemWidth;


}
