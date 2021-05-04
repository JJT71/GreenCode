package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ICategoriaDao;
import pe.edu.upc.dao.ICuentaDao;
import pe.edu.upc.entity.Categoria;
import pe.edu.upc.entity.Cuenta;

public class CuentaDaoImpl implements ICuentaDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "GreencodePU")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Cuenta cuenta) {
		em.persist(cuenta);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cuenta> listar() {
		List<Cuenta> lista= new ArrayList<Cuenta>();
		Query q=em.createQuery("Select c from Categoria c");
		lista=(List<Cuenta>) q.getResultList();
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idCuenta) {
		Cuenta c= new Cuenta();
		c= em.getReference(Cuenta.class, idCuenta);
		em.remove(c);	
	}

}
