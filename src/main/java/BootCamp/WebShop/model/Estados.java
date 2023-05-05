package BootCamp.WebShop.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "estados")
public class Estados {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEstado;
	private String nombreEstado;
	private Timestamp creado;
	private Timestamp actualizado;
	public Estados(int idEstado, String nombreEstado, Timestamp creado, Timestamp actualizado) {
		super();
		this.idEstado = idEstado;
		this.nombreEstado = nombreEstado;
		this.creado = creado;
		this.actualizado = actualizado;
	}
	public Estados() {
		super();
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public String getNombreEstado() {
		return nombreEstado;
	}
	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
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
	@Override
	public String toString() {
		return "Estados [idEstado=" + idEstado + ", nombreEstado=" + nombreEstado + ", creado=" + creado
				+ ", actualizado=" + actualizado + "]";
	}
	
}
