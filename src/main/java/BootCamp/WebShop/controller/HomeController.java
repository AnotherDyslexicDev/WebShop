package BootCamp.WebShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import BootCamp.WebShop.model.Slider;
import BootCamp.WebShop.service.SliderServices;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private SliderServices sliderServices;

    @GetMapping(value={"","/","index","home","default"})
    public ModelAndView homePage() {
        List<Slider> sliders = sliderServices.getSliders();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("sliders", sliders);

        return modelAndView;
    }
}

