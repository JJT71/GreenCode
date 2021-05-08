package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Cuenta;
import pe.edu.upc.entity.Recolector;
import pe.edu.upc.service.ICuentaService;
import pe.edu.upc.service.IRecolectorService;

@Named
@RequestScoped
public class CuentaController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICuentaService cService;
	
	@Inject
	private IRecolectorService rService;
	
	private Cuenta cuenta;
	private Recolector recolector;
	
	List<Cuenta> listaCuentas;
	List<Recolector> listaRecolectores;
	
	@PostConstruct
	public void init() {
		
		cuenta = new Cuenta();
		recolector = new Recolector();
		
		listaCuentas= new ArrayList<Cuenta>();
		listaRecolectores= new ArrayList<Recolector>();
		
		this.listCuenta();
		this.listRecolector();
		
		
	}

	public String nuevaCuenta() { 
		this.setCuenta(new Cuenta());
		return "cuenta.xhtml";
	}
	
	public void insertar() {
		cService.insertar(cuenta);
		limpiarCuenta();
		this.listCuenta();
	}
	
	public void listCuenta() {
		listaCuentas = cService.listar();
	}
	
	public void listRecolector() {
		listaRecolectores = rService.listar();
	}
	
	public void limpiarCuenta() {
		this.init();
	}
	
	public void eliminar(Cuenta cuenta) {
		cService.eliminar(cuenta.getIdCuenta());
		this.listCuenta();
	}

	
	//GETTERS AND SETTERS
		
	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Recolector getRecolector() {
		return recolector;
	}

	public void setRecolector(Recolector recolector) {
		this.recolector = recolector;
	}

	public List<Cuenta> getListaCuentas() {
		return listaCuentas;
	}

	public void setListaCuentas(List<Cuenta> listaCuentas) {
		this.listaCuentas = listaCuentas;
	}

	public List<Recolector> getListaRecolectores() {
		return listaRecolectores;
	}

	public void setListaRecolectores(List<Recolector> listaRecolectores) {
		this.listaRecolectores = listaRecolectores;
	}

	
	
	
}
