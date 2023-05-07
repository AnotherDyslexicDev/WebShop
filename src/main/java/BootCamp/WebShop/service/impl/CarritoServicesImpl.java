package BootCamp.WebShop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import BootCamp.WebShop.dao.CarritoDao;
import BootCamp.WebShop.model.Carrito;
import BootCamp.WebShop.service.CarritoServices;

@Service
@Transactional
public class CarritoServicesImpl implements CarritoServices {

    @Autowired
    private CarritoDao carritoDao;
    
    @Override
    public Carrito saveCarrito(Carrito carrito) {
        carritoDao.save(carrito);
		return carrito;
    }

	@Override
	public Carrito getCarritoById(Long idCarrito) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Carrito> getAllCarritos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCarrito(Long idCarrito) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCarritoTotal(int total,int idCarrito) {
		carritoDao.updateCarritoTotal(total,idCarrito);
		
	}

}