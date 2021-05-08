package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cupon")
public class Cupon implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//HOLA
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idCupon;
	
	@Column(name="nombre_cupon", nullable=false, length=30)
	private String nombre;
	
	@Column(name="fecha_expiracion", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date fechaExpiracion;
	
	@Column(name="codigo", nullable=false, length=10)
	private String codigo;
	
	@Column(name="puntaje", nullable=false)
	private Integer puntaje;
	
	@ManyToOne
	@JoinColumn(name="idReciclador", nullable = false)
	private Reciclador reciclador;

	public Cupon() {
		super();
	}

	public Cupon(int idCupon, String nombre, Date fechaExpiracion, String codigo, Integer puntaje,
			Reciclador reciclador) {
		super();
		this.idCupon = idCupon;
		this.nombre = nombre;
		this.fechaExpiracion = fechaExpiracion;
		this.codigo = codigo;
		this.puntaje = puntaje;
		this.reciclador = reciclador;
	}

	public int getIdCupon() {
		return idCupon;
	}

	public void setIdCupon(int idCupon) {
		this.idCupon = idCupon;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	public Reciclador getReciclador() {
		return reciclador;
	}

	public void setReciclador(Reciclador reciclador) {
		this.reciclador = reciclador;
	}

	
	
}