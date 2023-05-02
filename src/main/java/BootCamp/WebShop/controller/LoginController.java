package BootCamp.WebShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import BootCamp.WebShop.model.Slider;
import BootCamp.WebShop.service.SliderServices;
import BootCamp.WebShop.model.Productos;
import BootCamp.WebShop.service.ProductoServices;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {


    @GetMapping(value={"login","/login"})
    public ModelAndView LoginPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");


        return modelAndView;
    }
}
