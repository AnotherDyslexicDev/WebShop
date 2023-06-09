package BootCamp.WebShop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import BootCamp.WebShop.model.Slider;
import BootCamp.WebShop.service.SliderServices;
import BootCamp.WebShop.model.Productos;
import BootCamp.WebShop.model.Usuario;
import BootCamp.WebShop.model.Carrito;
import BootCamp.WebShop.model.DetalleCarrito;
import BootCamp.WebShop.model.Estados;
import BootCamp.WebShop.service.EstadosServices;
import BootCamp.WebShop.service.ProductoServices;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private SliderServices sliderServices;
    @Autowired
    private ProductoServices productoServices;
    @Autowired
    private EstadosServices estadosServices;
    
    @GetMapping(value={"","/","index","home","default"})
    public ModelAndView homePage(HttpSession session) {
        List<Slider> sliders = sliderServices.getSliders();
        List<Productos> productos = productoServices.getProductos();
        List<Estados> estados = estadosServices.getEstados();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("sliders", sliders);
        modelAndView.addObject("productos", productos);
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        session.setAttribute("estados", estados);
        DetalleCarrito detalleCarrito = (DetalleCarrito) session.getAttribute("detalleCarrito");
        modelAndView.addObject("usuario", usuario != null ? usuario : null); // si la sesión es nula, se inicializa usuario en null
        modelAndView.addObject("carrito", carrito != null ? carrito : null); // si la sesión es nula, se inicializa Carrito en null
        modelAndView.addObject("detalleCarrito", detalleCarrito != null ? detalleCarrito : null); // si la sesión es nula, se inicializa detalleCarrito en null
        return modelAndView;
    }
}

