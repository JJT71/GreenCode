package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ICuponDao;
import pe.edu.upc.entity.Cupon;

public class CuponDaoImpl implements ICuponDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "GreencodePU")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Cupon cupon) {
		em.persist(cupon);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cupon> listar() {
		List<Cupon> lista= new ArrayList<Cupon>();
		Query q=em.createQuery("Select c from Cupon c");
		lista=(List<Cupon>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idCupon) {
		Cupon c= new Cupon();
		c= em.getReference(Cupon.class, idCupon);
		em.remove(c);
		
	}

}
