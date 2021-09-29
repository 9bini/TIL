package me.koobin.shop.domain;

import java.awt.Color;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.koobin.shop.utils.EnumType;

@Getter
@RequiredArgsConstructor
public enum ColorType implements EnumType {
  RED(Color.red), BLUE(Color.BLUE), YELLOW(Color.YELLOW), BLACK(
      Color.BLACK), GRAY(Color.GRAY), WHITE(Color.white), GREEN(Color.GREEN), ORANGE(Color.ORANGE);

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
