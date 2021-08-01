package me.koobin.shop.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApiController {

    @GetMapping("/test")
    public String test(){
        return "정상 작동중입니다.";
    }
}
