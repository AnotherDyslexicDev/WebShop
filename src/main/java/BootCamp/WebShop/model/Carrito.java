package BootCamp.WebShop.model;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @ManyToOne
    @JoinColumn(name = "usuario_idUsuario")
    private Usuario usuario;    
    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCarrito> detallesCarrito;
    @OneToOne
    @JoinColumn(name = "estados_idEstado")
    private Estados estados;
	public Carrito(int idCarrito, int subTotal, int total, Timestamp creado, Timestamp actualizado, Usuario usuario,
			List<DetalleCarrito> detallesCarrito, Estados estados) {
		super();
		this.idCarrito = idCarrito;
		this.subTotal = subTotal;
		this.total = total;
		this.creado = creado;
		this.actualizado = actualizado;
		this.usuario = usuario;
		this.detallesCarrito = detallesCarrito;
		this.estados = estados;
	}
	public Carrito() {
		super();
	}
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<DetalleCarrito> getDetallesCarrito() {
		return detallesCarrito;
	}
	public void setDetallesCarrito(List<DetalleCarrito> detallesCarrito) {
		this.detallesCarrito = detallesCarrito;
	}
	public Estados getEstados() {
		return estados;
	}
	public void setEstados(Estados estados) {
		this.estados = estados;
	}
	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", subTotal=" + subTotal + ", total=" + total + ", creado=" + creado
				+ ", actualizado=" + actualizado + ", usuario=" + usuario + ", detallesCarrito=" + detallesCarrito
				+ ", estados=" + estados + "]";
	}
	
    
    
	
}
