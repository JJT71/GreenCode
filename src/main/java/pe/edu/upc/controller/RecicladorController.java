package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Reciclador;
import pe.edu.upc.service.IRecicladorService;

@Named
@RequestScoped
public class RecicladorController implements Serializable{
private static final long serialVersionUID = 1L;
	
	//@Inject
	//private IDocenteService mService;aqui seria para lo de distrito
	
	@Inject
	private IRecicladorService rService;
	
	private Reciclador reciclador;
	List<Reciclador> listaRecicladores;
	
	@PostConstruct
	public void init() {
		this.listaRecicladores = new ArrayList<Reciclador>();
		this.reciclador= new Reciclador();
		this.listar();
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
	
	public void listar() {
		listaRecicladores = rService.listar();
	}
	
	public void limpiarReciclador() {
		this.init();
	}
	
	public void eliminar(Reciclador reciclador) {
		rService.eliminar(reciclador.getIdReciclador());
		this.listar();
	}
	//GETTERS AND SETTERS
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
