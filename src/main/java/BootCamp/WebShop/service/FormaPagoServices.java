package BootCamp.WebShop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import BootCamp.WebShop.dao.FormaPagoDao;
import BootCamp.WebShop.model.FormaPago;
import BootCamp.WebShop.model.Productos;

@Service
public class FormaPagoServices {
	@Autowired
	private FormaPagoDao formaPagoDao;

	public List<FormaPago> getAllFormasPago() {
		return formaPagoDao.getAllFormasPago();
	}


	@Autowired
	HibernateTemplate hiberneteTemplate;
	public FormaPago findById(Long idFormaPago) {
	    return formaPagoDao.findById(idFormaPago.intValue());
	}
}

