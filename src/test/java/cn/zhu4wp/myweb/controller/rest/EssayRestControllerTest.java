package cn.zhu4wp.myweb.controller.rest; 

import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockMvcClientHttpRequestFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.FileInputStream;

/** 
* EssayRestController Tester. 
* 
* @author zjm 
* @since <pre>3月 18, 2020</pre> 
* @version 1.0 
*/ 
@RunWith(SpringRunner.class)
@SpringBootTest
public class EssayRestControllerTest { 
@Autowired
private WebApplicationContext webApplicationContext;
private MockMvc mockMvc;
@Before
public void before() throws Exception {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: saveEssay(@RequestParam(value = "text") String text, @RequestParam(value = "title") String title, @RequestParam(value = "folder") String folderName) 
* 
*/ 
@Test
public void testSaveEssay() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findEssayByEssayName(@RequestParam(value="essayName",required = true)String essayName) 
* 
*/ 
@Test
public void testFindEssayByEssayName() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: ShowAllEssays(@RequestParam(value = "page") Integer page) 
* 
*/ 
@Test
public void testShowAllEssays() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: uploadImage(@RequestParam(value = "editormd-image-file",required = false)MultipartFile file) 
* 
*/ 
@Test
public void testUploadImage() throws Exception { 
//TODO: Test goes here...
    File file = new File("/home/zjm/图片/新垣结衣/56fb5fbb6722c.jpg");
    MockMultipartFile mockMultipartFile = new MockMultipartFile("file","56fb5fbb6722c.jpg", MediaType.IMAGE_JPEG_VALUE,new FileInputStream(file));
    mockMvc.perform(MockMvcRequestBuilders.multipart("http://localhost:8080/home/zjm/img/")
                    .file(mockMultipartFile)).andDo(MockMvcResultHandlers.print());

} 


} 
