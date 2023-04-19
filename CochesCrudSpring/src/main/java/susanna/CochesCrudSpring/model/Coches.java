package susanna.CochesCrudSpring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "coches")
public class Coches {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int Id;

	@Column(name = "modelo", nullable = false)
	private String modelo;

	@Column(name = "marca", nullable = false)
	private String marca;
	@Column(name = "precio", nullable = false)
	private int precio;
	@Column(name = "pais", nullable = false)
	private String pais;
	@Column(name = "cv", nullable = false)
	private int cv;
	@Column(name = "fotos", nullable = false)
	private String foto;
	/**
	 * @param Id
	 * @param modelo
	 * @param marca
	 * @param precio
	 * @param pais
	 * @param cv
	 * @param foto
	 */
	public Coches(int Id, String modelo, String marca, int precio, String pais, int cv, String foto) {
		super();
		this.Id = Id;
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
		this.pais = pais;
		this.cv = cv;
		this.foto = foto;
	}
	/**
	 * 
	 */
	public Coches() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Coches [Id=" + Id + ", modelo=" + modelo + ", marca=" + marca + ", precio=" + precio
				+ ", pais=" + pais + ", cv=" + cv + ", foto=" + foto + "]";
	}
	public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	

}
