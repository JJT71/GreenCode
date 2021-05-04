package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.RecolectorPedido;

public interface IRecolectorPedidoDao {

	public void insertar(RecolectorPedido recolectorPedido);
	public List<RecolectorPedido> listar();
	public void eliminar(int idRecolectorPedido);
}
