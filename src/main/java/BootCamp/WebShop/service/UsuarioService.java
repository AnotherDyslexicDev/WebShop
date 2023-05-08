package BootCamp.WebShop.service;

import org.springframework.stereotype.Service;
import BootCamp.WebShop.model.Usuario;
@Service
public interface UsuarioService {

	public Usuario authenticate(String email, String password);

	public Usuario updateUsuarioToken(Usuario authUsuario);



	
}
