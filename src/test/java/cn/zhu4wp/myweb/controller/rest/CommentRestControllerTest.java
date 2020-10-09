package cn.zhu4wp.myweb.controller.rest;

import cn.zhu4wp.myweb.model.User;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * CommentRestController Tester.
 *
 * @author zjm
 * @version 1.0
 * @since <pre>3月 16, 2020</pre>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentRestControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private MockHttpSession mockHttpSession;

    @Before
    public void before() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockHttpSession = new MockHttpSession();
        User user = new User();
        user.setNickname("test");
        user.setId(3L);
        mockHttpSession.setAttribute("user", user);
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: selectAllLead(@RequestParam(value = "essayName")String essayName, @RequestParam(value = "commentLeadId")Integer commentLeadId, @RequestParam(value = "page")Integer page)
     */
    @Test
    public void testSelectAllLead() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: deleteByCommentId(@RequestParam(value = "commentId")Integer commentId)
     */
    @Test
    public void testDeleteByCommentId() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: addComment(@RequestParam(value = "commentContent") String commentContent, @RequestParam(value = "commentLeadId")Integer commentLeadId, @RequestParam(value = "essayName")String essayName)
     */
    @Test
    public void testAddComment() throws Exception {
//TODO: Test goes here...
        String commentContent = "Hello World!!";
        String essayName = "test";
        Integer commentLeadId = 0;

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/comment")
                .session(mockHttpSession)
                .param("commentContent", commentContent)
                .param("essayName", essayName)
                .param("commentLeadId", String.valueOf(commentLeadId))
        )
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }


} 
