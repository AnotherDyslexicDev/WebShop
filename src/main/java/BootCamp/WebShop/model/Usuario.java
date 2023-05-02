package BootCamp.WebShop.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String nombreUsuario;
    private String email;
    private String telefono;
    private String password;
    private String direccion;
    private java.sql.Timestamp creado;
    private java.sql.Timestamp actualizado;
    private String token;
    @JoinColumn(name = "roles_idRol")
    private int roles_idRol;
    @JoinColumn(name = "estados_idEstado")
    private int estados_idEstado;
    
    // getters y setters
}
