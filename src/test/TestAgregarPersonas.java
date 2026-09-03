package test;

import java.time.LocalDate;

import negocio.PersonaABM;

public class TestAgregarPersonas {

	public static void main(String[] args) {

		PersonaABM abm = new PersonaABM();

		try {
			int ultimoIdPersona;

			ultimoIdPersona = abm.agregarCocinero("Ana", "Gomez", 40111222,
					LocalDate.of(1995, 5, 10), LocalDate.of(2020, 3, 1), 500000,
					"Pasteleria", "Senior", 100000);
			System.out.printf("Id cocinero: %d%n", ultimoIdPersona);

			ultimoIdPersona = abm.agregarCajero("Juan", "Perez", 42333444,
					LocalDate.of(1998, 8, 20), LocalDate.of(2022, 6, 15), 450000,
					"Tarde", 20000);
			System.out.printf("Id cajero: %d%n", ultimoIdPersona);

			ultimoIdPersona = abm.agregarCocinero("Maria", "Lopez", 38777666,
					LocalDate.of(1992, 11, 3), LocalDate.of(2018, 4, 10), 550000,
					"Parrilla", "Jefe", 150000);
			System.out.printf("Id cocinero: %d%n", ultimoIdPersona);

			ultimoIdPersona = abm.agregarCajero("Lucas", "Fernandez", 44555666,
					LocalDate.of(2001, 2, 14), LocalDate.of(2023, 1, 20), 420000,
					"Manana", 15000);
			System.out.printf("Id cajero: %d%n", ultimoIdPersona);

			ultimoIdPersona = abm.agregarCocinero("Sofia", "Martinez", 41666777,
					LocalDate.of(1997, 7, 25), LocalDate.of(2021, 9, 5), 480000,
					"Comida italiana", "Junior", 60000);
			System.out.printf("Id cocinero: %d%n", ultimoIdPersona);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
