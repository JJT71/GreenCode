package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


import pe.edu.upc.dao.ITransaccionDao;
import pe.edu.upc.entity.Transaccion;

public class TransaccionDaoImpl implements ITransaccionDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "GreencodePU")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Transaccion t) {
		em.persist(t);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaccion> listar() {
		List<Transaccion> lista= new ArrayList<Transaccion>();
		Query q=em.createQuery("Select t from Transaccion t");
		lista=(List<Transaccion>) q.getResultList();
		return lista;
	}
	
	@Transactional
	@Override
	public void eliminar(int idTransaccion) {
		Transaccion t= new Transaccion();
		t= em.getReference(Transaccion.class, idTransaccion);
		em.remove(t);	
	}

}
