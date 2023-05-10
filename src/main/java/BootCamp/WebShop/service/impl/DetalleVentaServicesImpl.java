package BootCamp.WebShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import BootCamp.WebShop.dao.DetalleVentaDao;
import BootCamp.WebShop.model.DetalleVenta;
import BootCamp.WebShop.service.DetalleVentaServices;
@Service
@Transactional
public class DetalleVentaServicesImpl implements DetalleVentaServices {
	 @Autowired
	  private DetalleVentaDao detalleVentaDao;
	@Override
	public DetalleVenta addDetalleVenta(DetalleVenta detalleVenta) {
		 detalleVentaDao.save(detalleVenta);
	      return detalleVenta;
		
	}

}
