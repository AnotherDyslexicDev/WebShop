package BootCamp.WebShop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import BootCamp.WebShop.model.Carrito;
@Service
public interface CarritoServices {
    public Carrito saveCarrito(Carrito carrito);
    public Carrito getCarritoById(Long idCarrito);
    public List<Carrito> getAllCarritos();
    public void deleteCarrito(Long idCarrito);
	public void updateCarritoTotal(int total,int idCarrito);	
	public void actualizarEstado( int idEstado, int idCarrito);
}
