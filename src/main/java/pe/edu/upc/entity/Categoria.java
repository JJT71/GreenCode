package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idCategoria;
	
	@Column(name="nombre", nullable=false, length=10)
	private String nombre;
	
	@Column(name="precio_kilo", nullable=false, columnDefinition = "DECIMAL(3,2)")
	private Float precioKilo;

	public Categoria() {
		super();
	}

	public Categoria(int idCategoria, String nombre, Float precioKilo) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.precioKilo = precioKilo;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getPrecioKilo() {
		return precioKilo;
	}

	public void setPrecioKilo(Float precioKilo) {
		this.precioKilo = precioKilo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCategoria;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precioKilo == null) ? 0 : precioKilo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (idCategoria != other.idCategoria)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precioKilo == null) {
			if (other.precioKilo != null)
				return false;
		} else if (!precioKilo.equals(other.precioKilo))
			return false;
		return true;
	}
	
	
	
}
