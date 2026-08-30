package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PersonaDao;
import datos.Cajero;
import datos.Cocinero;
import datos.Persona;

public class PersonaABM {

	PersonaDao dao = new PersonaDao();

	public Persona traer(int idPersona) {
		Persona p = dao.traer(idPersona);
		return p;
	}

	public Persona traerPorDni(long dni) {
		Persona p = dao.traerPorDni(dni);
		return p;
	}

	public int agregarCocinero(String nombre, String apellido, long dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, double sueldoBase, String especialidad, String categoria, double plusCategoria)
			throws Exception {
		validarDniDisponible(dni);
		Cocinero c = new Cocinero(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase, especialidad,
				categoria, plusCategoria);
		return dao.agregar(c);
	}

	public int agregarCajero(String nombre, String apellido, long dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, double sueldoBase, String turno, double bonoPorAntiguedad) throws Exception {
		validarDniDisponible(dni);
		Cajero c = new Cajero(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase, turno,
				bonoPorAntiguedad);
		return dao.agregar(c);
	}

	public void modificar(Persona p) {
		dao.actualizar(p);
	}

	public void eliminar(int idPersona) {
		Persona p = dao.traer(idPersona);
		dao.eliminar(p);
	}

	public List<Persona> traerPorRangoDeNacimiento(LocalDate desde, LocalDate hasta) {
		return dao.traerPorRangoDeNacimiento(desde, hasta);
	}

	public List<Persona> traerOrdenadosPorSueldo() {
		return dao.traerOrdenadosPorSueldo();
	}

	private void validarDniDisponible(long dni) throws Exception {
		if (dao.traerPorDni(dni) != null)
			throw new Exception("Ya existe una persona registrada con el DNI " + dni);
	}
}
