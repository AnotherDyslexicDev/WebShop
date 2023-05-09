package BootCamp.WebShop.dao;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	@PersistenceContext
	private EntityManager entityManager;
    public Usuario updateUsuarioToken(Usuario usuario) {
        try {
            Usuario usuarioExistente = entityManager.find(Usuario.class, usuario.getIdUsuario());
            usuarioExistente.setActualizado(usuario.getActualizado());
            usuarioExistente.setToken(usuario.getToken());
            usuarioExistente.setSetExpirationDate(usuario.getSetExpirationDate());
            entityManager.merge(usuarioExistente);
            return usuarioExistente;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }








}
