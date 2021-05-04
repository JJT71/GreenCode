package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IRecolectorDao;
import pe.edu.upc.entity.Recolector;

public class RecolectorDaoImpl implements IRecolectorDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "GreencodePU")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Recolector recolector) {
		em.persist(recolector);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recolector> listar() {
		List<Recolector> lista= new ArrayList<Recolector>();
		Query q=em.createQuery("Select r from Recolector r");
		lista=(List<Recolector>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idRecolector) {
		Recolector r= new Recolector();
		r= em.getReference(Recolector.class, idRecolector);
		em.remove(r);
	}

}
