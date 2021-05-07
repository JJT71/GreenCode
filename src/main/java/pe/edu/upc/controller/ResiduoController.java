package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Categoria;
import pe.edu.upc.entity.Reciclador;
import pe.edu.upc.entity.Residuo;
import pe.edu.upc.service.ICategoriaService;
import pe.edu.upc.service.IRecicladorService;
import pe.edu.upc.service.IResiduoService;

@Named
@RequestScoped
public class ResiduoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoriaService cService;
	
	@Inject
	private IRecicladorService rService;
	
	@Inject
	private IResiduoService reService;
	
	private Reciclador reciclador;
	private Categoria categoria;
	private Residuo residuo;
	
	List<Reciclador> listaRecicladores;
	List<Categoria> listaCategorias;
	List<Residuo> listaResiduos;
	
	@PostConstruct
	public void init() {
		reciclador = new Reciclador();
		categoria= new Categoria();
		residuo = new Residuo();
		
		listaRecicladores= new ArrayList<Reciclador>();
		listaCategorias = new ArrayList<Categoria>();
		listaResiduos = new ArrayList<Residuo>();
		
		this.listCategoria();
		this.listResiduo();
		this.listReciclador();
		
	}
	
	public String nuevoResiduo() {
		this.setResiduo(new Residuo());
		return "residuo.xhtml";
	}
	
	public void insertar() {
		reService.insertar(residuo);
		limpiarResiduo();
		this.listResiduo();
	}
	
	public void listCategoria() {
		listaCategorias = cService.listar();
	}
	
	public void listResiduo() {
		listaResiduos = reService.listar();
	}
	
	public void listReciclador() {
		listaRecicladores = rService.listar();
	}	
	
	public void limpiarResiduo() {
		this.init();
	}
	
	public void eliminar(Residuo residuo) {
		reService.eliminar(residuo.getIdResiduo());
		this.listResiduo();
	}


	

	public void setReService(IResiduoService reService) {
		this.reService = reService;
	}

	public Reciclador getReciclador() {
		return reciclador;
	}

	public void setReciclador(Reciclador reciclador) {
		this.reciclador = reciclador;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Residuo getResiduo() {
		return residuo;
	}

	public void setResiduo(Residuo residuo) {
		this.residuo = residuo;
	}

	public List<Reciclador> getListaRecicladores() {
		return listaRecicladores;
	}

	public void setListaRecicladores(List<Reciclador> listaRecicladores) {
		this.listaRecicladores = listaRecicladores;
	}

	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public List<Residuo> getListaResiduos() {
		return listaResiduos;
	}

	public void setListaResiduos(List<Residuo> listaResiduos) {
		this.listaResiduos = listaResiduos;
	}
}
