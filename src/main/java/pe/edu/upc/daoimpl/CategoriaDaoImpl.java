package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ICategoriaDao;
import pe.edu.upc.entity.Categoria;

public class CategoriaDaoImpl implements ICategoriaDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "GreencodePU")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Categoria categoria) {
		em.persist(categoria);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> listar() {
		List<Categoria> lista= new ArrayList<Categoria>();
		Query q=em.createQuery("Select c from Categoria c");
		lista=(List<Categoria>) q.getResultList();
		return lista;
	}

	@Override
	public void eliminar(int idCategoria) {
		Categoria c= new Categoria();
		c= em.getReference(Categoria.class, idCategoria);
		em.remove(c);	
	}

}
