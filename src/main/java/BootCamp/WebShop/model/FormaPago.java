package BootCamp.WebShop.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "formapago")
public class FormaPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormaPago;
    private String nombreFormaPago;
    private String imagenFormaPago;
    private java.sql.Timestamp creada;
    private java.sql.Timestamp actualizada;
    @OneToOne
    @JoinColumn(name = "estados_idEstado")
    private Estados estados;
	public FormaPago(int idFormaPago, String nombreFormaPago, String imagenFormaPago, Timestamp creada,
			Timestamp actualizada, Estados estados) {
		super();
		this.idFormaPago = idFormaPago;
		this.nombreFormaPago = nombreFormaPago;
		this.imagenFormaPago = imagenFormaPago;
		this.creada = creada;
		this.actualizada = actualizada;
		this.estados = estados;
	}
	public FormaPago() {
		super();
	}
	public int getIdFormaPago() {
		return idFormaPago;
	}
	public void setIdFormaPago(int idFormaPago) {
		this.idFormaPago = idFormaPago;
	}
	public String getNombreFormaPago() {
		return nombreFormaPago;
	}
	public void setNombreFormaPago(String nombreFormaPago) {
		this.nombreFormaPago = nombreFormaPago;
	}
	public String getImagenFormaPago() {
		return imagenFormaPago;
	}
	public void setImagenFormaPago(String imagenFormaPago) {
		this.imagenFormaPago = imagenFormaPago;
	}
	public java.sql.Timestamp getCreada() {
		return creada;
	}
	public void setCreada(java.sql.Timestamp creada) {
		this.creada = creada;
	}
	public java.sql.Timestamp getActualizada() {
		return actualizada;
	}
	public void setActualizada(java.sql.Timestamp actualizada) {
		this.actualizada = actualizada;
	}
	public Estados getEstados() {
		return estados;
	}
	public void setEstados(Estados estados) {
		this.estados = estados;
	}
	@Override
	public String toString() {
		return "FormaPago [idFormaPago=" + idFormaPago + ", nombreFormaPago=" + nombreFormaPago + ", imagenFormaPago="
				+ imagenFormaPago + ", creada=" + creada + ", actualizada=" + actualizada + ", estados=" + estados
				+ "]";
	}
    
	
}