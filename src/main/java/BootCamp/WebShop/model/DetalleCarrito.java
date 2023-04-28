package BootCamp.WebShop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "detallecarrito")
public class DetalleCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleCarrito;
    private Timestamp creado;
    private Timestamp actualizado;
    
    @ManyToOne
    @JoinColumn(name = "carrito_idCarrito")
    private Carrito carrito;
    
    @ManyToOne
    @JoinColumn(name = "productos_idProducto")
    private Productos producto;
    
    // getters y setters
}
