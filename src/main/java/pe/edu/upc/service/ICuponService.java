package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Cupon;

public interface ICuponService {
	public void insertar(Cupon cupon);
	public List<Cupon> listar();
	public void eliminar(int idCupon);
}
