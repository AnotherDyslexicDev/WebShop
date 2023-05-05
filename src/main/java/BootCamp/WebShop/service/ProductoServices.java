package BootCamp.WebShop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import BootCamp.WebShop.dao.ProductoDao;
import BootCamp.WebShop.model.Productos;

@Component
@Service
public class ProductoServices {
	@Autowired
	ProductoDao productoDao;
	
	public List<Productos> getProductos() {
		
		List<Productos> listaProductos = productoDao.getProductos();
		return listaProductos;
	}
	@Autowired
	HibernateTemplate hiberneteTemplate;
	public Productos getProductoById(Long idProducto) {
	    return productoDao.findById(idProducto.intValue());
	}


}

