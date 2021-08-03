package me.koobin.shop.entity;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity @Getter
@NoArgsConstructor @AllArgsConstructor
@ToString
@Builder
public class Docs {
    @Id
    @GeneratedValue
    private Long id;

    private String account;
    private String email;
    private String phoneNumber;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public void update(String account, String email, String phoneNumber){
        this.account = account;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
