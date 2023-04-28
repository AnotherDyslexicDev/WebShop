package BootCamp.WebShop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;
    private String nombreRol;
    private String descripcion;
    private java.sql.Timestamp creado;
    private java.sql.Timestamp actualizado;
    
    // getters y setters
}
