package BootCamp.WebShop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "formapago")
public class FormaPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormaPago;
    private String nombreFormaPago;
    private java.sql.Timestamp creada;
    private java.sql.Timestamp actualizada;
    @JoinColumn(name = "estados_idEstado")
    private int estados_idEstado;
    // getters y setters
}