package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.UnidadDeVenta;

public class UnidadDeVentaDao {

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

	public int agregar(UnidadDeVenta objeto) {
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

	public UnidadDeVenta traer(int idUnidadDeVenta) {
		UnidadDeVenta objeto = null;

		try {
			iniciaOperacion();
			objeto = (UnidadDeVenta) session.get(UnidadDeVenta.class, idUnidadDeVenta);

		} finally {
			session.close();
		}

		return objeto;
	}

	public UnidadDeVenta traerPorCodigoUnico(String codigoUnico) {
		UnidadDeVenta objeto = null;

		try {
			iniciaOperacion();

			objeto = (UnidadDeVenta) session.createQuery(
					"from UnidadDeVenta where codigoUnico = :codigoUnico")
					.setParameter("codigoUnico", codigoUnico)
					.uniqueResult();

		} finally {
			session.close();
		}

		return objeto;
	}

	public List<UnidadDeVenta> traerTodas() {
		List<UnidadDeVenta> lista = null;

		try {
			iniciaOperacion();

			lista = session.createQuery(
					"from UnidadDeVenta",
					UnidadDeVenta.class)
					.list();

		} finally {
			session.close();
		}

		return lista;
	}

	public void actualizar(UnidadDeVenta objeto) {
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

	public void eliminar(UnidadDeVenta objeto) {
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
	
	public List<FoodTruck> traerFoodTrucksConConexionElectrica() {
		List<FoodTruck> lista = null;

		try {
			iniciaOperacion();

			lista = session.createQuery(
					"from FoodTruck f "
					+ "where f.conexionElectrica = true "
					+ "order by f.nombreComercial",
					FoodTruck.class)
					.list();

		} finally {
			session.close();
		}

		return lista;
	}

	public List<FoodTruck> traerFoodTrucksPorSuperficieYConexion(double superficieMinima) {
		List<FoodTruck> lista = null;

		try {
			iniciaOperacion();

			lista = session.createQuery(
					"from FoodTruck f "
					+ "where f.superficie >= :superficieMinima "
					+ "and f.conexionElectrica = true "
					+ "order by f.superficie desc",
					FoodTruck.class)
					.setParameter("superficieMinima", superficieMinima)
					.list();

		} finally {
			session.close();
		}

		return lista;
	}
	
	public List<PuestoDesarmable> traerPuestosPorCarpasYTiempo(int cantidadMinimaCarpas) {
		List<PuestoDesarmable> lista = null;

		try {
			iniciaOperacion();

			lista = session.createQuery(
					"from PuestoDesarmable p "
					+ "where p.cantCarpas >= :cantidadMinimaCarpas "
					+ "order by p.tiempoDeArmado asc, p.cantCarpas desc",
					PuestoDesarmable.class)
					.setParameter("cantidadMinimaCarpas", cantidadMinimaCarpas)
					.list();

		} finally {
			session.close();
		}

		return lista;
	}
}