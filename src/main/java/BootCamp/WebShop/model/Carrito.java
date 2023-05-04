package BootCamp.WebShop.model;


import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carrito")
public class Carrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "carrito_idCarrito")
    private int idCarrito;
    private int subTotal;
    private int total;
    private Timestamp creado;
    private Timestamp actualizado;
    @JoinColumn(name = "usuario_idUsuario")
    private int usuario_idUsuario;
    
    
	public Carrito(int idCarrito, int subTotal, int total, Timestamp creado, Timestamp actualizado,
			int usuario_idUsuario) {
		super();
		this.idCarrito = idCarrito;
		this.subTotal = subTotal;
		this.total = total;
		this.creado = creado;
		this.actualizado = actualizado;
		this.usuario_idUsuario = usuario_idUsuario;
	}
	public Carrito() {
		super();
	}
	 // getters y setters
	public int getIdCarrito() {
		return idCarrito;
	}
	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}
	public int getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
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
	public int getUsuario_idUsuario() {
		return usuario_idUsuario;
	}
	public void setUsuario_idUsuario(int usuario_idUsuario) {
		this.usuario_idUsuario = usuario_idUsuario;
	}
	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", subTotal=" + subTotal + ", total=" + total + ", creado=" + creado
				+ ", actualizado=" + actualizado + ", usuario_idUsuario=" + usuario_idUsuario + "]";
	}
    
   
	
	
    
}
