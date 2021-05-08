package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Distrito;
import pe.edu.upc.entity.Recolector;
import pe.edu.upc.service.IDistritoService;
import pe.edu.upc.service.IRecolectorService;

@Named
@RequestScoped
public class RecolectorController implements Serializable{
private static final long serialVersionUID = 1L;
	
    @Inject
    private IDistritoService dService;

	@Inject
	private IRecolectorService rService;
	
	private Distrito distrito;
	private Recolector recolector;
	
	List<Distrito> listaDistritos;
	List<Recolector> listaRecolectores;
	
	@PostConstruct
	public void init() {
		this.distrito= new Distrito();
		this.listaDistritos= new ArrayList<Distrito>();
		this.listaRecolectores = new ArrayList<Recolector>();
		this.recolector= new Recolector();
		this.listar();
		this.listarD();
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
	
	
	public void listarD() {
		listaDistritos = dService.listar();
	}
	
	public void limpiarRecolector() {
		this.init();
	}
	
	public void eliminar(Recolector recolector) {
		rService.eliminar(recolector.getIdRecolector());
		this.listar();
	}

	//GET & SET 
	
	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	
	public Recolector getRecolector() {
		return recolector;
	}

	public void setRecolector(Recolector recolector) {
		this.recolector = recolector;
	}
	
	public List<Distrito> getListaDistritos() {
		return listaDistritos;
	}

	public void setListaDistritos(List<Distrito> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}

	public List<Recolector> getListaRecolectores() {
		return listaRecolectores;
	}

	public void setListaRecolectores(List<Recolector> listaRecolectores) {
		this.listaRecolectores = listaRecolectores;
	}
	
}
