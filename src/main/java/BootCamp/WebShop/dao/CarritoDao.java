package BootCamp.WebShop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import BootCamp.WebShop.model.Carrito;

@Component
public class CarritoDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Carrito carrito) {
		Session session;
		if(sessionFactory.getCurrentSession()==null)
		{
			 session = sessionFactory.openSession();
		}else{
			
			 session = sessionFactory.getCurrentSession();
		}
		session.save(carrito);
	}

}

