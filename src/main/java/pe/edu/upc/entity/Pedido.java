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
	
	@Column(name="monto_total", nullable=true, columnDefinition = "DECIMAL(5,2)")
	private Float montoTotal;
	
	@Column(name="tiempo_llegada", nullable=false)
	private Integer tiempoLlegada;
	
	@Column(name="estado", nullable = false, length = 20)
	private String estado;

	@ManyToOne
	@JoinColumn(name="idReciclador", nullable = false)
	private Reciclador reciclador;
	
	public Pedido() {
		super();
	}

	public Pedido(int idPedido, Date fecha, Float montoTotal, Integer tiempoLlegada, String estado,
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

	public Integer getTiempoLlegada() {
		return tiempoLlegada;
	}

	public void setTiempoLlegada(Integer tiempoLlegada) {
		this.tiempoLlegada = tiempoLlegada;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + idPedido;
		result = prime * result + ((montoTotal == null) ? 0 : montoTotal.hashCode());
		result = prime * result + ((reciclador == null) ? 0 : reciclador.hashCode());
		result = prime * result + ((tiempoLlegada == null) ? 0 : tiempoLlegada.hashCode());
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
		Pedido other = (Pedido) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (idPedido != other.idPedido)
			return false;
		if (montoTotal == null) {
			if (other.montoTotal != null)
				return false;
		} else if (!montoTotal.equals(other.montoTotal))
			return false;
		if (reciclador == null) {
			if (other.reciclador != null)
				return false;
		} else if (!reciclador.equals(other.reciclador))
			return false;
		if (tiempoLlegada == null) {
			if (other.tiempoLlegada != null)
				return false;
		} else if (!tiempoLlegada.equals(other.tiempoLlegada))
			return false;
		return true;
	}
	
	
	
	
}
