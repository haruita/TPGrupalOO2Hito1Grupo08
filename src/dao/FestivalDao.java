package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Festival;

public class FestivalDao {
	private static Session session;
	private Transaction tx;

	private static FestivalDao dao = null;

	protected FestivalDao() {
	};

	public static FestivalDao getInstancia() {
		if (dao == null) {
			dao = new FestivalDao();
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

	public int agregar(Festival objeto) {
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

	public void actualizar(Festival objeto) {
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

	public void eliminar(Festival objeto) {
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

	// Basica: traer por id (soporte, no es CU)
	public Festival traerFestival(int idFestival) {
		Festival objeto = null;
		try {
			iniciaOperacion();
			objeto = (Festival) session.get(Festival.class, idFestival);
		} finally {
			session.close();
		}
		return objeto;
	}

	// Basica: traer todos (soporte, no es CU)
	public List<Festival> traerFestival() throws HibernateException {
		List<Festival> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Festival f left join fetch f.costo order by f.fechaInicio asc", Festival.class).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Festival> traerVigentesEn(LocalDate fecha) {
		List<Festival> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Festival f left join fetch f.costo where f.fechaInicio <= :fecha and f.fechaFin >= :fecha order by f.fechaInicio asc";
			lista = session.createQuery(hQL, Festival.class).setParameter("fecha", fecha).list();
		} finally {
			session.close();
		}
		return lista;
	}

	// Festivales solapados con un rango por años
	public List<Festival> traerEntreFechas(LocalDate inicio, LocalDate fin) {
		List<Festival> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Festival f left join fetch f.costo where f.fechaInicio <= :fin and f.fechaFin >= :inicio order by f.fechaInicio asc";
			lista = session.createQuery(hQL, Festival.class).setParameter("inicio", inicio)
					.setParameter("fin", fin).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public Festival traerFestivalConUnidades(int idFestival) {
		Festival objeto = null;
		try {
			iniciaOperacion();
			String hQL = "from Festival f left join fetch f.costo left join fetch f.unidades where f.idFestival = :id";
			objeto = session.createQuery(hQL, Festival.class).setParameter("id", idFestival).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
}
