package BootCamp.WebShop.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import BootCamp.WebShop.model.Estados;
@Component
public class EstadosDao {
	@Autowired
	HibernateTemplate hiberneteTemplate;
	public List<Estados> getEstados() {
		List<Estados> estados = hiberneteTemplate.loadAll(Estados.class);
			return estados;
		}
	
	}
