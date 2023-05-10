package BootCamp.WebShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import BootCamp.WebShop.dao.CarritoDao;
import BootCamp.WebShop.dao.VentaDao;
import BootCamp.WebShop.model.Carrito;
import BootCamp.WebShop.model.Venta;
import BootCamp.WebShop.service.VentaServices;

@Service
@Transactional
public class VentaServicesImpl implements VentaServices{
	@Autowired
    private VentaDao ventaDao;
	
	 @Override
	 public Venta addVenta(Venta venta) {
		 ventaDao.addVenta(venta);
			return venta;
	    }
}
