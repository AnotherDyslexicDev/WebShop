package BootCamp.WebShop.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import BootCamp.WebShop.model.Carrito;

@Component
public class CarritoDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(Carrito carrito) {
		Session session = sessionFactory.getCurrentSession();
		session.save(carrito);
	}

}

