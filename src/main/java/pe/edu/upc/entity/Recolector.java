package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="recolector",
indexes= {@Index(columnList = "nombre,apellido",name="recolector_index_nombre_apellido")}, 
uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "dni", "usuario", "celular"})})

public class Recolector implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idRecolector;
	
	@Column(name="usuario", nullable=false, length=30)
	private String usuario;
	
	@Column(name="contrasenia", nullable=false, length=60)
	private String contrasenia;
	
	@Column(name="nombre", nullable=false, length=20)
	private String nombre;
	
	@Column(name="apellido", nullable=false, length=20)
	private String apellido;
	
	@Column(name="dni", nullable=false, length=8)
	private Integer dni;
	
	@Column(name="celular", nullable=false, length=9)
	private Integer celular;
	
	@Column(name="email", nullable=false, length=40)
	private String email;
	
	@Column(name="direccion", nullable=false, length=50)
	private String direccion;
	
	@Column(name="fecha_nacimiento", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column(name="calificacion", nullable=false, columnDefinition = "DECIMAL(3,1)")
	private Float calificacion;
	
	@Column(name="tipo", nullable=false, length=15)
	private String tipo;
	
	@Column(name="ganancia", nullable=false, columnDefinition = "DECIMAL(4,1)")
	private Float ganancia;
	
	@ManyToOne
	@JoinColumn(name="idDistrito", nullable = false)
	private Distrito distrito;
//CONSULTAR ESTO	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRecolector;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Recolector other = (Recolector) obj;
		if (idRecolector != other.idRecolector)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public Recolector() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recolector(int idRecolector, String usuario, String contrasenia, String nombre, String apellido, Integer dni,
			Integer celular, String email, String direccion, Date fechaNacimiento, Float calificacion, String tipo,
			Float ganancia, Distrito distrito) {
		super();
		this.idRecolector = idRecolector;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.celular = celular;
		this.email = email;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.calificacion = calificacion;
		this.tipo = tipo;
		this.ganancia = ganancia;
		this.distrito = distrito;
	}

	public int getIdRecolector() {
		return idRecolector;
	}

	public void setIdRecolector(int idRecolector) {
		this.idRecolector = idRecolector;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getCelular() {
		return celular;
	}

	public void setCelular(Integer celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Float calificacion) {
		this.calificacion = calificacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Float getGanancia() {
		return ganancia;
	}

	public void setGanancia(Float ganancia) {
		this.ganancia = ganancia;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	
	 
	
	
}
