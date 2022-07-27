package com.ventulus95.restdocsswagger.controller;

import com.epages.restdocs.apispec.FieldDescriptors;
import com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper;
import com.epages.restdocs.apispec.ResourceSnippetParametersBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.payload.ResponseFieldsSnippet;
import org.springframework.restdocs.snippet.Snippet;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HelloController.class)
@AutoConfigureRestDocs
class HelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void test1() throws Exception {
         mockMvc.perform(get("/test"))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.*").value("1"))
                        .andDo(MockMvcRestDocumentationWrapper.document("테스트", new ResourceSnippetParametersBuilder()
                                .tag("1234")
                                .description("테스트테스트")
                             ),

                               new ResponseFieldsSnippet[]{
                                               PayloadDocumentation.responseFields(
                                       new FieldDescriptor[]{fieldWithPath("1").type(JsonFieldType.STRING).description("123")}
                               )
                               }
                        );

    }
}