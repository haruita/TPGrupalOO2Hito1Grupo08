package test;

import java.time.LocalDate;

import datos.Pedido;
import datos.Plato;
import datos.UnidadDeVenta;
import negocio.ItemPlatoABM;
import negocio.PedidoABM;
import negocio.PersonaABM;
import negocio.PlatoABM;
import negocio.UnidadDeVentaABM;

public class TestInserciones {

	public static void main(String[] args) {

		PersonaABM abm = new PersonaABM();

		PlatoABM platoABM = PlatoABM.getInstancia();
		PedidoABM pedidoABM = PedidoABM.getInstancia();
		ItemPlatoABM itemPlatoABM = ItemPlatoABM.getInstancia();
		UnidadDeVentaABM unidadABM = new UnidadDeVentaABM();

		// =============================================================== Insertar Personas
		try {
			int ultimoIdPersona;

			ultimoIdPersona = abm.agregarCocinero("Ana", "Gomez", 40111222, LocalDate.of(1995, 5, 10),
					LocalDate.of(2020, 3, 1), 500000, "Pasteleria", "Senior", 100000);
			System.out.printf("Id cocinero: %d%n", ultimoIdPersona);

			ultimoIdPersona = abm.agregarCajero("Juan", "Perez", 42333444, LocalDate.of(1998, 8, 20),
					LocalDate.of(2022, 6, 15), 450000, "Tarde", 20000);
			System.out.printf("Id cajero: %d%n", ultimoIdPersona);

			ultimoIdPersona = abm.agregarCocinero("Maria", "Lopez", 38777666, LocalDate.of(1992, 11, 3),
					LocalDate.of(2018, 4, 10), 550000, "Parrilla", "Jefe", 150000);
			System.out.printf("Id cocinero: %d%n", ultimoIdPersona);

			ultimoIdPersona = abm.agregarCajero("Lucas", "Fernandez", 44555666, LocalDate.of(2001, 2, 14),
					LocalDate.of(2023, 1, 20), 420000, "Manana", 15000);
			System.out.printf("Id cajero: %d%n", ultimoIdPersona);

			ultimoIdPersona = abm.agregarCocinero("Sofia", "Martinez", 41666777, LocalDate.of(1997, 7, 25),
					LocalDate.of(2021, 9, 5), 480000, "Comida italiana", "Junior", 60000);
			System.out.printf("Id cocinero: %d%n", ultimoIdPersona);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			// =============================================================== Insertar Unidades de venta
			int idU1 = unidadABM.agregarFoodTruck("El Buen Sabor", "FT001", 20.0, null, "AA123BB", true);
			int idU2 = unidadABM.agregarFoodTruck("La Esquina", "FT002", 15.0, null, "AB456CD", false );
			int idU3 = unidadABM.agregarFoodTruck("Sabores Urbanos",	"FT003", 30.0, null, "AC789EF", true);
			int idU4 = unidadABM.agregarPuestoDesarmable("Puesto Criollo", "PD001", 10.0, null, 3, 20);
			int idU5 = unidadABM.agregarPuestoDesarmable("Delicias del Festival", "PD002", 25.0, null, 5, 30);

			UnidadDeVenta u1 = unidadABM.traer(idU1);
			UnidadDeVenta u2 = unidadABM.traer(idU2);
			UnidadDeVenta u3 = unidadABM.traer(idU3);
			UnidadDeVenta u4 = unidadABM.traer(idU4);
			UnidadDeVenta u5 = unidadABM.traer(idU5);
			
			// =============================================================== Insertar platos, items y Pedidos

			int idP1 = platoABM.agregar("Tacos", 1500.0, 700.0);
			int idP2 = platoABM.agregar("Hamburguesa", 2200.0, 1000.0);
			int idP3 = platoABM.agregar("Pizza", 3000.0, 1200.0);
			int idP4 = platoABM.agregar("Empanada", 800.0, 350.0);
			int idP5 = platoABM.agregar("Sopa", 3500.0, 1800.0);

			Plato p1 = platoABM.traerPlato(idP1);
			Plato p2 = platoABM.traerPlato(idP2);
			Plato p3 = platoABM.traerPlato(idP3);
			Plato p4 = platoABM.traerPlato(idP4);
			Plato p5 = platoABM.traerPlato(idP5);

			int idPed1 = pedidoABM.agregar(u1,LocalDate.of(2026, 1, 11));
			Pedido ped1 = pedidoABM.traerPedido(idPed1);
			itemPlatoABM.agregar(p1, 2, ped1);
			itemPlatoABM.agregar(p4, 4, ped1);

			int idPed2 = pedidoABM.agregar(u2,LocalDate.of(2026, 1, 12));
			Pedido ped2 = pedidoABM.traerPedido(idPed2);
			itemPlatoABM.agregar(p2, 1, ped2);
			itemPlatoABM.agregar(p3, 1, ped2);

			int idPed3 = pedidoABM.agregar(u1,LocalDate.of(2026, 1, 15));
			Pedido ped3 = pedidoABM.traerPedido(idPed3);
			itemPlatoABM.agregar(p5, 3, ped3);

			int idPed4 = pedidoABM.agregar(u3,LocalDate.of(2026, 7, 6));
			Pedido ped4 = pedidoABM.traerPedido(idPed4);
			itemPlatoABM.agregar(p1, 3, ped4);
			itemPlatoABM.agregar(p2, 2, ped4);

			int idPed5 = pedidoABM.agregar(u4,LocalDate.of(2026, 7, 9));
			Pedido ped5 = pedidoABM.traerPedido(idPed5);
			itemPlatoABM.agregar(p3, 2, ped5);
			itemPlatoABM.agregar(p4, 6, ped5);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
