package BootCamp.WebShop.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Productos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    
    private String nombreProducto;
    
    private String descripcion;
    
    private int precio;
    
    private int stock;
    
    private java.sql.Timestamp creado;
    
    private java.sql.Timestamp actualizado;
    
    private String imagen;
    
    private String imagenSlider;
    
    @ManyToOne
    private Categoria categorias;
    
    @ManyToOne
    private Proveedor proveedores;
    
    // getters y setters
}
