package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import pe.edu.upc.entity.Pedido;
import pe.edu.upc.service.IPedidoService;

@Named
@RequestScoped
public class PedidoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IPedidoService pService;


	private Pedido pedido;
	
	
	List<Pedido> listaPedidos;
	
	@PostConstruct
	public void init() {
		pedido = new Pedido();
		
		listaPedidos = new ArrayList<Pedido>();
		
		this.listPedido();
	}
	
	public String nuevoPedido() {
		this.setPedido(new Pedido());
		return "residuo.xhtml";
	}
	
	public void insertar() {
		pService.insertar(pedido);
		limpiarPedido();
		this.listPedido();
	}
	

	public void listPedido() {
		listaPedidos = pService.listar();
	}	
	
	public void limpiarPedido() {
		this.init();
	}
	
	public void eliminar(Pedido pedido) {
		pService.eliminar(pedido.getIdPedido());
		this.listPedido();
	}
	//

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	
}
