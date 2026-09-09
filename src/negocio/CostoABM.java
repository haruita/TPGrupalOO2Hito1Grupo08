package negocio;

import java.time.LocalDate;
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

	// Basicas (soporte)
	public Costo traerCosto(int idCosto) {
		return dao.traerCosto(idCosto);
	}

	public List<Costo> traerCosto() {
		return dao.traerCosto();
	}

	// CU4: costo con festivales (Uno a Muchos)
	public Costo traerCostoConFestivales(int idCosto) {
		return dao.traerCostoConFestivales(idCosto);
	}

	// CU5: esquemas vigentes en una fecha
	public List<Costo> traerEsquemaVigenteEn(LocalDate fecha) {
		return dao.traerEsquemaVigenteEn(fecha);
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
