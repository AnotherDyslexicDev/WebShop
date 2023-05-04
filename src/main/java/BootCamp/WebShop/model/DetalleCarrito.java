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
    @JoinColumn(name = "carrito_idCarrito")
    private int carrito_idCarrito;    
    @JoinColumn(name = "productos_idProducto")
    private int productos_idProducto;
	public DetalleCarrito(int idDetalleCarrito, Timestamp creado, Timestamp actualizado, int carrito_idCarrito,
			int productos_idProducto) {
		super();
		this.idDetalleCarrito = idDetalleCarrito;
		this.creado = creado;
		this.actualizado = actualizado;
		this.carrito_idCarrito = carrito_idCarrito;
		this.productos_idProducto = productos_idProducto;
	}
	public DetalleCarrito() {
		super();
	}
	
	// getters y setters
	public int getIdDetalleCarrito() {
		return idDetalleCarrito;
	}
	public void setIdDetalleCarrito(int idDetalleCarrito) {
		this.idDetalleCarrito = idDetalleCarrito;
	}
	public Timestamp getCreado() {
		return creado;
	}
	public void setCreado(Timestamp creado) {
		this.creado = creado;
	}
	public Timestamp getActualizado() {
		return actualizado;
	}
	public void setActualizado(Timestamp actualizado) {
		this.actualizado = actualizado;
	}
	public int getCarrito_idCarrito() {
		return carrito_idCarrito;
	}
	public void setCarrito_idCarrito(int carrito_idCarrito) {
		this.carrito_idCarrito = carrito_idCarrito;
	}
	public int getProductos_idProducto() {
		return productos_idProducto;
	}
	public void setProductos_idProducto(int productos_idProducto) {
		this.productos_idProducto = productos_idProducto;
	}
	@Override
	public String toString() {
		return "DetalleCarrito [idDetalleCarrito=" + idDetalleCarrito + ", creado=" + creado + ", actualizado="
				+ actualizado + ", carrito_idCarrito=" + carrito_idCarrito + ", productos_idProducto="
				+ productos_idProducto + "]";
	}    
    
    
	
	
}
