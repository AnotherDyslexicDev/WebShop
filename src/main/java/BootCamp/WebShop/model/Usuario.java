package BootCamp.WebShop.model;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String nombreUsuario;
    private String email;
    private String telefono;
    private String password;
    private String direccion;
    private java.sql.Timestamp creado;
    private java.sql.Timestamp actualizado;
    private String token;
    private java.sql.Timestamp setExpirationDate;
    @JoinColumn(name = "roles_idRol")
    private int roles_idRol;
    @JoinColumn(name = "estados_idEstado")
    private int estados_idEstado;
	public Usuario(int idUsuario, String nombreUsuario, String email, String telefono, String password,
			String direccion, Timestamp creado, Timestamp actualizado, String token,Timestamp setExpirationDate, int roles_idRol,
			int estados_idEstado) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
		this.direccion = direccion;
		this.creado = creado;
		this.actualizado = actualizado;
		this.token = token;
		this.setExpirationDate=setExpirationDate;
		this.roles_idRol = roles_idRol;
		this.estados_idEstado = estados_idEstado;
	}
	public Usuario() {
		super();
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public java.sql.Timestamp getSetExpirationDate() {
		return setExpirationDate;
	}
	public void setSetExpirationDate(java.sql.Timestamp setExpirationDate) {
		this.setExpirationDate = setExpirationDate;
	}
	public int getRoles_idRol() {
		return roles_idRol;
	}
	public void setRoles_idRol(int roles_idRol) {
		this.roles_idRol = roles_idRol;
	}
	public int getEstados_idEstado() {
		return estados_idEstado;
	}
	public void setEstados_idEstado(int estados_idEstado) {
		this.estados_idEstado = estados_idEstado;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", email=" + email
				+ ", telefono=" + telefono + ", password=" + password + ", direccion=" + direccion + ", creado="
				+ creado + ", actualizado=" + actualizado + ", token=" + token +", setExpirationDate=" + setExpirationDate + ", roles_idRol=" + roles_idRol
				+ ", estados_idEstado=" + estados_idEstado + "]";
	}

    
    
}
