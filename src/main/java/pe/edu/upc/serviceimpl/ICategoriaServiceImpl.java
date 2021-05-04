package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.ICategoriaDao;
import pe.edu.upc.entity.Categoria;
import pe.edu.upc.service.ICategoriaService;

public class ICategoriaServiceImpl implements ICategoriaService, Serializable {


	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoriaDao mD; 
	
	@Override
	public void insertar(Categoria categoria) {
		mD.insertar(categoria);
		
	}

	@Override
	public List<Categoria> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idCategoria) {
		mD.eliminar(idCategoria);
		
	}

}
