package test;

import java.time.LocalDate;
import java.util.List;

import datos.Persona;
import negocio.PersonaABM;

public class TestLeandroEnrique {

	public static void main(String[] args) {

		PersonaABM abmPersona = new PersonaABM();

		List<Persona> personasPorSueldo = abmPersona.traerOrdenadosPorSueldo();

		System.out.println("Personas ordenadas de mayor a menor sueldo:");
		for (Persona persona : personasPorSueldo) {
			System.out.printf("%s - Sueldo: %.2f%n", persona, persona.calcularSueldo());
		}
		
		LocalDate desde = LocalDate.of(1990, 1, 1);
		LocalDate hasta = LocalDate.of(2000, 12, 31);

		List<Persona> personasNacidasEntre = abmPersona.traerPorRangoDeNacimiento(desde, hasta);

		System.out.println("Personas nacidas dentro del rango:");
		for (Persona persona : personasNacidasEntre) {
			System.out.println(persona);
		}
	}
}
