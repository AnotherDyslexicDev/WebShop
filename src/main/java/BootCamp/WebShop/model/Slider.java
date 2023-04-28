package BootCamp.WebShop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "slider")
public class Slider {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idSlider;
private int productos_idProducto;
}
