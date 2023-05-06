package BootCamp.WebShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import BootCamp.WebShop.dao.CarritoDao;
import BootCamp.WebShop.dao.DetalleCarritoDao;
import BootCamp.WebShop.model.Carrito;
import BootCamp.WebShop.model.DetalleCarrito;
import BootCamp.WebShop.service.DetalleCarritoServices;
@Service
@Transactional
public class DetalleCarritoServicesImpl implements DetalleCarritoServices {
	 @Autowired
	  private DetalleCarritoDao detalleCarritoDao;
	 @Override
	 public DetalleCarrito saveDetalleCarrito(DetalleCarrito detalleCarrito) {
	      detalleCarritoDao.save(detalleCarrito);
	      return detalleCarrito;
	 }

	@Override
	public DetalleCarrito getDetalleCarritoById(Long idDetalleCarrito) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetalleCarrito> getAllDetallesCarrito() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetalleCarrito> getDetallesCarritoByCarrito(Carrito carrito) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDetalleCarrito(Long idDetalleCarrito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDetalleCarrito(int idDetalleCarrito, int cantidad) {
	    DetalleCarrito detalle = detalleCarritoDao.getDetalleCarritoById(idDetalleCarrito);
	    if (detalle != null) {
	        // Modifica la cantidad del detalle de carrito
	        detalle.setCantidad(cantidad);
	        //detalle.setPrecio(detalle.getProducto().getPrecio() * detalle.getCantidad());

	        // Actualiza el detalle de carrito en la base de datos
	        detalleCarritoDao.updateDetalleCarrito(detalle);
	    }
	}

}
