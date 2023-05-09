package BootCamp.WebShop.model;
import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "venta")
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVenta;     
    private int totalVenta;    
    private Timestamp creado;    
    private Timestamp actualizado;    
    @ManyToOne
    @JoinColumn(name = "usuario_idUsuario", nullable = false)
    private Usuario usuario;    
    @ManyToOne
    @JoinColumn(name = "formapago_idFormaPago", nullable = false)
    private FormaPago formaPago;

	public Venta(int idVenta, int totalVenta, Timestamp creado, Timestamp actualizado, Usuario usuario,
			FormaPago formaPago) {
		super();
		this.idVenta = idVenta;
		this.totalVenta = totalVenta;
		this.creado = creado;
		this.actualizado = actualizado;
		this.usuario = usuario;
		this.formaPago = formaPago;
	}

	public Venta() {
		super();
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public int getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(int totalVenta) {
		this.totalVenta = totalVenta;
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

	public FormaPago getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", totalVenta=" + totalVenta + ", creado=" + creado + ", actualizado="
				+ actualizado + ", usuario=" + usuario + ", formaPago=" + formaPago + "]";
	}
    
    
}
