package BootCamp.WebShop.dao;



import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import BootCamp.WebShop.model.Productos;

@Component
public class ProductoDao {
	@Autowired
	HibernateTemplate hiberneteTemplate;
	public List<Productos> getProductos() {
		// TODO Auto-generated method stub
		return hiberneteTemplate.loadAll(Productos.class);
	}
	public Productos findById(Integer idProducto) {
	    return hiberneteTemplate.get(Productos.class, idProducto);
	}

}
