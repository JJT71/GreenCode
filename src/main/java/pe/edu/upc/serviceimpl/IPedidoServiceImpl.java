package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import pe.edu.upc.dao.IPedidoDao;
import pe.edu.upc.entity.Pedido;
import pe.edu.upc.service.IPedidoService;

public class IPedidoServiceImpl implements IPedidoService,Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IPedidoDao mD; 
	
	@Override
	public void insertar(Pedido pedido) {
		mD.insertar(pedido);
	}

	@Override
	public List<Pedido> listar() {
		
		return mD.listar();
	}

	@Override
	public void eliminar(int idPedido) {
		mD.eliminar(idPedido);	
	}

}
