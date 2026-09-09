package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.FestivalDao;
import datos.Costo;
import datos.Festival;

public class FestivalABM {
	private static FestivalABM abm = null;
	private FestivalDao dao = FestivalDao.getInstancia();

	private FestivalABM() {
	};

	public static FestivalABM getInstancia() {
		if (abm == null) {
			abm = new FestivalABM();
		}
		return abm;
	}

	// Basicas (soporte)
	public Festival traerFestival(int idFestival) {
		return dao.traerFestival(idFestival);
	}

	public List<Festival> traerFestival() {
		return dao.traerFestival();
	}

	// CU1: vigentes en una fecha
	public List<Festival> traerVigentesEn(LocalDate fecha) {
		return dao.traerVigentesEn(fecha);
	}

	// CU2: solapados con un rango
	public List<Festival> traerEntreFechas(LocalDate inicio, LocalDate fin) {
		return dao.traerEntreFechas(inicio, fin);
	}

	// CU3: festival con unidades (Herencia FoodTruck / PuestoDesarmable)
	public Festival traerFestivalConUnidades(int idFestival) {
		return dao.traerFestivalConUnidades(idFestival);
	}

	public int agregar(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin, Costo costo)
			throws Exception {
		if (fechaFin.isBefore(fechaInicio)) {
			throw new Exception("La fecha de fin no puede ser anterior a la fecha de inicio");
		}
		Festival f = new Festival(nombre, temporada, fechaInicio, fechaFin, costo);
		return dao.agregar(f);
	}

	public void modificar(Festival f) {
		dao.actualizar(f);
	}

	public void eliminar(int idFestival) {
		Festival f = dao.traerFestival(idFestival);
		if (f != null) {
			dao.eliminar(f);
		}
	}
}
