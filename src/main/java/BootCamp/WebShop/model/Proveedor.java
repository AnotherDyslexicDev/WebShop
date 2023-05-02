package BootCamp.WebShop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProveedor;
    private String nombreProveedor;
    private String rutProveedor;
    private String direccionProveedor;
    private String telefonoProveedor;
    private String correoProveedor;
    @JoinColumn(name = "estados_idEstado")
    private int estados_idEstado;
    // getters y setters
}
