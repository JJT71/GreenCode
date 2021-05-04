package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Cuenta;
import pe.edu.upc.entity.Transaccion;

public interface ITransaccionService {
	public void insertar(Transaccion transaccion);
	public List<Transaccion> listar();
	public void eliminar(int idTransaccion);

}
