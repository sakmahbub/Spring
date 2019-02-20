package com.coderbd.thymeleaflayoutok;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeControler {
    @GetMapping(value = "/")
    public String displayHome(){
        return "index";
    }

    @GetMapping(value = "/about")
    public String displayAbout(){
        return "about";
    }
}
