package negocio;

import java.util.List;

import dao.CostoDao;
import datos.Costo;

public class CostoABM {
	private static CostoABM abm = null;
	private CostoDao dao = CostoDao.getInstancia();

	private CostoABM() {
	};

	public static CostoABM getInstancia() {
		if (abm == null) {
			abm = new CostoABM();
		}
		return abm;
	}

	// CU: consulta basica por id
	public Costo traerCosto(int idCosto) {
		return dao.traerCosto(idCosto);
	}

	// CU: consulta de costo con sus festivales (relacion Uno a Muchos)
	public Costo traerCostoConFestivales(int idCosto) {
		return dao.traerCostoConFestivales(idCosto);
	}

	// CU: consulta de todos los costos
	public List<Costo> traerCosto() {
		return dao.traerCosto();
	}

	// CU: consulta de costos con porSuperficie mayor al valor dado
	public List<Costo> traerPorSuperficieMayorA(double valor) {
		return dao.traerPorSuperficieMayorA(valor);
	}

	public int agregar(double porSuperficie, double porMontaje, double porElectricidad) {
		Costo c = new Costo(porSuperficie, porMontaje, porElectricidad);
		return dao.agregar(c);
	}

	public void modificar(Costo c) {
		dao.actualizar(c);
	}

	public void eliminar(int idCosto) {
		Costo c = dao.traerCosto(idCosto);
		if (c != null) {
			dao.eliminar(c);
		}
	}
}
