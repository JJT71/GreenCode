package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="residuo")
public class Residuo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idResiduo;
	
	@Column(name="nombre", nullable=false, length=30)
	private String nombre;
	
	@Column(name="peso", nullable=true, columnDefinition = "DECIMAL(3,1)")
	private Float peso;
	
	@ManyToOne
	@JoinColumn(name = "idCategoria", nullable = false)
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name = "idReciclador", nullable = false)
	private Reciclador reciclador;

	public Residuo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Residuo(int idResiduo, String nombre, Float peso, Categoria categoria, Reciclador reciclador) {
		super();
		this.idResiduo = idResiduo;
		this.nombre = nombre;
		this.peso = peso;
		this.categoria = categoria;
		this.reciclador = reciclador;
	}

	public int getIdResiduo() {
		return idResiduo;
	}

	public void setIdResiduo(int idResiduo) {
		this.idResiduo = idResiduo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Reciclador getReciclador() {
		return reciclador;
	}

	public void setReciclador(Reciclador reciclador) {
		this.reciclador = reciclador;
	}
	
	
}
