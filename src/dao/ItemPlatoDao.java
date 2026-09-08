package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.ItemPlato;
import datos.Pedido;
import datos.Plato;

public class ItemPlatoDao {
	private static Session session;
	private Transaction tx;


	private static ItemPlatoDao dao = null;

	protected ItemPlatoDao() { };

	public static ItemPlatoDao getInstancia() {
		if (dao == null) {
			dao = new ItemPlatoDao();
		}
		return dao;
	}

	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	// Lo trae sin el Pedido ni el Plato
	public ItemPlato traer(int idObjeto) {
		ItemPlato objeto = null;
		try {
			iniciaOperacion();
			objeto = (ItemPlato) session.get(ItemPlato.class, idObjeto);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public ItemPlato traerConPlato(int idItemPlato) {
		ItemPlato obj = null;
		try {
			iniciaOperacion();
			String hQL = "from ItemPlato item inner join fetch item.plato p where item.idItemPlato=:idItemPlato";
			obj = (ItemPlato) session.createQuery(hQL).setParameter("idItemPlato", idItemPlato).uniqueResult();
		} finally {
			session.close();
		}
		return obj;
	}

	public ItemPlato traerConPedido(int idItemPlato) {
        ItemPlato obj = null;
        try {
            iniciaOperacion();
            String hQL = "from ItemPlato item inner join fetch item.pedido pe where item.idItemPlato = :idItemPlato";
            obj = (ItemPlato) session.createQuery(hQL)
                         .setParameter("idItemPlato", idItemPlato)
                         .uniqueResult();
        } finally {
            session.close();
        }
        return obj;
    }

	// Lo trae con el Pedido y el Plato.
	public ItemPlato traerConPlatoYPedido(int idItemPlato) {
        ItemPlato obj = null;
        try {
            iniciaOperacion();
            String hQL = "from ItemPlato item inner join fetch item.plato p inner join fetch item.pedido pe where item.idItemPlato = :idItemPlato";
            obj = session.createQuery(hQL, ItemPlato.class)
                         .setParameter("idItemPlato", idItemPlato)
                         .uniqueResult();
        } finally {
            session.close();
        }
        return obj;
    }
	
	
	
    public List<ItemPlato> traer(Pedido pedido) {
        List<ItemPlato> lista = null;
        try {
            iniciaOperacion();
            String hQL = "from ItemPlato item inner join fetch item.plato p inner join fetch item.pedido pe where pe.idPedido = :idPedido";
            lista = session.createQuery(hQL, ItemPlato.class)
                           .setParameter("idPedido", pedido.getIdPedido())
                           .getResultList();
        } finally {
            session.close();
        }
        return lista;
    }


	public int agregar(ItemPlato objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();

		}
		return id;
	}

	public void actualizar(ItemPlato objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	public void eliminar(ItemPlato objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
}
