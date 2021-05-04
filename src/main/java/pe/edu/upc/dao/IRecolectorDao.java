package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Recolector;

public interface IRecolectorDao {

	public void insertar(Recolector recolector);
	public List<Recolector> listar();
	public void eliminar(int idRecolector);
}
