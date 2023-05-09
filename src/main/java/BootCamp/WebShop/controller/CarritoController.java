package BootCamp.WebShop.controller;

import java.sql.Timestamp;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import BootCamp.WebShop.model.Productos;
import BootCamp.WebShop.model.Carrito;
import BootCamp.WebShop.model.DetalleCarrito;
import BootCamp.WebShop.model.Estados;
import BootCamp.WebShop.model.FormaPago;
import BootCamp.WebShop.model.Usuario;
import BootCamp.WebShop.service.CarritoServices;
import BootCamp.WebShop.service.DetalleCarritoServices;
import BootCamp.WebShop.service.ProductoServices;
import BootCamp.WebShop.service.FormaPagoServices;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private ProductoServices productoServices;

    @Autowired
    private CarritoServices carritoServices;

    @Autowired
    private DetalleCarritoServices detalleCarritoServices;
    @Autowired
    private FormaPagoServices  formaPagoServices;
    
    @RequestMapping(value = "/ver", method = RequestMethod.GET)
    public ModelAndView verCarrito(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        Carrito carrito = (Carrito) session.getAttribute("carrito");

        if (carrito == null || carrito.getDetallesCarrito().isEmpty()) {
            modelAndView.addObject("mensaje", "Tu carrito está vacío");
        } else {
        	List<FormaPago> formasdePago= new ArrayList<FormaPago>();
        	formasdePago=formasPago();
        	modelAndView.addObject("formasPago", formasdePago);
            modelAndView.addObject("carrito", carrito);
        }

        modelAndView.setViewName("carrito");
        return modelAndView;
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public ModelAndView agregarProductoACarrito(HttpServletRequest request, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Long idProducto = Long.parseLong(request.getParameter("idProducto"));
        Integer cantidad = Integer.parseInt(request.getParameter("cantidad"));
        // Obtenemos el producto a agregar al carrito
        Productos producto = productoServices.getProductoById(idProducto);
        // Verificamos si el producto existe
        if (producto == null) {
            modelAndView.addObject("error", "El producto no existe");
            modelAndView.setViewName("error");
            return modelAndView;
        }
     // Obtenemos el carrito de la sesión actual
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if (carrito == null) {
            // Si no existe un carrito en la sesión, creamos uno
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            if (usuario == null) {
                // Si no hay un usuario en sesión, no podemos crear un carrito, redireccionamos a la página de login
                modelAndView.setViewName("redirect:/login");
                return modelAndView;
            }
            Estados estado = new Estados();
            estado.setIdEstado(1);
            carrito = new Carrito();
            carrito.setCreado(new Timestamp(System.currentTimeMillis()));
            carrito.setActualizado(new Timestamp(System.currentTimeMillis()));
            carrito.setDetallesCarrito(null);            
            carrito.setTotal(producto.getPrecio());
            carrito.setUsuario(usuario);
            carrito.setEstados(estado);
            // Guardamos el carrito en la base de datos para obtener su id
            Carrito carritoGuardado = carritoServices.saveCarrito(carrito);
            // Actualizamos el carrito de la sesión con el id obtenido
            session.setAttribute("carrito", carritoGuardado);
        }       
        DetalleCarrito detalleCarrito = (DetalleCarrito) session.getAttribute("detalleCarrito");
        // Inicializar la variable auxiliar
        List<DetalleCarrito> detallesActualizados = new ArrayList<>();
        if (detalleCarrito == null) {
            detalleCarrito = new DetalleCarrito();
            detalleCarrito.setCreado(new Timestamp(System.currentTimeMillis()));
            detalleCarrito.setActualizado(new Timestamp(System.currentTimeMillis()));
            detalleCarrito.setCarrito(carrito); // El carrito obtenido anteriormente
            detalleCarrito.setProducto(producto); // El producto que se va a agregar
            detalleCarrito.setCantidad(cantidad); 
            detalleCarrito.setSubTotal(producto.getPrecio()*cantidad);            
            HttpSession httpSession = request.getSession();// Guardamos el detalle de carrito en la sesión de HttpSession
            httpSession.setAttribute("detalleCarrito", detalleCarrito);
            detallesActualizados.add(detalleCarrito);
            carrito.setDetallesCarrito((List<DetalleCarrito>)detallesActualizados);//lo que quiero es ir agregando detalles de carrito al carrito asociado
            DetalleCarrito detalleCarritoGuardado = detalleCarritoServices.saveDetalleCarrito(detalleCarrito);
        }else {        	
        	List<DetalleCarrito> detallesCarrito = carrito.getDetallesCarrito();
        	boolean productoEncontrado = false;
        	for (DetalleCarrito detalle : detallesCarrito) {
        	    if (detalle.getProducto().getIdProducto() == idProducto) {
        	        // Si el producto ya está en el carrito, incrementamos la cantidad
        	        detalle.setCantidad(detalle.getCantidad() + cantidad);
        	        detalle.setSubTotal((detalle.getCantidad())* (detalle.getProducto().getPrecio()));        	        
        	        detalleCarritoServices.updateDetalleCarrito(detalle.getIdDetalleCarrito(), detalle.getCantidad(), detalle.getSubTotal());
            	    int total=0;
            	    for(DetalleCarrito detallesCarritos: detallesCarrito ) {
            	    	total=total+detallesCarritos.getSubTotal();
            	    	carrito.setTotal(total);
            	    }
            	    //falta agregar la fecha y hora de la modificacion en el carrito
            	    carritoServices.updateCarritoTotal(carrito.getTotal(),carrito.getIdCarrito());
        	        productoEncontrado = true;
        	        break;
        	    }
        	}
        	if (!productoEncontrado) {
        	    // Si el producto no está en el carrito, creamos un nuevo detalle y lo agregamos a la lista
        	    DetalleCarrito nuevoDetalle = new DetalleCarrito();
        	    nuevoDetalle.setCreado(new Timestamp(System.currentTimeMillis()));
        	    nuevoDetalle.setActualizado(new Timestamp(System.currentTimeMillis()));
        	    nuevoDetalle.setCarrito(carrito); // El carrito obtenido anteriormente
        	    nuevoDetalle.setProducto(producto); // El producto que se va a agregar
        	    nuevoDetalle.setCantidad(cantidad); // Cantidad fija por ahora
        	    nuevoDetalle.setSubTotal(producto.getPrecio()*cantidad);        	    
        	    //carrito.setTotal(carrito.getSubTotal()+nuevoDetalle.getProducto().getPrecio());
        	    detallesCarrito.add(nuevoDetalle);
        	    carrito.setDetallesCarrito(detallesCarrito);
        	    int total=0;
        	    for(DetalleCarrito detallesCarritos: detallesCarrito ) {
        	    	total=total+detallesCarritos.getSubTotal();
        	    	carrito.setTotal(total);
        	    }
        	    carritoServices.updateCarritoTotal(carrito.getTotal(),carrito.getIdCarrito());
        	    DetalleCarrito detalleCarritoGuardado = detalleCarritoServices.saveDetalleCarrito(nuevoDetalle);
        	}           
        }        
        modelAndView.addObject("mensaje", "Producto agregado al carrito correctamente");
        modelAndView.setViewName("redirect:/index");
        return modelAndView;
    }
    
    public List<FormaPago> formasPago(){
        List<FormaPago> formasPago= new ArrayList<FormaPago>();		
		formasPago = formaPagoServices.getAllFormasPago();	
        return formasPago;
    }

    /*@RequestMapping(value = "/eliminar/{idDetalle}", method = RequestMethod.GET)
    public ModelAndView eliminarDetalleDelCarrito(@PathVariable("idDetalle") Long idDetalle, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Carrito carrito = (*/

}