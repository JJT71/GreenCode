package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.IResiduoDao;
import pe.edu.upc.entity.Residuo;
import pe.edu.upc.service.IResiduoService;

public class IResiduoServiceImpl implements IResiduoService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IResiduoDao rD; 
	
	@Override
	public void insertar(Residuo residuo) {
		rD.insertar(residuo);
		
	}

	@Override
	public List<Residuo> listar() {
		return rD.listar();
	}

	@Override
	public void eliminar(int idResiduo) {
		rD.eliminar(idResiduo);
		
	}

}
