package BootCamp.WebShop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import BootCamp.WebShop.dao.FormaPagoDao;
import BootCamp.WebShop.model.FormaPago;

@Service
public class FormaPagoServices {
	@Autowired
	private FormaPagoDao formaPagoDao;

	public List<FormaPago> getAllFormasPago() {
		return formaPagoDao.getAllFormasPago();
	}

	public FormaPago findById(Long idFormaPago) {
		FormaPago formaPago = formaPagoDao.findById(idFormaPago);
		if (formaPago == null) {
			throw new IllegalArgumentException("El id de forma de pago no existe en la base de datos.");
		}
		return formaPago;
	}
}

