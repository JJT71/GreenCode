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
@Table(name="pedido")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idPedido;
	
	@Column(name="fecha", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name="monto_total", nullable=false, columnDefinition = "DECIMAL(3,1)")
	private Float montoTotal;
	
	@Column(name="tiempo_llegada", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date tiempoLlegada;
	
	@Column(name="estado", nullable = false, length = 20)
	private String estado;

	@ManyToOne
	@JoinColumn(name="idReciclador", nullable = false)
	private Reciclador reciclador;
	
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pedido(int idPedido, Date fecha, Float montoTotal, Date tiempoLlegada, String estado,
			Reciclador reciclador) {
		super();
		this.idPedido = idPedido;
		this.fecha = fecha;
		this.montoTotal = montoTotal;
		this.tiempoLlegada = tiempoLlegada;
		this.estado = estado;
		this.reciclador = reciclador;
	}

	public Reciclador getReciclador() {
		return reciclador;
	}

	public void setReciclador(Reciclador reciclador) {
		this.reciclador = reciclador;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Float getMontoTotal() {
		return montoTotal;
	}

	public void setMontoTotal(Float montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Date getTiempoLlegada() {
		return tiempoLlegada;
	}

	public void setTiempoLlegada(Date tiempoLlegada) {
		this.tiempoLlegada = tiempoLlegada;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
}
