package me.koobin.shop.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.koobin.shop.utils.EnumType;

/**
 * @author gutaegyun
 */
@Getter
@RequiredArgsConstructor
public enum ClothingForm implements EnumType {
  T_SHIRT("티셔츠"), HOODIE("후드티"), PADDING_COAT_OUTER("패딩/코트/아우터"), ALL_IN_ONE("올인원")
  , KNIT_SWEATER("니트/스웨터"), RAIN_COAT("레인코드"), HANBOK("한복"), COSTUME("코스튬"), PANTS("바지"),
  ;
  private final String message;


  @Override
  public String getId() {
    return name();
  }

  @Override
  public String getText() {
    return message;
  }
}
