package BootCamp.WebShop.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import BootCamp.WebShop.model.FormaPago;
import BootCamp.WebShop.model.Slider;
@Component

public class FormaPagoDao {
	@Autowired
	HibernateTemplate hiberneteTemplate;
	public List<FormaPago> getAllFormasPago() {
		List<FormaPago> listado = hiberneteTemplate.loadAll(FormaPago.class);
		return listado;
	}
	@Autowired
	public FormaPago findById(Long idFormaPago) {
	    FormaPago formaPago = hiberneteTemplate.get(FormaPago.class, idFormaPago);
	    return formaPago;
	}

}
