package me.koobin.shop.embedded;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;


@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
