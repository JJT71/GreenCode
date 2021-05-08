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
import pe.edu.upc.entity.Reciclador;
import pe.edu.upc.entity.Recolector;
import pe.edu.upc.service.IRecolectorService;

@Named
@RequestScoped
public class RecolectorPedidoController implements Serializable{
private static final long serialVersionUID = 1L;
	

	@Inject
	private IRecolectorPedidoService rService;
	@Inject
	private IRecolectorService reService;

	private RecolectorPedido recolectorPedido;
	private Recolector recolector;
	private Reciclador reciclador;
	List<RecolectorPedido> listaRecolectorPedidos;
	List<Recolector> listaRecolectores;
	List<Reciclador> listaRecicladores;
	
	@PostConstruct
	public void init() {
		this.listaRecolectorPedidos = new ArrayList<RecolectorPedido>();
		this.listaRecolectores = new ArrayList<Recolector>();
		this.listaRecicladores = new ArrayList<Reciclador>();
		this.recolectorPedido= new RecolectorPedido();
		this.recolector =  new Recolector();
		this.reciclador = new Reciclador();
		this.listar();
		this.listaRecolectores();
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
	public void listaRecolectores() {
		listaRecolectores = reService.listar();
		
	}
	
	public void limpiarRecolectorPedido() {
		this.init();
	}
	
	public void eliminar(RecolectorPedido recolectorPedido) {
		rService.eliminar(recolectorPedido.getIdRecolectorPedido());
		this.listar();
	}

	public void findByReciclador() {
		if(reciclador.getNombre().isEmpty())
			this.listar();
		else
			listaRecicladores=this.rService.findByNameReciclador(this.getReciclador());
	}
	
	//set & get
	
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

	public Recolector getRecolector() {
		return recolector;
	}

	public void setRecolector(Recolector recolector) {
		this.recolector = recolector;
	}

	public Reciclador getReciclador() {
		return reciclador;
	}

	public void setReciclador(Reciclador reciclador) {
		this.reciclador = reciclador;
	}

	public List<Recolector> getListaRecolectores() {
		return listaRecolectores;
	}

	public void setListaRecolectores(List<Recolector> listaRecolectores) {
		this.listaRecolectores = listaRecolectores;
	}

	public List<Reciclador> getListaRecicladores() {
		return listaRecicladores;
	}

	public void setListaRecicladores(List<Reciclador> listaRecicladores) {
		this.listaRecicladores = listaRecicladores;
	}
	
}
