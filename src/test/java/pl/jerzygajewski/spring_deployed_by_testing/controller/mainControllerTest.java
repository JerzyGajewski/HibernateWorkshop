package pl.jerzygajewski.spring_deployed_by_testing.controller;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.Table;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class mainControllerTest {

    private MainController mainController;
    private String pageViewName = "mainPage";

    @Before
    public void beforeClass(){
        mainController = new MainController();
    }

    @Test
    public void shouldFindMainPage(){
        assertEquals(mainController.mainPage(), pageViewName);
    }


}
