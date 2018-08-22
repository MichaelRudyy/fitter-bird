package com.fitter.fitterbird.controller;

import com.fitter.fitterbird.Fitter;
import com.fitter.fitterbird.data.FitterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/fitters")
public class FitterController {

    FitterRepo repository;

    @Autowired
    public FitterController(FitterRepo repository) {
    }

    @GetMapping
    public String fitter(Model model){
        model.addAllAttributes(repository.fintFitters(Long.MAX_VALUE, 20));
        return "/fitters";
    }
}
