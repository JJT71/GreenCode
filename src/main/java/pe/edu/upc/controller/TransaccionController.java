package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import pe.edu.upc.entity.Transaccion;
import pe.edu.upc.service.ITransaccionService;

@Named
@RequestScoped
public class TransaccionController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITransaccionService mService;
	
	private Transaccion transaccion;
	List<Transaccion> listaTransacciones;
	
	@PostConstruct
	public void init() {
		this.transaccion = new Transaccion();
		this.listaTransacciones = new ArrayList<Transaccion>();
		this.listar();
	}

	public String nuevaTransaccion() { //para crear una vista de cuenta
		this.setTransaccion(new Transaccion());
		return "transaccion.xhtml";
	}
	
	public void insertar() {
		mService.insertar(transaccion);
		limpiarTransaccion();
		this.listar();
	}
	
	public void listar() {
		listaTransacciones = mService.listar();
	}
	
	public void limpiarTransaccion() {
		this.init();
	}
	
	public void eliminar(Transaccion transaccion) {
		mService.eliminar(transaccion.getIdTransaccion());
		this.listar();
	}

	

	
	//GETTERS AND SETTERS
	public Transaccion getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}

	public List<Transaccion> getListaTransacciones() {
		return listaTransacciones;
	}

	public void setListaTransacciones(List<Transaccion> listaTransacciones) {
		this.listaTransacciones = listaTransacciones;
	}
	
	
}
