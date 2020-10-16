package pl.jerzygajewski.spring_deployed_by_testing.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.web.context.WebApplicationContext;
import pl.jerzygajewski.spring_deployed_by_testing.SpringDeployedByTestingApplication;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BookController.class)
@AutoConfigureMockMvc
public class bookControllerTest {

    @Autowired
    private MockMvc mockMvc;
//    @Autowired
//    private WebApplicationContext webApplicationContext;

    private String bookListView = "book/list";

//    @Before
//    public void setUp(){
//        mockMvc = webAppContextSetup(webApplicationContext).build();
//    }

    @Test
    public void shouldCheckIfListContainsBookList() throws Exception{
        mockMvc.perform(get("/book"))
                .andExpect(model().attributeExists("list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name(bookListView));
    }

}
