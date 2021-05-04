package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Cuenta;

public interface ICuentaDao {
	public void insertar(Cuenta cuenta);
	public List<Cuenta>listar();
	public void eliminar(int idCuenta);

}
