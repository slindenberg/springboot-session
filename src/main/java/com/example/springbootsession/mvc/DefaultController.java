package com.example.springbootsession.mvc;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DefaultController {

    @GetMapping("")
    public ModelAndView index(Authentication auth) {
        Map<String, Object> model = new HashMap<>();
        model.put("auth", auth);
        return new ModelAndView("index", model);
    }

    @GetMapping("/invalid")
    public String invalidSession() {
        return "invalid";
    }
}
