package me.koobin.shop.controller;

import me.koobin.shop.dto.Header;
import me.koobin.shop.dto.ReadDocsDTO;
import me.koobin.shop.entity.Docs;
import me.koobin.shop.repository.DocsRepository;
import me.koobin.shop.service.DocsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(DocsApiController.class)
@ExtendWith({SpringExtension.class, RestDocumentationExtension.class})
@MockBean(JpaMetamodelMappingContext.class)
class DocsApiControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DocsService docsService;

    @BeforeEach
    public void setUp(RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(documentationConfiguration(restDocumentation))  // (2)
                .build();
    }

    @Test
    void testRead() throws Exception {
        Docs docs = Docs.builder()
                .id(1L)
                .account("account")
                .email("email@email.com")
                .phoneNumber("010-000-000")
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        given(docsService.read(1L)).willReturn(Header.OK(new ReadDocsDTO(docs)));

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
                                fieldWithPath("data.createdDate").description("생성시간"),
                                fieldWithPath("data.modifiedDate").description("수정일자")
                        )
                ));
    }
}
