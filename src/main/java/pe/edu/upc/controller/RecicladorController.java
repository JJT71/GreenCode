package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Distrito;
import pe.edu.upc.entity.Reciclador;
import pe.edu.upc.service.IDistritoService;
import pe.edu.upc.service.IRecicladorService;

@Named
@RequestScoped
public class RecicladorController implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Inject
	private IDistritoService dService;
	
	@Inject
	private IRecicladorService rService;
	
	private Distrito distrito;
	private Reciclador reciclador;
	
	List<Distrito> listaDistritos;
	List<Reciclador> listaRecicladores;
	
	@PostConstruct
	public void init() {
		distrito= new Distrito();
		reciclador= new Reciclador();
		
		listaDistritos= new ArrayList<Distrito>();
		listaRecicladores = new ArrayList<Reciclador>();
		
		this.listar();
		this.listReciclador();
	}
	
	public String nuevoReciclador() {
		this.setReciclador(new Reciclador());
		return "reciclador.xhtml";
	}
	
	public void insertar() {
		rService.insertar(reciclador);
		limpiarReciclador();
		this.listar();
	}
	
	public void listReciclador() {
		listaRecicladores = rService.listar();
	}
	
	public void listar() {
		listaDistritos = dService.listar();
	}
	
	public void limpiarReciclador() {
		this.init();
	}
	
	public void eliminar(Reciclador reciclador) {
		rService.eliminar(reciclador.getIdReciclador());
		this.listar();
	}
	//GETTERS AND SETTERS


	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public Reciclador getReciclador() {
		return reciclador;
	}

	public void setReciclador(Reciclador reciclador) {
		this.reciclador = reciclador;
	}

	public List<Distrito> getListaDistritos() {
		return listaDistritos;
	}

	public void setListaDistritos(List<Distrito> listaDistritos) {
		this.listaDistritos = listaDistritos;
	}

	public List<Reciclador> getListaRecicladores() {
		return listaRecicladores;
	}

	public void setListaRecicladores(List<Reciclador> listaRecicladores) {
		this.listaRecicladores = listaRecicladores;
	}
	
	

	
}
