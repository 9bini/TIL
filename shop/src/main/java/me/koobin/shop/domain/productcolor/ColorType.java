package me.koobin.shop.domain.productcolor;

import java.awt.Color;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.koobin.shop.utils.EnumType;

@Getter
@RequiredArgsConstructor
public enum ColorType implements EnumType {
  RED(java.awt.Color.red), BLUE(java.awt.Color.BLUE), YELLOW(java.awt.Color.YELLOW), BLACK(
      java.awt.Color.BLACK), GRAY(java.awt.Color.GRAY), WHITE(java.awt.Color.white), GREEN(
      java.awt.Color.GREEN), ORANGE(java.awt.Color.ORANGE);

  private final Color color;

  @Override
  public String getId() {
    return name();
  }

  @Override
  public String getText() {
    return String.valueOf(color.getRGB());
  }
}
