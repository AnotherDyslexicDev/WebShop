package BootCamp.WebShop.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import BootCamp.WebShop.model.DetalleCarrito;

@Component
public class DetalleCarritoDao {
	private SessionFactory sessionFactory;

	@Autowired
	public DetalleCarritoDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public DetalleCarrito save(DetalleCarrito detalleCarrito) {
		Session session = sessionFactory.getCurrentSession();
		session.save(detalleCarrito);
		return detalleCarrito;
	}

	public DetalleCarrito getDetalleCarritoById(int idDetalleCarrito) {
		Session session = sessionFactory.getCurrentSession();
		DetalleCarrito detalle = session.get(DetalleCarrito.class, idDetalleCarrito);
		return detalle;
	}

	public void updateDetalleCarrito(DetalleCarrito detalle) {
		Session session = sessionFactory.getCurrentSession();
		session.update(detalle);
	}


}

