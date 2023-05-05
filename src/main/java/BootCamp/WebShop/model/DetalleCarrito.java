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
    @JoinColumn(name = "idDetalleCarrito")
    private int idDetalleCarrito;
    private Timestamp creado;
    private Timestamp actualizado;
    @ManyToOne
    @JoinColumn(name = "carrito_idCarrito")
    private Carrito carrito;
    @ManyToOne
    @JoinColumn(name = "productos_idProducto")
    private Productos producto;
    private int cantidad;
	public DetalleCarrito(int idDetalleCarrito, Timestamp creado, Timestamp actualizado, Carrito carrito,
			Productos producto, int cantidad) {
		super();
		this.idDetalleCarrito = idDetalleCarrito;
		this.creado = creado;
		this.actualizado = actualizado;
		this.carrito = carrito;
		this.producto = producto;
		this.cantidad = cantidad;
	}
	public DetalleCarrito() {
		super();
	}
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
	public Carrito getCarrito() {
		return carrito;
	}
	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}
	public Productos getProducto() {
		return producto;
	}
	public void setProducto(Productos producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "DetalleCarrito [idDetalleCarrito=" + idDetalleCarrito + ", creado=" + creado + ", actualizado="
				+ actualizado + ", carrito=" + carrito + ", producto=" + producto + ", cantidad=" + cantidad + "]";
	}
	
    
}
