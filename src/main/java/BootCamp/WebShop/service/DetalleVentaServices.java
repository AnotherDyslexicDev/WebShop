package BootCamp.WebShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import BootCamp.WebShop.model.Venta;
import BootCamp.WebShop.model.DetalleVenta;
import BootCamp.WebShop.model.Productos;
@Service
public interface DetalleVentaServices {

	public DetalleVenta addDetalleVenta(DetalleVenta detalleVenta);

}
