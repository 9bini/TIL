package me.koobin.shop.domain.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.koobin.shop.utils.EnumType;

@Slf4j
@Getter
@RequiredArgsConstructor
public enum ProductGender implements EnumType {
    MALE("남자"),
    FEMALE("여자"),
    PUBLIC("공통");

    private final String text;

    @Override
    public String getId() {
        return this.name();
    }
}
