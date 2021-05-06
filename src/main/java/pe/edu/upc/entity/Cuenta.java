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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="cuenta",
uniqueConstraints = {@UniqueConstraint(columnNames = {"numero_cuenta"})}
		)
public class Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idCuenta;
	
	@Column(name="numero_cuenta", nullable=false)
	private Integer numeroCuenta;
	
	@Column(name="contrasenia_cuenta", nullable=false, length=20)
	private String contraseniaCuenta;
	
	@ManyToOne
	@JoinColumn(name="idRecolector", nullable = false)
	private Recolector recolector;

	public Cuenta() {
		super();
	}

	public Cuenta(Integer numeroCuenta, String contraseniaCuenta, Recolector recolector) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.contraseniaCuenta = contraseniaCuenta;
		this.recolector = recolector;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Integer numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getContraseniaCuenta() {
		return contraseniaCuenta;
	}

	public void setContraseniaCuenta(String contraseniaCuenta) {
		this.contraseniaCuenta = contraseniaCuenta;
	}

	public Recolector getRecolector() {
		return recolector;
	}

	public void setRecolector(Recolector recolector) {
		this.recolector = recolector;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contraseniaCuenta == null) ? 0 : contraseniaCuenta.hashCode());
		result = prime * result + idCuenta;
		result = prime * result + ((numeroCuenta == null) ? 0 : numeroCuenta.hashCode());
		result = prime * result + ((recolector == null) ? 0 : recolector.hashCode());
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
		Cuenta other = (Cuenta) obj;
		if (contraseniaCuenta == null) {
			if (other.contraseniaCuenta != null)
				return false;
		} else if (!contraseniaCuenta.equals(other.contraseniaCuenta))
			return false;
		if (idCuenta != other.idCuenta)
			return false;
		if (numeroCuenta == null) {
			if (other.numeroCuenta != null)
				return false;
		} else if (!numeroCuenta.equals(other.numeroCuenta))
			return false;
		if (recolector == null) {
			if (other.recolector != null)
				return false;
		} else if (!recolector.equals(other.recolector))
			return false;
		return true;
	}
	
	
	
	
	
}
