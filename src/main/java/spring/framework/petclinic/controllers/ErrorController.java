package spring.framework.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
final class ErrorController {
    static final String URL_OUPS = "/oups";

    @GetMapping(URL_OUPS)
    public String triggerException() {
        throw new RuntimeException("Expected: controller used to showcase what happens when an exception is thrown");
    }
}




