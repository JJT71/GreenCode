package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Cuenta;

public interface ICuentaService {
	public void insertar(Cuenta cuenta);
	public List<Cuenta> listar();
	public void eliminar(int idCuenta);

}
