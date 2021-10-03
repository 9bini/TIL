package me.koobin.shop.domain.modelsize;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.koobin.shop.utils.EnumType;


@Getter
@RequiredArgsConstructor
public enum Gender implements EnumType {
    MALE("남자")
    , FEMAIL("여자");

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
