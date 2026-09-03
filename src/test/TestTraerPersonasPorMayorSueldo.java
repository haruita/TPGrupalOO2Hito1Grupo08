package test;

import java.util.List;

import datos.Persona;
import negocio.PersonaABM;

public class TestTraerPersonasPorMayorSueldo {

	public static void main(String[] args) {

		PersonaABM abmPersona = new PersonaABM();

		List<Persona> personas = abmPersona.traerOrdenadosPorSueldo();

		System.out.println("Personas ordenadas de mayor a menor sueldo:");
		for (Persona persona : personas) {
			System.out.printf("%s - Sueldo: %.2f%n", persona, persona.calcularSueldo());
		}
	}
}
