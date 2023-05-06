package BootCamp.WebShop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import BootCamp.WebShop.model.Carrito;
import BootCamp.WebShop.model.DetalleCarrito;
import BootCamp.WebShop.model.Productos;
@Service
public interface DetalleCarritoServices {
    public DetalleCarrito saveDetalleCarrito(DetalleCarrito detalleCarrito);
    public DetalleCarrito getDetalleCarritoById(Long idDetalleCarrito);
    public List<DetalleCarrito> getAllDetallesCarrito();
    public List<DetalleCarrito> getDetallesCarritoByCarrito(Carrito carrito);
    public void deleteDetalleCarrito(Long idDetalleCarrito);
	public void updateDetalleCarrito(int idDetalleCarrito,int cantidad);
}

