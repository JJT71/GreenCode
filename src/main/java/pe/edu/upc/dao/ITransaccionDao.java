package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Categoria;
import pe.edu.upc.entity.Transaccion;

public interface ITransaccionDao {
	public void insertar(Transaccion transaccion);
	public List<Transaccion> listar();
	public void eliminar(int idTransaccion);
}
