package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Persona;

public class PersonaDao {

	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(Persona objeto) {
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

	public Persona traer(int idPersona) {
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.get(Persona.class, idPersona);
		} finally {
			session.close();
		}
		return objeto;
	}

	public Persona traerPorDni(long dni) {
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.createQuery("from Persona where dni = :dni")
					.setParameter("dni", dni)
					.uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public List<Persona> traerPorRangoDeNacimiento(LocalDate desde, LocalDate hasta) {
		List<Persona> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery(
					"from Persona p "
					+ "where p.fechaNacimiento between :desde and :hasta "
					+ "order by p.fechaNacimiento",
					Persona.class)
					.setParameter("desde", desde)
					.setParameter("hasta", hasta)
					.list();
		} finally {
			session.close();
		}
		return lista;
	}

	public List<Persona> traerOrdenadosPorSueldo() {
		List<Persona> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery(
					"select p from Persona p "
					+ "  left join Cocinero co on co.idPersona = p.idPersona "
					+ "  left join Cajero ca on ca.idPersona = p.idPersona "
					+ "order by p.sueldoBase + coalesce("
					+ "    co.plusCategoria, "
					+ "    function('TIMESTAMPDIFF', YEAR, p.fechaIngreso, current_date) * ca.bonoPorAntiguedad, "
					+ "    0.0) desc",
					Persona.class)
					.list();
		} finally {
			session.close();
		}
		return lista;
	}

	public void actualizar(Persona objeto) {
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

	public void eliminar(Persona objeto) {
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
