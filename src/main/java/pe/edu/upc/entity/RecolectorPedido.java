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
@Table(name="recolector_pedido")
public class RecolectorPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idRecolectorPedido;
	
	@Column(name="cantidad", nullable=false, length=3)
	private int cantidad;
	
	@Column(name="precio", nullable=false, columnDefinition = "DECIMAL(3,1)")
	private Float precio;
	
	@ManyToOne
	@JoinColumn(name="idRecolector", nullable = false)
	private Recolector recolector;
	
	@ManyToOne
	@JoinColumn(name="idPedido", nullable = false)
	private Pedido pedido;

	public RecolectorPedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecolectorPedido(int idRecolectorPedido, int cantidad, Float precio, Recolector recolector,
			Pedido pedido) {
		super();
		this.idRecolectorPedido = idRecolectorPedido;
		this.cantidad = cantidad;
		this.precio = precio;
		this.recolector = recolector;
		this.pedido = pedido;
	}

	public int getIdRecolectorPedido() {
		return idRecolectorPedido;
	}

	public void setIdRecolectorPedido(int idRecolectorPedido) {
		this.idRecolectorPedido = idRecolectorPedido;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Recolector getRecolector() {
		return recolector;
	}

	public void setRecolector(Recolector recolector) {
		this.recolector = recolector;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
	
}
