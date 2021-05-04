package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Residuo;

public interface IResiduoDao {
	public void insertar(Residuo residuo);
	public List<Residuo> listar();
	public void eliminar(int idResiduo);
}
