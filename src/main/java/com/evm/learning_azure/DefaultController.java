package com.evm.learning_azure;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String home() {
        return "home"; // This will look for a template named "home.html" in src/main/resources/templates
    }

}
