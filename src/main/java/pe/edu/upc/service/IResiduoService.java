package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Residuo;

public interface IResiduoService {
	public void insertar(Residuo residuo);
	public List<Residuo> listar();
	public void eliminar(int idResiduo);
}
