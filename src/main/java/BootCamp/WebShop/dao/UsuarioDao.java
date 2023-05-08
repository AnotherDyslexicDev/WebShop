package BootCamp.WebShop.dao;
import java.sql.Timestamp;
import java.util.List;
import javax.security.sasl.AuthenticationException;
import javax.transaction.Transactional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	    Session session ;
	    session =	sessionFactory.openSession();
	    Transaction transaction = null;

	    try {
	        transaction = session.beginTransaction();
	        // guardar la entidad en la base de datos
	        session.update(usuario);
	        transaction.commit();
	        return usuario;
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return null; // si ocurre un error, devuelve null
	}








}
