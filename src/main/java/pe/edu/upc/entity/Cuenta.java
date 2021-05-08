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
	
	@Column(name="numero_cuenta", nullable=false, length=20)
	private Integer numeroCuenta;
	
	@Column(name="contrasenia_cuenta", nullable=false, length=20)
	private String contraseniaCuenta;
	
	@ManyToOne
	@JoinColumn(name="idRecolector", nullable = false)
	private Recolector recolector;

	public Cuenta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cuenta(int idCuenta, Integer numeroCuenta, String contraseniaCuenta, Recolector recolector) {
		super();
		this.idCuenta = idCuenta;
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


	
	
}
