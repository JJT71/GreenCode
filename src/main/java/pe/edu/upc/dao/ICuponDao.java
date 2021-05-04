package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Cupon;

public interface ICuponDao {
	public void insertar(Cupon cupon);
	public List<Cupon> listar();
	public void eliminar(int idCupon);
}
