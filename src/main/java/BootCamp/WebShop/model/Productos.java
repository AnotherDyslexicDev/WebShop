package BootCamp.WebShop.model;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import lombok.ToString;

@ToString
@Entity
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
    @JoinColumn(name = "categorias_idCategoria")
    private String categorias_idCategoria;   
    @JoinColumn(name = "proveedores_idProveedor")
    private String proveedores_idProveedor;
    @JoinColumn(name = "estados_idEstado")
    private int estados_idEstado;
	public Productos(int idProducto, String nombreProducto, String descripcion, int precio, int stock, Timestamp creado,
			Timestamp actualizado, String imagen, String imagenSlider, String categorias_idCategoria,
			String proveedores_idProveedor, int estados_idEstado) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.creado = creado;
		this.actualizado = actualizado;
		this.imagen = imagen;
		this.imagenSlider = imagenSlider;
		this.categorias_idCategoria = categorias_idCategoria;
		this.proveedores_idProveedor = proveedores_idProveedor;
		this.estados_idEstado = estados_idEstado;
	}
	public Productos() {
		super();
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
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
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getImagenSlider() {
		return imagenSlider;
	}
	public void setImagenSlider(String imagenSlider) {
		this.imagenSlider = imagenSlider;
	}
	public String getCategorias_idCategoria() {
		return categorias_idCategoria;
	}
	public void setCategorias_idCategoria(String categorias_idCategoria) {
		this.categorias_idCategoria = categorias_idCategoria;
	}
	public String getProveedores_idProveedor() {
		return proveedores_idProveedor;
	}
	public void setProveedores_idProveedor(String proveedores_idProveedor) {
		this.proveedores_idProveedor = proveedores_idProveedor;
	}
	public int getEstados_idEstado() {
		return estados_idEstado;
	}
	public void setEstados_idEstado(int estados_idEstado) {
		this.estados_idEstado = estados_idEstado;
	}
	@Override
	public String toString() {
		return "Productos [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", descripcion="
				+ descripcion + ", precio=" + precio + ", stock=" + stock + ", creado=" + creado + ", actualizado="
				+ actualizado + ", imagen=" + imagen + ", imagenSlider=" + imagenSlider + ", categorias_idCategoria="
				+ categorias_idCategoria + ", proveedores_idProveedor=" + proveedores_idProveedor
				+ ", estados_idEstado=" + estados_idEstado + "]";
	}
    
}
