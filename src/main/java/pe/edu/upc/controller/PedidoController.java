package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import pe.edu.upc.entity.Pedido;
import pe.edu.upc.entity.Reciclador;
import pe.edu.upc.service.IPedidoService;
import pe.edu.upc.service.IRecicladorService;

@Named
@RequestScoped
public class PedidoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IPedidoService pService;
	
	@Inject 
	private IRecicladorService rService;

	private Reciclador reciclador;
	private Pedido pedido;
	
	
	List<Pedido> listaPedidos;
	List<Reciclador> listaRecicladores;
	
	
	@PostConstruct
	public void init() {
		pedido = new Pedido();
		reciclador=new Reciclador();
		
		listaPedidos = new ArrayList<Pedido>();
		listaRecicladores=new ArrayList<Reciclador>();
		
		this.listPedido();
		this.listReciclador();
	}
	
	public String nuevoPedido() {
		this.setPedido(new Pedido());
		return "Pedido.xhtml";
	}
	
	public void insertar() {
		pService.insertar(pedido);
		limpiarPedido();
		this.listPedido();
	}
	

	public void listPedido() {
		listaPedidos = pService.listar();
	}	
	public void listReciclador() {
		listaRecicladores = rService.listar();
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

	public Reciclador getReciclador() {
		return reciclador;
	}

	public void setReciclador(Reciclador reciclador) {
		this.reciclador = reciclador;
	}

	public List<Reciclador> getListaRecicladores() {
		return listaRecicladores;
	}

	public void setListaRecicladores(List<Reciclador> listaRecicladores) {
		this.listaRecicladores = listaRecicladores;
	}

	
	
}
