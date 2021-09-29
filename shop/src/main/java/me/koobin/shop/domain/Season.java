package me.koobin.shop.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.koobin.shop.utils.EnumType;

@Getter @RequiredArgsConstructor
public enum Season implements EnumType {
    CHANGE_SEASONS("간절기용")
    , SUMMER("여름용")
    , WINTER("겨울용")
    , FOUR_SEASONS("사계절용");

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
