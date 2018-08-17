package com.fitter.fitterbird;

import com.fitter.fitterbird.controller.HomeController;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

public class HomeControllerTest {
    @Test
    public void HomePageTest() throws Exception {
        HomeController homeController = new HomeController();
        assertEquals(homeController.home(), "home");
    }

    @Test
    public void AdvenceHomePageTest() throws Exception {
        HomeController homeController = new HomeController();
        MockMvc mock = standaloneSetup(homeController).build();
        mock.perform(get("/")).andExpect(view().name("home"));
    }
    @Test
    public void AdvenceHomePageTest1() throws Exception {
        HomeController homeController = new HomeController();
        MockMvc mock = standaloneSetup(homeController).build();
        mock.perform(get("/home")).andExpect(view().name("home"));
    }
}
