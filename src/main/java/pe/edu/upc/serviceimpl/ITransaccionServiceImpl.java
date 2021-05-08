package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.ITransaccionDao;
import pe.edu.upc.entity.Transaccion;
import pe.edu.upc.service.ITransaccionService;

public class ITransaccionServiceImpl implements ITransaccionService, Serializable {


	private static final long serialVersionUID = 1L;

	@Inject
	private ITransaccionDao tD; 
	
	@Override
	public void insertar(Transaccion transaccion) {
		tD.insertar(transaccion);
		
	}

	@Override
	public List<Transaccion> listar() {
		return tD.listar();
	}

	@Override
	public void eliminar(int idTransaccion) {
		tD.eliminar(idTransaccion);
		
	}

}
