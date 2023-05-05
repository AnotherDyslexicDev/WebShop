package BootCamp.WebShop.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import BootCamp.WebShop.model.Productos;
import BootCamp.WebShop.model.Carrito;
import BootCamp.WebShop.model.DetalleCarrito;
import BootCamp.WebShop.model.Estados;
import BootCamp.WebShop.model.Usuario;
import BootCamp.WebShop.service.CarritoServices;
import BootCamp.WebShop.service.DetalleCarritoServices;
import BootCamp.WebShop.service.ProductoServices;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private ProductoServices productoServices;

    @Autowired
    private CarritoServices carritoServices;

    @Autowired
    private DetalleCarritoServices detalleCarritoServices;

    @RequestMapping(value = "/ver", method = RequestMethod.GET)
    public ModelAndView verCarrito(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if (carrito == null || carrito.getDetallesCarrito().isEmpty()) {
            modelAndView.addObject("mensaje", "Tu carrito está vacío");
            modelAndView.setViewName("carrito_vacio");
            return modelAndView;
        }
        modelAndView.addObject("carrito", carrito);
        modelAndView.setViewName("carrito");
        return modelAndView;
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public ModelAndView agregarProductoACarrito(HttpServletRequest request, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        Long idProducto = Long.parseLong(request.getParameter("idProducto"));
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
            carrito.setSubTotal(producto.getPrecio());
            carrito.setTotal(producto.getPrecio());
            carrito.setUsuario(usuario);
            carrito.setEstados(estado);

            // Guardamos el carrito en la base de datos para obtener su id
            Carrito carritoGuardado = carritoServices.saveCarrito(carrito);
            // Actualizamos el carrito de la sesión con el id obtenido
            session.setAttribute("carrito", carritoGuardado);
        }
       
        DetalleCarrito detalleCarrito = (DetalleCarrito) session.getAttribute("detalleCarrito");
        if(detalleCarrito ==null) {
        	detalleCarrito = new DetalleCarrito();
        	detalleCarrito.setCreado(new Timestamp(System.currentTimeMillis()));
        	detalleCarrito.setActualizado(new Timestamp(System.currentTimeMillis()));
        	detalleCarrito.setCarrito(carrito); // El carrito obtenido anteriormente
        	detalleCarrito.setProducto(producto); // El producto que se va a agregar
        	detalleCarrito.setCantidad(1); // Cantidad fija por ahora

        	// Guardamos el detalle de carrito en la base de datos
        	DetalleCarrito detalleCarritoGuardado = detalleCarritoServices.saveDetalleCarrito(detalleCarrito);
        }
        // Verificamos si el producto ya está en el carrito
        boolean productoYaEnCarrito = false;
        for (DetalleCarrito detallesCarrito : carrito.getDetallesCarrito()) {
            if (detallesCarrito.getProducto().getIdProducto() == idProducto) {
                // Si el producto ya está en el carrito, incrementamos la cantidad
                detallesCarrito.setCantidad(detallesCarrito.getCantidad() + 1);
                detalleCarritoServices.saveDetalleCarrito(detallesCarrito);
                productoYaEnCarrito = true;
                break;
            }
        }

        // Si el producto no está en el carrito, creamos un nuevo detalle de carrito
        if (!productoYaEnCarrito) {
            DetalleCarrito detallesCarrito = new DetalleCarrito();
            detallesCarrito.setProducto(producto);
            detallesCarrito.setCantidad(1);
            detallesCarrito.setCarrito(carrito);
            detalleCarritoServices.saveDetalleCarrito(detallesCarrito);
            carrito.getDetallesCarrito().add(detallesCarrito);
            
        }
        
        
        modelAndView.setViewName("redirect:/index");
        return modelAndView;
    }

    /*@RequestMapping(value = "/eliminar/{idDetalle}", method = RequestMethod.GET)
    public ModelAndView eliminarDetalleDelCarrito(@PathVariable("idDetalle") Long idDetalle, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Carrito carrito = (*/

}