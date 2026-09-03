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

	public Festival traerFestival(int idFestival) {
		return dao.traerFestival(idFestival);
	}

	public Festival traerFestivalConCostoYUnidades(int idFestival) {
		return dao.traerFestivalConCostoYUnidades(idFestival);
	}

	public Festival traerFestivalConCosto(int idFestival) {
		return dao.traerFestivalConCosto(idFestival);
	}

	public List<Festival> traerFestival() {
		return dao.traerFestival();
	}

	public List<Festival> traerPorNombre(String nombre) {
		return dao.traerPorNombre(nombre);
	}

	public List<Festival> traerPorTemporada(String temporada) {
		return dao.traerPorTemporada(temporada);
	}

	public List<Festival> traerVigentesEn(LocalDate fecha) {
		return dao.traerVigentesEn(fecha);
	}

	public List<Festival> traerPorCosto(int idCosto) {
		return dao.traerPorCosto(idCosto);
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
