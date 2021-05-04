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
@Table(name="transaccion")
public class Transaccion implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idTransaccion;
	
	@Column(name="nombre", nullable=false, length=20) // esto no iria creo
	private String nombre;
	
	@Column(name="fecha", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name="tipo_pago", nullable=false, length=20) //EFECTIVO - ONLINE
	private String tipoPago;
	
	@Column(name="tipo_transaccion", nullable=false, length=20)//recargar - cobro
	private String tipoTransaccion;
	
	@Column(name="monto", nullable=false, columnDefinition = "DECIMAL(3,1)")
	private Float monto;
	
	@ManyToOne
	@JoinColumn(name = "idCuenta", nullable = false)
	private Cuenta cuenta;

	public Transaccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaccion(int idTransaccion, String nombre, Date fecha, String tipoPago, String tipoTransaccion,
			Float monto, Cuenta cuenta) {
		super();
		this.idTransaccion = idTransaccion;
		this.nombre = nombre;
		this.fecha = fecha;
		this.tipoPago = tipoPago;
		this.tipoTransaccion = tipoTransaccion;
		this.monto = monto;
		this.cuenta = cuenta;
	}

	public int getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(int idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipoPago() {
		return tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public Float getMonto() {
		return monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	
}
