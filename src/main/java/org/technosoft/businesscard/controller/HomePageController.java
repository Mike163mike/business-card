package org.technosoft.businesscard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class HomePageController {

    @GetMapping("/home")
    public String openHomepage() {

        return "home_page.html";
    }

    @GetMapping("/admin")
    public String editHomePage() {

        return "login_page.html";
    }


}
