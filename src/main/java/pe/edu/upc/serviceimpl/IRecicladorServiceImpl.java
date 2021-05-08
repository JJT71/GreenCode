package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.IRecicladorDao;
import pe.edu.upc.entity.Reciclador;
import pe.edu.upc.service.IRecicladorService;

public class IRecicladorServiceImpl implements IRecicladorService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IRecicladorDao mD; 
	
	@Override
	public void insertar(Reciclador reciclador) {
		mD.insertar(reciclador);
	}

	@Override
	public List<Reciclador> listar() {
		
		return mD.listar();
	}

	@Override//
	public void eliminar(int idReciclador) {
		mD.eliminar(idReciclador);	
	}

	@Override
	public List<Reciclador> finByReciclador(Reciclador r) {
		return mD.findByNameReciclador(r);	
	}

}
