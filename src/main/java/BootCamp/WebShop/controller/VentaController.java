package BootCamp.WebShop.controller;

import java.sql.Timestamp;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import BootCamp.WebShop.model.Carrito;
import BootCamp.WebShop.model.DetalleCarrito;
import BootCamp.WebShop.model.DetalleVenta;
import BootCamp.WebShop.model.FormaPago;
import BootCamp.WebShop.model.Usuario;
import BootCamp.WebShop.model.Venta;
import BootCamp.WebShop.service.CarritoServices;
import BootCamp.WebShop.service.FormaPagoServices;

@RestController
@RequestMapping("/venta")
public class VentaController {
	@Autowired
	FormaPagoServices formaPagoService;

	

	@RequestMapping(value = "/procesaPago", method = RequestMethod.POST)
	public ModelAndView procesaPago(HttpServletRequest request, HttpSession session) {
	   ModelAndView modelAndView = new ModelAndView();
	    Long idFormaPago = Long.parseLong(request.getParameter("idFormaPago"));
	    
	    
	    // Buscamos la forma de pago seleccionada en la base de datos
	    FormaPago formaPago = formaPagoService.findById(idFormaPago);

	    // Obtenemos el carrito de la sesión
	    Carrito carrito = (Carrito) session.getAttribute("carrito");
	    Venta venta;

	    // Obtenemos el usuario de la sesión
	    Usuario usuario = (Usuario) session.getAttribute("usuario");
	    if (usuario == null) {
	        // Si no hay un usuario en sesión, no podemos crear un carrito, redireccionamos a la página de login
	        modelAndView.setViewName("redirect:/login");
	        return modelAndView;
	    }

	    // Si el pago es exitoso, creamos la venta y sus detalles en la base de datos
	    if (pagoSucces()) {
	        venta = new Venta();
	        venta.setCreado(new Timestamp(System.currentTimeMillis()));
	        venta.setActualizado(new Timestamp(System.currentTimeMillis()));
	        venta.setTotalVenta(carrito.getTotal());
	        venta.setUsuario(carrito.getUsuario());
	        venta.setFormaPago(formaPago);
	        List<DetalleCarrito> detallesCarrito = carrito.getDetallesCarrito();
	        DetalleVenta detalleVenta;
	        for (DetalleCarrito detalle : detallesCarrito) {
	            detalleVenta = new DetalleVenta();
	            detalleVenta.setSubTotalVenta(detalle.getSubTotal());
	            detalleVenta.setCreado(new Timestamp(System.currentTimeMillis()));
	            detalleVenta.setActualizado(new Timestamp(System.currentTimeMillis()));
	            detalleVenta.setVenta(venta);
	            detalleVenta.setProducto(detalle.getProducto());
	        } 
	        CarritoServices carritoService = null  ;
			carritoService.actualizarEstado(carrito.getIdCarrito(), 2); // actualiza el estado del carrito a inactivo
	        session.setAttribute("carrito", null);
	        session.setAttribute("detalleCarrito", null);
	        // Configuramos el mensaje de éxito y redireccionamos a la vista de éxito
	        modelAndView.addObject("mensaje", "El pago fue realizado correctamente");
	        modelAndView.setViewName("redirect:/ventaSucces");
	    } else {
	        // Configuramos el mensaje de error y redireccionamos a la vista de fallo
	        modelAndView.addObject("mensaje", "!El pago no fue realizado correctamente¡");
	        modelAndView.setViewName("redirect:/ventaFail");
	    }

	    return modelAndView;
	}

	// Función que simula el pago y devuelve un booleano para indicar si fue exitoso o no
	private boolean pagoSucces() {
	    // Por ahora, todos los pagos son válidos YOLO
	    return true;
	}


}
