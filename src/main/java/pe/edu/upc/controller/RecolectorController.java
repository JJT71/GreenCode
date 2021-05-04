package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Recolector;
import pe.edu.upc.service.IRecolectorService;

@Named
@RequestScoped
public class RecolectorController implements Serializable{
private static final long serialVersionUID = 1L;
	

	@Inject
	private IRecolectorService rService;
	
	private Recolector recolector;
	List<Recolector> listaRecolectores;
	
	@PostConstruct
	public void init() {
		this.listaRecolectores = new ArrayList<Recolector>();
		this.recolector= new Recolector();
		this.listar();
	}
	
	public String nuevoRecolector() {
		this.setRecolector(new Recolector());
		return "recolector.xhtml";
	}
	
	public void insertar() {
		rService.insertar(recolector);
		limpiarRecolector();
		this.listar();
	}
	
	public void listar() {
		listaRecolectores = rService.listar();
	}
	
	public void limpiarRecolector() {
		this.init();
	}
	
	public void eliminar(Recolector recolector) {
		rService.eliminar(recolector.getIdRecolector());
		this.listar();
	}

	public Recolector getRecolector() {
		return recolector;
	}

	public void setRecolector(Recolector recolector) {
		this.recolector = recolector;
	}

	public List<Recolector> getListaRecolectores() {
		return listaRecolectores;
	}

	public void setListaRecolectores(List<Recolector> listaRecolectores) {
		this.listaRecolectores = listaRecolectores;
	}
	
}
