package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.ICategoriaDao;
import pe.edu.upc.dao.ICuentaDao;
import pe.edu.upc.dao.ITransaccionDao;
import pe.edu.upc.entity.Categoria;
import pe.edu.upc.entity.Cuenta;
import pe.edu.upc.entity.Transaccion;
import pe.edu.upc.service.ICategoriaService;
import pe.edu.upc.service.ICuentaService;
import pe.edu.upc.service.ITransaccionService;

public class ITransaccionServiceImpl implements ITransaccionService, Serializable {


	private static final long serialVersionUID = 1L;

	@Inject
	private ITransaccionDao mD; 
	
	@Override
	public void insertar(Transaccion transaccion) {
		mD.insertar(transaccion);
		
	}

	@Override
	public List<Transaccion> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idTransaccion) {
		mD.eliminar(idTransaccion);
		
	}

}
