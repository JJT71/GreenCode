package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import pe.edu.upc.entity.Cupon;
import pe.edu.upc.service.ICuponService;

@Named
@RequestScoped
public class CuponController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICuponService cService;
	
	
	private Cupon cupon;
	
	List<Cupon> listaCupones;
	
	@PostConstruct
	public void init() {
		cupon = new Cupon();
		
		listaCupones= new ArrayList<Cupon>();
	
		this.listCupon();
		
	}
	
	public String nuevoCupon() {
		this.setCupon(new Cupon());
		return "residuo.xhtml";
	}
	
	public void insertar() {
		cService.insertar(cupon);
		limpiarCupon();
		this.listCupon();
	}
	
	public void listCupon() {
		listaCupones = cService.listar();
	}
	
	
	public void limpiarCupon() {
		this.init();
	}
	
	public void eliminar(Cupon cupon) {
		cService.eliminar(cupon.getIdCupon());
		this.listCupon();
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

	
}
