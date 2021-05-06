package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import pe.edu.upc.entity.Cupon;
import pe.edu.upc.entity.Reciclador;
import pe.edu.upc.service.ICuponService;
import pe.edu.upc.service.IRecicladorService;

@Named
@RequestScoped
public class CuponController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICuponService cService;
	@Inject
	private IRecicladorService reService;
	
	private Cupon cupon;
	private Reciclador reciclador;
	
	List<Cupon> listaCupones;
	List<Reciclador> listaRecicladores;

	@PostConstruct
	public void init() {
		reciclador=new Reciclador();
		cupon = new Cupon();
		listaCupones= new ArrayList<Cupon>();
		listaRecicladores=new ArrayList<Reciclador>();
		this.listCupon();
		this.listReciclador();
	}
	
	
	public String nuevoCupon() {
		this.setCupon(new Cupon());
		return "cupon.xhtml";
	}
	
	public void insertar() {
		cService.insertar(cupon);
		limpiarCupon();
		this.listCupon();
	}
	
	public void listCupon() {
		listaCupones = cService.listar();
	}
	public void listReciclador() {
		listaRecicladores = reService.listar();
	}
	
	public void limpiarCupon() {
		this.init();
	}
	
	public void eliminar(Cupon cupon) {
		cService.eliminar(cupon.getIdCupon());
		this.listCupon();
	}

	public List<Reciclador> getListaRecicladores() {
		return listaRecicladores;
	}


	public void setListaRecicladores(List<Reciclador> listaRecicladores) {
		this.listaRecicladores = listaRecicladores;
	}


	public Cupon getCupon() {
		return cupon;
	}

	public void setCupon(Cupon cupon) {
		this.cupon = cupon;
	}

	public List<Cupon> getListaCupones() {
		return listaCupones;
	}

	public void setListaCupones(List<Cupon> listaCupones) {
		this.listaCupones = listaCupones;
	}


	public Reciclador getReciclador() {
		return reciclador;
	}


	public void setReciclador(Reciclador reciclador) {
		this.reciclador = reciclador;
	}

	
}
