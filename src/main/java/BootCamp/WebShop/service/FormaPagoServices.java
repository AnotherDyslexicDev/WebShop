package BootCamp.WebShop.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import BootCamp.WebShop.dao.FormaPagoDao;
import BootCamp.WebShop.model.FormaPago;


@Component
@Service
public class FormaPagoServices {
	@Autowired
	FormaPagoDao formaPagoDao;
	public  List<FormaPago> getAllFormasPago() {
		List<FormaPago> listaFormaPago = formaPagoDao.getAllFormasPago();
		return listaFormaPago;
	}

}
