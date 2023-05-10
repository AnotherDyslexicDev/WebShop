package BootCamp.WebShop.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import BootCamp.WebShop.model.DetalleCarrito;


import BootCamp.WebShop.model.DetalleVenta;
@Component
public class DetalleVentaDao {
	@Autowired
	SessionFactory sessionFactory;
	public DetalleVenta save(DetalleVenta detalleVenta) {
		Session session = sessionFactory.getCurrentSession();
		session.save(detalleVenta);
		return detalleVenta;
		
	}

}
