package me.koobin.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class CreateDocsDTO {
    private Long id;
    private String account;
    private String email;
    private String phoneNumber;
}
