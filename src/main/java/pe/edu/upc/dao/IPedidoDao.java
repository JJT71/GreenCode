package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Pedido;

public interface IPedidoDao {
	public void insertar(Pedido pedido);
	public List<Pedido> listar();
	public void eliminar(int idPedido);
}
