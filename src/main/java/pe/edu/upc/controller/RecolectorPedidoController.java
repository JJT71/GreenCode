package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.RecolectorPedido;
import pe.edu.upc.service.IRecolectorPedidoService;

@Named
@RequestScoped
public class RecolectorPedidoController implements Serializable{
private static final long serialVersionUID = 1L;
	

	@Inject
	private IRecolectorPedidoService rService;
	
	private RecolectorPedido recolectorPedido;
	List<RecolectorPedido> listaRecolectorPedidos;
	
	@PostConstruct
	public void init() {
		this.listaRecolectorPedidos = new ArrayList<RecolectorPedido>();
		this.recolectorPedido= new RecolectorPedido();
		this.listar();
	}
	
	public String nuevoRecolectorPedido() {
		this.setRecolectorPedido(new RecolectorPedido());
		return "recolectorPedido.xhtml";
	}
	
	public void insertar() {
		rService.insertar(recolectorPedido);
		limpiarRecolectorPedido();
		this.listar();
	}
	
	public void listar() {
		listaRecolectorPedidos = rService.listar();
	}
	
	public void limpiarRecolectorPedido() {
		this.init();
	}
	
	public void eliminar(RecolectorPedido recolectorPedido) {
		rService.eliminar(recolectorPedido.getIdRecolectorPedido());
		this.listar();
	}

	public RecolectorPedido getRecolectorPedido() {
		return recolectorPedido;
	}

	public void setRecolectorPedido(RecolectorPedido recolectorPedido) {
		this.recolectorPedido = recolectorPedido;
	}

	public List<RecolectorPedido> getlistaRecolectorPedidos() {
		return listaRecolectorPedidos;
	}

	public void setListalistaRecolectorPedidos(List<RecolectorPedido> listaRecolectorPedidos) {
		this.listaRecolectorPedidos = listaRecolectorPedidos;
	}
	
}
