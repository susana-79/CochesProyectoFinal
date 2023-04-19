package susana.CochesSpring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="coches")
public class Coches {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="id")
private int id;
@Column(name="modelo")
private String modelo;
@Column(name="marca")
private String marca;
@Column(name="precio")
private int precio;
@Column(name="pais")
private String pais;
@Column(name="cv")
private int cv;
@Column(name="fotos")
private String fotos;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public String getPais() {
	return pais;
}
public void setPais(String pais) {
	this.pais = pais;
}
public int getCv() {
	return cv;
}
public void setCv(int cv) {
	this.cv = cv;
}
public String getFotos() {
	return fotos;
}
public void setFotos(String fotos) {
	this.fotos = fotos;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public int getPrecio() {
	return precio;
}
public void setPrecio(int precio) {
	this.precio = precio;
}

@Override
public String toString() {
	return "Coches [id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", precio=" + precio + ", pais=" + pais
			+ ", cv=" + cv + ", fotos=" + fotos + "]";
}
public Coches () {

}
/**
 * @param id
 * @param modelo
 * @param marca
 * @param precio
 * @param pais
 * @param cv
 * @param fotos
 */
public Coches(int id, String modelo, String marca, int precio, String pais, int cv, String fotos) {
	super();
	this.id = id;
	this.modelo = modelo;
	this.marca = marca;
	this.precio = precio;
	this.pais = pais;
	this.cv = cv;
	this.fotos = fotos;
}
}
