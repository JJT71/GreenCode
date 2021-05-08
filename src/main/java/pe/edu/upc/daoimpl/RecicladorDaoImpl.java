package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IRecicladorDao;
import pe.edu.upc.entity.Reciclador;

public class RecicladorDaoImpl implements IRecicladorDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "GreencodePU")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Reciclador reciclador) {
		em.persist(reciclador);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reciclador> listar() {
		List<Reciclador> lista= new ArrayList<Reciclador>();
		Query q=em.createQuery("Select r from Reciclador r");
		lista=(List<Reciclador>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idReciclador) {
		Reciclador r= new Reciclador();
		r= em.getReference(Reciclador.class, idReciclador);
		em.remove(r);
	}
	
	@SuppressWarnings("unchecked")//
	public List<Reciclador> findByNameReciclador(Reciclador r) {
		List<Reciclador> lista = new ArrayList<Reciclador>();
		try {
			Query q = em.createQuery("from Reciclador r where r.nombre like ?1");
			q.setParameter(1, "%" +r.getNombre() + "%");
			lista = (List<Reciclador>) q.getResultList();
		} catch (Exception e) {
			System.out.println("Error al buscar reciclador");
		}
		return lista;
	}

}
