package BootCamp.WebShop.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import BootCamp.WebShop.dao.SliderDao;
import BootCamp.WebShop.model.Slider;
@Component
@Service
public class SliderServices {
	@Autowired
	SliderDao sliderDao;

	public List<Slider> getSliders() {
		
		List<Slider> listaSlider = sliderDao.getSliders();
		return listaSlider;
	}


}
