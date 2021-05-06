package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import pe.edu.upc.entity.Distrito;
import pe.edu.upc.service.IDistritoService;

@Named
@RequestScoped
public class DistritoController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IDistritoService dService;
	
	
	private Distrito distrito;
	
	List<Distrito> listaDistritos;
	
	@PostConstruct
	public void init() {
		distrito = new Distrito();
		listaDistritos = new ArrayList<Distrito>();
		this.listDistrito();
	}
	
	public String nuevoDistrito() {
		this.setDistrito(new Distrito());
		return "distrito.xhtml";
	}
	
	public void insertar() {
		dService.insertar(distrito);
		limpiarDistrito();
		this.listDistrito();
	}
	
	public void listDistrito() {
		listaDistritos = dService.listar();
	}
	
	public void limpiarDistrito() {
		this.init();
	}
	
	public void eliminar(Distrito distrito) {
		dService.eliminar(distrito.getIdDistrito());
		this.listDistrito();
	}
//-------

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public List<Distrito> getListaDistritos() {
		return listaDistritos;
	}

	public void setListaDistritos(List<Distrito> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}
	//-------
	

}
