package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.IDistritoDao;
import pe.edu.upc.entity.Distrito;
import pe.edu.upc.service.IDistritoService;

public class IDistritoServiceImpl implements IDistritoService, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDistritoDao dD; 
	
	@Override
	public void insertar(Distrito distrito) {
		dD.insertar(distrito);
		
	}

	@Override
	public List<Distrito> listar() {
		return dD.listar();
	}

	@Override
	public void eliminar(int idDistrito) {
		dD.eliminar(idDistrito);
		
	}

	

}
