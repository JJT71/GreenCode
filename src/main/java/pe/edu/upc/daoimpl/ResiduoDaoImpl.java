package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IResiduoDao;
import pe.edu.upc.entity.Residuo;

public class ResiduoDaoImpl implements IResiduoDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "GreencodePU")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Residuo residuo) {
		em.persist(residuo);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Residuo> listar() {
		List<Residuo> lista= new ArrayList<Residuo>();
		Query q=em.createQuery("Select r from Residuo r");
		lista=(List<Residuo>) q.getResultList();
		return lista;
	}

	@Override
	public void eliminar(int idResiduo) {
		Residuo r= new Residuo();
		r= em.getReference(Residuo.class, idResiduo);
		em.remove(r);
		
	}

}
