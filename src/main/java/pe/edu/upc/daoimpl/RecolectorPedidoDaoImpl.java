package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IRecolectorPedidoDao;
import pe.edu.upc.entity.RecolectorPedido;

public class RecolectorPedidoDaoImpl implements IRecolectorPedidoDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "GreencodePU")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(RecolectorPedido recolectorPedido) {
		em.persist(recolectorPedido);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RecolectorPedido> listar() {
		List<RecolectorPedido> lista= new ArrayList<RecolectorPedido>();
		Query q=em.createQuery("Select r from RecolectorPedido r");
		lista=(List<RecolectorPedido>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idRecolectorPedido) {
		RecolectorPedido r= new RecolectorPedido();
		r= em.getReference(RecolectorPedido.class, idRecolectorPedido);
		em.remove(r);
	}

}
