package BootCamp.WebShop.model;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalleventa")
public class DetalleVenta {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idDetalleVenta;
private int subTotalVenta;
private java.sql.Timestamp creado;
private java.sql.Timestamp actualizado;
	@ManyToOne
	@JoinColumn(name = "venta_idVenta")
	private Venta venta;

	@ManyToOne
	@JoinColumn(name = "productos_idProducto")
	private Productos producto;

	// getters y setters
}
