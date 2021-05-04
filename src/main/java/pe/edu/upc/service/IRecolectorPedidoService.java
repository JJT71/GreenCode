package pe.edu.upc.service;

import java.util.List;


import pe.edu.upc.entity.RecolectorPedido;

public interface IRecolectorPedidoService {
	public void insertar(RecolectorPedido recolectorPedido);
	public List<RecolectorPedido> listar();
	public void eliminar(int idRecolectorPedido);
}
