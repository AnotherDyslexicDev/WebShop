package BootCamp.WebShop.service;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import BootCamp.WebShop.dao.UsuarioDao;
import BootCamp.WebShop.model.Usuario;
@Component
@Service
public class UsuarioService {

	@Autowired
	UsuarioDao usuarioDao;

	public void updateUsuario(Usuario authUsuario) {
		// TODO Auto-generated method stub
		
	}


	public Usuario authenticate(String email, String password)  {
	    Usuario usuario = null;
		try {
			usuario = usuarioDao.authenticate(email, password);
		} catch (AuthenticationException e) {
			System.out.println(e.toString());
		}
	    if (usuario != null && usuario.getPassword().equals(password)) {
	        return usuario;
	    } else {
	    	return null;	        
	    }	    
	}


}
