package BootCamp.WebShop.model;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;
import BootCamp.WebShop.model.Productos;

@ToString
@Entity
public class Slider {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSlider;
	@ManyToOne
	@JoinColumn(name = "productos_idProducto")
	private Productos producto;
	private String imagenSlider;
	private java.sql.Timestamp creado;
	private java.sql.Timestamp actualizado;
	public Slider(int idSlider, Productos producto, String imagenSlider, Timestamp creado, Timestamp actualizado) {
		super();
		this.idSlider = idSlider;
		this.producto = producto;
		this.imagenSlider = imagenSlider;
		this.creado = creado;
		this.actualizado = actualizado;
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
	public Productos getProducto() {
		return producto;
	}
	public void setProducto(Productos producto) {
		this.producto = producto;
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
	@Override
	public String toString() {
		return "Slider [idSlider=" + idSlider + ", producto=" + producto + ", imagenSlider=" + imagenSlider
				+ ", creado=" + creado + ", actualizado=" + actualizado + "]";
	}

}
