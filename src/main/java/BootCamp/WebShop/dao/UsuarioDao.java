package BootCamp.WebShop.dao;
import java.util.List;

import javax.security.sasl.AuthenticationException;
import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import BootCamp.WebShop.model.Usuario;
@Component
public class UsuarioDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	

	public Usuario authenticate(String email, String password) throws AuthenticationException {
		DetachedCriteria criteria = DetachedCriteria.forClass(Usuario.class);
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));
		List<Usuario> usuarios = (List<Usuario>) hibernateTemplate.findByCriteria(criteria);
		if (usuarios.isEmpty()) {
		    throw new AuthenticationException("Correo electrónico o contraseña incorrectos.");
		}
		Usuario usuario = usuarios.get(0);

	    if (usuario==null) {
	        throw new AuthenticationException("Correo electrónico o contraseña incorrectos.");
	    }	    

	    if (!usuario.getPassword().equals(password)) {
	        throw new AuthenticationException("Correo electrónico o contraseña incorrectos.");
	    }

	    return usuario;
	}

}
