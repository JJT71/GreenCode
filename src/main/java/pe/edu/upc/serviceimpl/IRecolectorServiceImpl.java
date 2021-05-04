package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.IRecolectorDao;
import pe.edu.upc.entity.Recolector;
import pe.edu.upc.service.IRecolectorService;

public class IRecolectorServiceImpl implements IRecolectorService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IRecolectorDao mD; 
	
	@Override
	public void insertar(Recolector recolector) {
		mD.insertar(recolector);
	}

	@Override
	public List<Recolector> listar() {
		
		return mD.listar();
	}

	@Override
	public void eliminar(int idRecolector) {
		mD.eliminar(idRecolector);	
	}


}
