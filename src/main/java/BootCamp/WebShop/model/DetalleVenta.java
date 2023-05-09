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

	public DetalleVenta(int idDetalleVenta, int subTotalVenta, Timestamp creado, Timestamp actualizado, Venta venta,
			Productos producto) {
		super();
		this.idDetalleVenta = idDetalleVenta;
		this.subTotalVenta = subTotalVenta;
		this.creado = creado;
		this.actualizado = actualizado;
		this.venta = venta;
		this.producto = producto;
	}

	public DetalleVenta() {
		super();
	}

	public int getIdDetalleVenta() {
		return idDetalleVenta;
	}

	public void setIdDetalleVenta(int idDetalleVenta) {
		this.idDetalleVenta = idDetalleVenta;
	}

	public int getSubTotalVenta() {
		return subTotalVenta;
	}

	public void setSubTotalVenta(int subTotalVenta) {
		this.subTotalVenta = subTotalVenta;
	}

	public java.sql.Timestamp getCreado() {
		return creado;
	}

	public void setCreado(java.sql.Timestamp creado) {
		this.creado = creado;
	}

	public java.sql.Timestamp getActualizado() {
		return actualizado;
	}

	public void setActualizado(java.sql.Timestamp actualizado) {
		this.actualizado = actualizado;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "DetalleVenta [idDetalleVenta=" + idDetalleVenta + ", subTotalVenta=" + subTotalVenta + ", creado="
				+ creado + ", actualizado=" + actualizado + ", venta=" + venta + ", producto=" + producto + "]";
	}

	
}
