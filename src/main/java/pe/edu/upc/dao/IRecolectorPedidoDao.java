package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.RecolectorPedido;
import pe.edu.upc.entity.Reciclador;

public interface IRecolectorPedidoDao {

	public void insertar(RecolectorPedido recolectorPedido);
	public List<RecolectorPedido> listar();
	public void eliminar(int idRecolectorPedido);
	public List<Reciclador> findByNameReciclador(Reciclador r);
}
