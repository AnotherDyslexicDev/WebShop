package BootCamp.WebShop.dao;
import java.sql.Timestamp;
import java.util.List;
import javax.security.sasl.AuthenticationException;
import javax.transaction.Transactional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpSession;
import BootCamp.WebShop.model.DetalleCarrito;
import BootCamp.WebShop.model.Usuario;
@Component
public class UsuarioDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;

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

	public Usuario updateUsuarioToken(Usuario usuario) {
	   
	    Usuario usuarioActualizado = null;
	    try {
	    	Session session = sessionFactory.getCurrentSession();
	        // Cargar el registro existente desde la base de datos
	        usuarioActualizado = session.load(Usuario.class, usuario.getIdUsuario());
	        
	        // Actualizar los campos necesarios
	        usuarioActualizado.setToken(usuario.getToken());
	        usuarioActualizado.setActualizado(usuario.getActualizado());
	        usuarioActualizado.setSetExpirationDate(usuario.getSetExpirationDate());
	        
	        // Guardar el registro actualizado en la sesión
	        session.update(usuarioActualizado);
	        
	        // Realizar un commit de la transacción
	        session.getTransaction().commit();
	    } catch (Exception e) {
	        // Manejar cualquier excepción que ocurra
	        System.out.println(e.toString());
	    }
	    return usuarioActualizado;
	}








}
