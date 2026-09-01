package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Pedido;
import datos.UnidadDeVenta;

public class PedidoDao {
	private static Session session;
	private Transaction tx;

	private static PedidoDao dao = null;

	protected PedidoDao() {
	};

	public static PedidoDao getInstancia() {
		if (dao == null) {
			dao = new PedidoDao();
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

	public Pedido traerBasico(int idPedido) {
		Pedido objeto = null;
		try {
			iniciaOperacion();
			objeto = (Pedido) session.get(Pedido.class, idPedido);
		} finally {
			session.close();
		}
		return objeto;
	}

	public Pedido traerSinItemPlato(int idPedido) {
		Pedido obj = null;
		try {
			iniciaOperacion();
			//Lo uno solo a unidad, por lo tanto sin items
			String hQL = "from Pedido p left join fetch p.unidad u where p.idPedido = :idPedido";
			obj = session.createQuery(hQL, Pedido.class)
					.setParameter("idPedido", idPedido)
					.uniqueResult();
		} finally {
			session.close();
		}
		return obj;
	}
	
	public Pedido trearSinUnidadDeVenta(int idPedido) {
		Pedido obj = null;
		try {
			iniciaOperacion();
			//Lo uno solo a items, por lo tanto sin unidad
			String hQL = "from Pedido p left join fetch p.items u where p.idPedido = :idPedido";
			obj = session.createQuery(hQL, Pedido.class)
					.setParameter("idPedido", idPedido)
					.uniqueResult();
		} finally {
			session.close();
		}
		return obj;
	}
	
	public Pedido traer(int idPedido) {
		Pedido obj = null;
		try {
			iniciaOperacion();
			String hQL = "from Pedido p left join fetch p.unidad u left join fetch p.items i left join fetch i.plato where p.idPedido = :idPedido";
			obj = session.createQuery(hQL, Pedido.class).setParameter("idPedido", idPedido).uniqueResult();
		} finally {
			session.close();
		}
		return obj;
	}

	// Trae todos
	public List<Pedido> traer() throws HibernateException {
		List<Pedido> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Pedido p order by p.idPedido asc", Pedido.class).list();
		} finally {
			session.close();
		}
		return lista;
	}

	// Trae todos los que sean de la unidad de venta especificada
	public List<Pedido> traer(UnidadDeVenta unidad) {
		List<Pedido> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Pedido p left join fetch p.items i left join fetch i.plato where p.unidad.idUnidadDeVenta = :idUnidad";
			lista = session.createQuery(hQL, Pedido.class).setParameter("idUnidad", unidad.getIdUnidadDeVenta())
					.getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	// Trae todos los de la fecha especificada
	public List<Pedido> traer(LocalDate fecha) {
		List<Pedido> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Pedido p left join fetch p.items i left join fetch i.plato where p.fecha = :fecha";
			lista = session.createQuery(hQL, Pedido.class).setParameter("fecha", fecha).getResultList();
		} finally {
			session.close();
		}
		return lista;
	}

	
	
	
	
	public int agregar(Pedido objeto) {
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

	public void actualizar(Pedido objeto) {
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

	public void eliminar(Pedido objeto) {
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