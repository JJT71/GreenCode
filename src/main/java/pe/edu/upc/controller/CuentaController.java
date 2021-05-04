package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Categoria;
import pe.edu.upc.entity.Cuenta;
import pe.edu.upc.service.ICategoriaService;
import pe.edu.upc.service.ICuentaService;

@Named
@RequestScoped
public class CuentaController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICuentaService mService;
	
	private Cuenta cuenta;
	List<Cuenta> listaCuentas;
	
	@PostConstruct
	public void init() {
		this.cuenta = new Cuenta();
		this.listaCuentas = new ArrayList<Cuenta>();
		this.listar();
	}

	public String nuevaCuenta() { //para crear una vista de cuenta
		this.setCuenta(new Cuenta());
		return "cuenta.xhtml";
	}
	
	public void insertar() {
		mService.insertar(cuenta);
		limpiarCuenta();
		this.listar();
	}
	
	public void listar() {
		listaCuentas = mService.listar();
	}
	
	public void limpiarCuenta() {
		this.init();
	}
	
	public void eliminar(Cuenta cuenta) {
		mService.eliminar(cuenta.getIdCuenta());
		this.listar();
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
	//GETTERS AND SETTERS
	
	
	
	
	
}
