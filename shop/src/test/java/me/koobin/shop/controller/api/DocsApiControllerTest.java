package me.koobin.shop.controller.api;

import me.koobin.shop.entity.Docs;
import me.koobin.shop.repository.DocsRepository;
import me.koobin.shop.service.DocsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
@ExtendWith({SpringExtension.class, RestDocumentationExtension.class})
class DocsApiControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;
    @Autowired
    private DocsService docsRepository;

    @BeforeEach
    public void setUp(RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(documentationConfiguration(restDocumentation))  // (2)
                .build();
        docsRepository.create(new Docs(null, "account", "email@email.com", "010-000-000", LocalDateTime.now(), LocalDateTime.now()));
    }

    @Test
    void read() throws Exception {
        mockMvc.perform(get("/api/v1/docs/{id}", 1))
                .andDo(print())
                .andDo(document("docs", pathParameters(
                        parameterWithName("id").description("문서 아이디")
                        ), responseFields(
                        fieldWithPath("resultCode").description("응답코드"),
                        fieldWithPath("data.id").description("아이디"),
                        fieldWithPath("data.account").description("계정"),
                        fieldWithPath("data.email").description("이메일"),
                        fieldWithPath("data.phoneNumber").description("전화번호"),
                        fieldWithPath("data.createDate").description("생성시간"),
                        fieldWithPath("data.modifiedDate").description("수정일자")
                        )
                ));
    }


}