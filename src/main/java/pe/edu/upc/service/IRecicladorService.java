package pe.edu.upc.service;

import java.util.List;


import pe.edu.upc.entity.Reciclador;

public interface IRecicladorService {
	public void insertar(Reciclador reciclador);
	public List<Reciclador> listar();
	public void eliminar(int idReciclador);
	public List<Reciclador> finByReciclador (Reciclador r);
}
