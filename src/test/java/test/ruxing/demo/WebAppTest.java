package test.ruxing.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ruxing.demo.core.config.MyWebAppConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by ruxing on 30/03/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyWebAppConfig.class})
@WebAppConfiguration
public class WebAppTest {

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext context;

    @Autowired
    MockHttpSession session;

    @Autowired
    MockHttpServletRequest request;


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testRestController() throws Exception {
        String contentAsString = mockMvc.perform(get("/user/findUser")).andReturn().getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

}
