package org.technosoft.businesscard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/")
    public String test() {
        return "test.html";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login_page.html";
//    }

}
