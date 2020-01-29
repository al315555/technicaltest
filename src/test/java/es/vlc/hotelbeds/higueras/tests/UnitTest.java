package es.vlc.hotelbeds.higueras.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import es.vlc.hotelbeds.higueras.controller.ItemController;
import es.vlc.hotelbeds.higueras.main.Application;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//@SpringBootTest
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class UnitTest {

    protected MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    protected void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testHelpTool() throws Exception{
        setUp();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/help")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);//isOk()
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(ItemController.HELP_TEXT, content);
        //mvc.perform(MockMvcRequestBuilders.get().accept(MediaType.APPLICATION_JSON))
        //        .andExpect(status().isOk())
        //        .andExpect(content().string(equalTo(ItemController.HELP_TEXT)));
    }

    @Test
    public void testCalculateService() throws Exception{
        setUp();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/order/totalprice/descriiption/10/120/TER")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);//isOk()
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals("The total amount of the order is: 1200.0", content);
        //mvc.perform(MockMvcRequestBuilders.get().accept(MediaType.APPLICATION_JSON))
        //        .andExpect(status().isOk())
        //        .andExpect(content().string(equalTo(ItemController.HELP_TEXT)));
    }

}
