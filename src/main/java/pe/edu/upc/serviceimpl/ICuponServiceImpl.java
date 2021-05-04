package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.ICuponDao;
import pe.edu.upc.entity.Cupon;
import pe.edu.upc.service.ICuponService;

public class ICuponServiceImpl implements ICuponService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ICuponDao cD; 
	
	@Override
	public void insertar(Cupon cupon) {
		cD.insertar(cupon);
		
	}

	@Override
	public List<Cupon> listar() {
		return cD.listar();
	}

	@Override
	public void eliminar(int idCupon) {
		cD.eliminar(idCupon);
		
	}

}
