package BootCamp.WebShop.service.impl;

import javax.security.sasl.AuthenticationException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import BootCamp.WebShop.dao.UsuarioDao;
import BootCamp.WebShop.model.Usuario;
import BootCamp.WebShop.service.UsuarioService;
@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioDao usuarioDao;
	
	public void updateUsuario(Usuario authUsuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
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

	@Override
	public Usuario updateUsuarioToken(Usuario usuario) {		
		usuario = usuarioDao.updateUsuarioToken(usuario);
		return usuario;
	}


}
