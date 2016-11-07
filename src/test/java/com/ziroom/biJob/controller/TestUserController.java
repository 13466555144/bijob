package com.ziroom.biJob.controller;



import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(locations = {"classpath:springmvc/spring-mvc.xml","classpath:application.xml"})
public class TestUserController extends TestCase {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    @Autowired
    private UserController userController;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    /**
     * spring mvc test
     */
    @Test
    public void toBusOppListPage() {
        try {
        	MvcResult result  = this.mockMvc.perform(MockMvcRequestBuilders.post("/test/showView"))
            		.andExpect(MockMvcResultMatchers.view().name("user/view"))  
                    .andExpect(MockMvcResultMatchers.model().attributeExists("user"))  
                    .andDo(MockMvcResultHandlers.print())  
                    .andReturn();  
            System.out.println("==" + result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
