package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPedidoDao;
import pe.edu.upc.entity.Pedido;

public class PedidoDaoImpl implements IPedidoDao, Serializable{

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "GreencodePU")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Pedido pedido) {
		em.persist(pedido);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> listar() {
		List<Pedido> lista= new ArrayList<Pedido>();
		Query q=em.createQuery("Select p from Pedido p");
		lista=(List<Pedido>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idPedido) {
		Pedido p= new Pedido();
		p= em.getReference(Pedido.class, idPedido);
		em.remove(p);
	}

}
