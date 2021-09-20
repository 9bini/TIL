package me.koobin.shop.api.controller;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.koobin.shop.ApiTest;
import me.koobin.shop.api.controller.dto.CategoryCreateDto;
import me.koobin.shop.api.controller.dto.CategoryFindDto;
import me.koobin.shop.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;

import static me.koobin.shop.ApiDocumentUtils.getDocumentRequest;
import static me.koobin.shop.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {CategoryApiController.class})

class CategoryApiControllerTest extends ApiTest {

    @MockBean
    CategoryService categoryService;

    @Test
    void create() throws Exception {
        given(categoryService.create(any(CategoryCreateDto.class)))
                .willReturn(CategoryFindDto.builder()
                        .id(10L)
                        .name("카테고리 아이디")
                        .parent(1L)
                        .build());


        Request request = new Request();
        request.name = "카테고리";
        //request.parent = null;

        mockMvc.perform(post("/category/v1")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andDo(document("category-create"
                        , getDocumentRequest()
                        , getDocumentResponse()
                        , requestFields(
                                fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                                fieldWithPath("parent").type(JsonFieldType.STRING).description("부모 ID").optional()
                        )

                        , responseFields(
                                beneathPath("data").withSubsectionId("data"),
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("아이디"),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                                fieldWithPath("parent").type(JsonFieldType.NUMBER).description("카테고리 부모 id")
                        )))
                .andReturn();

    }

    @Test
    void findBy() throws Exception {
        given(categoryService.findById(1L))
                .willReturn(CategoryFindDto
                        .builder()
                        .id(1L)
                        .name("카테고리 이름")
                        .parent(null)
                        .build()
                );

        mockMvc.perform(RestDocumentationRequestBuilders.get("/category/v1/{id}", 1L)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("category find by id"
                        , getDocumentRequest()
                        , getDocumentResponse()
                        , pathParameters(
                                parameterWithName("id").description("카테고리 아이디")

                        ), responseFields(
                                beneathPath("data").withSubsectionId("data"),
                                fieldWithPath("id").type(JsonFieldType.NUMBER).description("아이디"),
                                fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                                fieldWithPath("parent").type(JsonFieldType.NUMBER).description("카테고리 부모 id").optional()
                        )
                ));

    }

    @Test
    void update(){

    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Request {
        String name;
        //Long parent;
    }
}