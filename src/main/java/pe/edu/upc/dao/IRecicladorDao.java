package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Reciclador;

public interface IRecicladorDao {

	public void insertar(Reciclador reciclador);
	public List<Reciclador> listar();
	public void eliminar(int idReciclador);
}
