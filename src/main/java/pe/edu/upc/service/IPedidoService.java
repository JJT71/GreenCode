package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Pedido;

public interface IPedidoService {

	public void insertar(Pedido pedido);
	public List<Pedido> listar();
	public void eliminar(int idPedido);
}
