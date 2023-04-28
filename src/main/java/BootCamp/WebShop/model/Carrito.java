package BootCamp.WebShop.model;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarrito;
    private int subTotal;
    private int total;
    private Timestamp creado;
    private Timestamp actualizado;
    @ManyToOne
    private Usuario usuario;
    
    // getters y setters
}
