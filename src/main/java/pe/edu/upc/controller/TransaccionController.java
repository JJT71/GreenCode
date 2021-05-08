package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Cuenta;

import pe.edu.upc.entity.Transaccion;
import pe.edu.upc.service.ICuentaService;
import pe.edu.upc.service.ITransaccionService;

@Named
@RequestScoped
public class TransaccionController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITransaccionService tService;
	
	@Inject
	private ICuentaService cService;
	
	private Transaccion transaccion;
	private Cuenta cuenta;
	
	
	List<Transaccion> listaTransacciones;
	List<Cuenta> listaCuentas;
	
	
	
	@PostConstruct
	public void init() {
		transaccion= new Transaccion();
		cuenta= new Cuenta();
		
		listaTransacciones= new ArrayList<Transaccion>();
		listaCuentas= new ArrayList<Cuenta>();
		
		this.listTransaccion();
		this.listCuenta();
	}
	

	public String nuevaTransaccion() { 
		this.setTransaccion(new Transaccion());
		return "transaccion.xhtml";
	}
	
	public Transaccion getTransaccion() {
		return transaccion;
	}
	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}


	public void insertar() {
		tService.insertar(transaccion);
		limpiarTransaccion();
		this.listTransaccion();
		
	}
	
	public void listTransaccion() {
		listaTransacciones=tService.listar();		
	}
	
	public void listCuenta() {
		listaCuentas=cService.listar();
	}
	
	public void limpiarTransaccion() {
		this.init();
	}
	
	public void eliminar(Transaccion transaccion) {
		tService.eliminar(transaccion.getIdTransaccion());
		this.listTransaccion();
	}
	

	
	//GETTERS AND SETTERS


	public Cuenta getCuenta() {
		return cuenta;
	}


	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}


	public List<Cuenta> getListaCuentas() {
		return listaCuentas;
	}


	public void setListaCuentas(List<Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}


	public List<Transaccion> getListaTransacciones() {
		return listaTransacciones;
	}


	public void setListaTransacciones(List<Transaccion> listaTransacciones) {
		this.listaTransacciones = listaTransacciones;
	}
	

	
	
}
