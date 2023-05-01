package BootCamp.WebShop.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import BootCamp.WebShop.model.Slider;
@Component
public class SliderDao {
	@Autowired
	HibernateTemplate hiberneteTemplate;
	public List<Slider> getSliders() {
		// TODO Auto-generated method stub
		return hiberneteTemplate.loadAll(Slider.class);
	}

}
