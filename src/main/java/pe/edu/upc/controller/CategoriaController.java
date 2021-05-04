package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Categoria;
import pe.edu.upc.service.ICategoriaService;

@Named
@RequestScoped
public class CategoriaController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//Lilyyyyyyyyyyyyyyyyy
	@Inject
	private ICategoriaService mService;
	
	private Categoria categoria;
	List<Categoria> listaCategorias;
	
	@PostConstruct
	public void init() {
		this.categoria = new Categoria();
		this.listaCategorias = new ArrayList<Categoria>();
		this.listar();
	}

	public String nuevaCategoria() { //para crear una vista de categoria
		this.setCategoria(new Categoria());
		return "categoria.xhtml";
	}
	
	public void insertar() {
		mService.insertar(categoria);
		limpiarCategoria();
		this.listar();
	}
	
	public void listar() {
		listaCategorias = mService.listar();
	}
	public void limpiarCategoria() {
		this.init();
	}
	public void eliminar(Categoria categoria) {
		mService.eliminar(categoria.getIdCategoria());
		this.listar();
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}
	
	
	
	
	
}
