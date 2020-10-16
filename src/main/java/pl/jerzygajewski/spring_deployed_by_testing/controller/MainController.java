package pl.jerzygajewski.spring_deployed_by_testing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping()
    public String mainPage() {
        return "mainPage";
    }
}
