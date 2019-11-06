//package com.sucl.swagger;
//
//import io.github.swagger2markup.Swagger2MarkupConverter;
//import org.apache.commons.io.FileUtils;
//import org.asciidoctor.*;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.util.ResourceUtils;
//import org.springframework.web.context.WebApplicationContext;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Paths;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebAppConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//public class GenerateHtml {
//
//	@Autowired
//	private WebApplicationContext webApplicationContext;
//
//	private MockMvc mockMvc;
//
//	@Before
//	public void setUp() {
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//	}
//
//	@Test
//    public void htmlDoc() throws Exception {
//        File docFilePath = ResourceUtils.getFile("apis");
//        if(!docFilePath.exists()){
//            FileUtils.forceMkdir(docFilePath);
//        }
//
//	    String docPath = docFilePath.getAbsolutePath();
//        //获取swagger.json
//        MvcResult mvcResult = this.mockMvc.perform(get("/v2/api-docs?group=test")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn();
//
//        //生成代码片段
//        String swaggerJson = mvcResult.getResponse().getContentAsString();
//        Swagger2MarkupConverter.from(swaggerJson).build().toFolder(Paths.get(docPath+"/snippets"));
//
//        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
//        Attributes attributes = new Attributes();
//        attributes.setCopyCss(true);
//        attributes.setLinkCss(false);
//        attributes.setSectNumLevels(3);
//        attributes.setAnchors(true);
//        attributes.setSectionNumbers(true);
//        attributes.setHardbreaks(true);
//        attributes.setTableOfContents(Placement.LEFT);
//        attributes.setAttribute("generated", "snippets");
//        OptionsBuilder optionsBuilder = OptionsBuilder.options()
//                .backend("html5")
//                .docType("book")
//                .eruby("")
//                .inPlace(true)
//                .safe(SafeMode.UNSAFE)
//                .attributes(attributes);
//        String asciiInputFilePath = docPath+"/index.adoc";//先定义该文件
//
//        File asciiInputFile = new File(asciiInputFilePath);
//        if(!asciiInputFile.exists()){
//            FileUtils.copyFile(ResourceUtils.getFile("src/main/asciidoc/index.adoc"),asciiInputFile);
//        }
//
//        //生成html
//        asciidoctor.convertFile(asciiInputFile, optionsBuilder.get());
//    }
//
//
//}
