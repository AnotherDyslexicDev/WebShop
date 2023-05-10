package BootCamp.WebShop.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import BootCamp.WebShop.dao.EstadosDao;
import BootCamp.WebShop.dao.SliderDao;
import BootCamp.WebShop.model.Estados;

@Component
@Service
public class EstadosServices {
	@Autowired
	EstadosDao estadosDao;

	public List<Estados> getEstados() {
		
		List<Estados> listaEstados = estadosDao.getEstados();
		return listaEstados;
	}


}
