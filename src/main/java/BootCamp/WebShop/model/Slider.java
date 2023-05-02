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
public class Slider {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSlider;	
	@JoinColumn(name = "productos_idProducto")
	private int productos_idProducto;	
	private String imagenSlider;
	private java.sql.Timestamp creado;
	private java.sql.Timestamp actualizado;
    @JoinColumn(name = "estados_idEstado")
	private int estados_idEstado;
	public Slider(int idSlider, int productos_idProducto, String imagenSlider, Timestamp creado,
			Timestamp actualizado,int estados_idEstado) {
		super();
		this.idSlider = idSlider;
		this.productos_idProducto = productos_idProducto;
		this.imagenSlider = imagenSlider;
		this.creado = creado;
		this.actualizado = actualizado;
		this.estados_idEstado=estados_idEstado; 
	}
	public Slider() {
		super();
	}
	public int getIdSlider() {
		return idSlider;
	}
	public void setIdSlider(int idSlider) {
		this.idSlider = idSlider;
	}
	public int getProductos_idProducto() {
		return productos_idProducto;
	}
	public void setProductos_idProducto(int productos_idProducto) {
		this.productos_idProducto = productos_idProducto;
	}
	public String getImagenSlider() {
		return imagenSlider;
	}
	public void setImagenSlider(String imagenSlider) {
		this.imagenSlider = imagenSlider;
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
	public int getEstados_idEstado() {
		return estados_idEstado;
	}
	public void setEstados_idEstado(int estados_idEstado) {
		this.estados_idEstado = estados_idEstado;
	}
	@Override
	public String toString() {
		return "Slider [idSlider=" + idSlider + ", productos_idProducto=" + productos_idProducto + ", imagenSlider="
				+ imagenSlider + ", creado=" + creado + ", actualizado=" + actualizado +  ", estados_idEstado=" + estados_idEstado +"]";
	}

	



}
