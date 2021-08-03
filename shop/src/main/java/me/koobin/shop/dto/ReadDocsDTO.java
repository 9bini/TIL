package me.koobin.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.koobin.shop.entity.Docs;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadDocsDTO {
    private Long id;
    private String account;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public ReadDocsDTO(Docs docs) {
        id = docs.getId();
        account = docs.getAccount();
        email = docs.getEmail();
        phoneNumber = docs.getPhoneNumber();
        createdDate = docs.getCreatedDate();
        modifiedDate = docs.getModifiedDate();
    }
}
