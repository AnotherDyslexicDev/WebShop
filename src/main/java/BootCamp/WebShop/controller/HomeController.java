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
public class HomeController {

    @Autowired
    private SliderServices sliderServices;
    @Autowired
    private ProductoServices productoServices;

    @GetMapping(value={"","/","index","home","default"})
    public ModelAndView homePage() {
        List<Slider> sliders = sliderServices.getSliders();
        List<Productos> productos = productoServices.getProductos();
        //System.out.println(productos.toString());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("sliders", sliders);
        modelAndView.addObject("productos", productos);

        return modelAndView;
    }
}

