package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Costo;

public class CostoDao {
	private static Session session;
	private Transaction tx;

	private static CostoDao dao = null;

	protected CostoDao() {
	};

	public static CostoDao getInstancia() {
		if (dao == null) {
			dao = new CostoDao();
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

	public int agregar(Costo objeto) {
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

	public void actualizar(Costo objeto) {
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

	public void eliminar(Costo objeto) {
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

	public Costo traerCosto(int idCosto) {
		Costo objeto = null;
		try {
			iniciaOperacion();
			objeto = (Costo) session.get(Costo.class, idCosto);
		} finally {
			session.close();
		}
		return objeto;
	}

	
	public Costo traerCostoConFestivales(int idCosto) {
		Costo objeto = null;
		try {
			iniciaOperacion();
			String hQL = "from Costo c left join fetch c.festivales where c.idCosto = :idCosto";
			objeto = session.createQuery(hQL, Costo.class).setParameter("idCosto", idCosto).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public List<Costo> traerCosto() throws HibernateException {
		List<Costo> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Costo c order by c.idCosto asc", Costo.class).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Costo> traerPorSuperficieMayorA(double valor) {
		List<Costo> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Costo c where c.porSuperficie > :valor order by c.porSuperficie asc";
			lista = session.createQuery(hQL, Costo.class).setParameter("valor", valor).list();
		} finally {
			session.close();
		}
		return lista;
	}
}
