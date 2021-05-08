package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;


import pe.edu.upc.dao.ICuentaDao;
import pe.edu.upc.entity.Cuenta;
import pe.edu.upc.service.ICuentaService;

public class ICuentaServiceImpl implements ICuentaService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICuentaDao cD; 
	
	@Override
	public void insertar(Cuenta cuenta) {
		cD.insertar(cuenta);	
	}

	@Override
	public List<Cuenta> listar() {
		return cD.listar();
	}

	@Override
	public void eliminar(int idCuenta) {
		cD.eliminar(idCuenta);
		
	}

}
