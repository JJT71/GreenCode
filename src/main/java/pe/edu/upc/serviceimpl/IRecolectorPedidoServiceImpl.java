package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.IRecolectorPedidoDao;
import pe.edu.upc.dao.IRecicladorDao;
import pe.edu.upc.entity.RecolectorPedido;
import pe.edu.upc.entity.Reciclador;
import pe.edu.upc.service.IRecolectorPedidoService;


public class IRecolectorPedidoServiceImpl implements IRecolectorPedidoService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IRecolectorPedidoDao mD; 
	
	@Override
	public void insertar(RecolectorPedido recolectorPedido) {
		mD.insertar(recolectorPedido);
	}

	@Override
	public List<RecolectorPedido> listar() {
		
		return mD.listar();
	}

	@Override
	public void eliminar(int idRecolectorPedido) {
		mD.eliminar(idRecolectorPedido);	
	}

	@Override
	public List<Reciclador> findByNameReciclador(Reciclador r) {
		return mD.findByNameReciclador(r);
	}

}
