package test;

import java.time.LocalDate;
import java.util.List;

import datos.Persona;
import negocio.PersonaABM;

public class TestTraerPersonasPorRangoDeEdad {

	public static void main(String[] args) {

		PersonaABM abmPersona = new PersonaABM();

		LocalDate desde = LocalDate.of(1990, 1, 1);
		LocalDate hasta = LocalDate.of(2000, 12, 31);

		List<Persona> personas = abmPersona.traerPorRangoDeNacimiento(desde, hasta);

		System.out.println("Personas nacidas dentro del rango:");
		for (Persona persona : personas) {
			System.out.println(persona);
		}
	}
}
