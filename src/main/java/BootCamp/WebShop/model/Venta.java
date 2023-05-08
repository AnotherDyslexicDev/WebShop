package BootCamp.WebShop.model;
import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "venta")
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;   
    
    private int totalVenta;
    
    private Timestamp creado;
    
    private Timestamp actualizado;
    
    @ManyToOne
    @JoinColumn(name = "usuario_idUsuario", nullable = false)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "formapago_idFormaPago", nullable = false)
    private FormaPago formaPago;
    
    // getters y setters
}
