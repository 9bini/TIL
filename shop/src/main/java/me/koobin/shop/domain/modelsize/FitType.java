package me.koobin.shop.domain.modelsize;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.koobin.shop.utils.EnumType;

@Getter
@RequiredArgsConstructor
public enum FitType implements EnumType {
  REGULAR("레귤러"),
  OVER("오버"),
  SKINNY("스키니"),
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
