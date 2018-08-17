package com.fitter.fitterbird.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = {"/","/homepage"})
public class HomeController {
    @GetMapping
    public String home(){
        return "/home";
    }
}
