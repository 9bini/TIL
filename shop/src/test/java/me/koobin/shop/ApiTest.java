package me.koobin.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.test.web.servlet.MockMvc;


@AutoConfigureRestDocs(uriScheme = "https", uriHost = "docs.api.com") // (1)
//@Import(HttpEncodingAutoConfiguration.class)
public abstract class ApiTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;
}
