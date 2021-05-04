package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.ICategoriaDao;
import pe.edu.upc.dao.ICuentaDao;
import pe.edu.upc.entity.Categoria;
import pe.edu.upc.entity.Cuenta;
import pe.edu.upc.service.ICategoriaService;
import pe.edu.upc.service.ICuentaService;

public class ICuentaServiceImpl implements ICuentaService, Serializable {


	private static final long serialVersionUID = 1L;

	@Inject
	private ICuentaDao mD; 
	
	@Override
	public void insertar(Cuenta cuenta) {
		mD.insertar(cuenta);
		
	}

	@Override
	public List<Cuenta> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idCuenta) {
		mD.eliminar(idCuenta);
		
	}

}
