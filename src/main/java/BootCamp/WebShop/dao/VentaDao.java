package BootCamp.WebShop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import BootCamp.WebShop.model.Venta;
@Component
public class VentaDao {
	@Autowired
	private SessionFactory sessionFactory;

public Venta addVenta(Venta venta) {
	Session session;
	if(sessionFactory.getCurrentSession()==null)
	{
		 session = sessionFactory.openSession();
	}else{
		
		 session = sessionFactory.getCurrentSession();
	}
	session.save(venta);
	return venta;
}


}
