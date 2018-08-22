package com.fitter.fitterbird;

import com.fitter.fitterbird.controller.FitterController;
import com.fitter.fitterbird.controller.HomeController;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import com.fitter.fitterbird.data.FitterRepo;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.Date;
import java.util.List;

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

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Fitter> expectedSpittles = createSpittleList(20);
        FitterRepo mockRepository =
                mock(FitterRepo.class);
        when(mockRepository.fintFitters(Long.MAX_VALUE, 20))
                .thenReturn(expectedSpittles);
        FitterController controller =
                new FitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(
                        new InternalResourceView("/WEB-INF/views/fitters.jsp"))
                .build();
        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList",
                        hasItems(expectedSpittles.toArray())));
    }

    private List<Fitter> createSpittleList(int count) {
        List<Fitter> spittles = new ArrayList<Fitter>();
        for (int i=0; i < count; i++) {
            spittles.add(new Fitter("Fitter" + i,new Date()));
        }
        return spittles;
    }
}
