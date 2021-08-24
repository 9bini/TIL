package me.koobin.shop.domain;

import me.koobin.shop.embedded.BaseTimeEntity;

import javax.persistence.*;

@Entity
public class FileInfo {
    @Id
    @GeneratedValue
    private Long id;
    private String fileName;
    private String saveFileName;
    @Enumerated(EnumType.STRING)
    private ContentType contentType;
    private String deleteFlag;
    @Embedded
    private BaseTimeEntity baseTimeEntity;
}
