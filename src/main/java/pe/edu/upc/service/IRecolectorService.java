package pe.edu.upc.service;

import java.util.List;


import pe.edu.upc.entity.Recolector;

public interface IRecolectorService {
	public void insertar(Recolector recolector);
	public List<Recolector> listar();
	public void eliminar(int idRecolector);
}
