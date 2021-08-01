package me.koobin.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Header<T> {

    private String resultCode;
    private T data;

    // OK
    public static <T> Header<T> OK() {
        return (Header<T>) Header
                .builder().resultCode("OK").build();
    }

    // DATA OK
    public static <T> Header<T> OK(T data) {
        return (Header<T>) Header
                .builder().resultCode("OK")
                .data(data)
                .build();
    }

    // Error
    public static <T> Header<T> Error() {
        return (Header<T>) Header
                .builder().resultCode("ERROR")
                .build();
    }
}
