package BootCamp.WebShop.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoria;
    private int idCategoriaPadre;
    private String nombreCategoria;
    private String descripcion;
    private java.sql.Timestamp creado;
    private java.sql.Timestamp actualizado;
    @OneToOne
    @JoinColumn(name = "estados_idEstado")
    private Estados estados;
    
    // getters y setters
}