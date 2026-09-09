package test;

import negocio.PlatoABM;
import util.TablaASCII;

import java.time.LocalDate;
import java.util.List;

import datos.Pedido;
import datos.Plato;
import negocio.ItemPlatoABM;
import negocio.PedidoABM;


public class TestMartinRuino {

	private static void agregar(PlatoABM platoABM,PedidoABM pedidoABM,ItemPlatoABM itemPlatoABM) {

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

		int idPed1 = pedidoABM.agregar(LocalDate.of(2026, 1, 11));
		Pedido ped1 = pedidoABM.traerPedido(idPed1);
		itemPlatoABM.agregar(p1, 2, ped1);
		itemPlatoABM.agregar(p4, 4, ped1);

		int idPed2 = pedidoABM.agregar(LocalDate.of(2026, 1, 12));
		Pedido ped2 = pedidoABM.traerPedido(idPed2);
		itemPlatoABM.agregar(p2, 1, ped2);
		itemPlatoABM.agregar(p3, 1, ped2); 

		int idPed3 = pedidoABM.agregar(LocalDate.of(2026, 1, 15));
		Pedido ped3 = pedidoABM.traerPedido(idPed3);
		itemPlatoABM.agregar(p5, 2, ped3);

		int idPed4 = pedidoABM.agregar(LocalDate.of(2026, 7, 6));
		Pedido ped4 = pedidoABM.traerPedido(idPed4);
		itemPlatoABM.agregar(p1, 3, ped4);
		itemPlatoABM.agregar(p2, 2, ped4);
		
		int idPed5 = pedidoABM.agregar(LocalDate.of(2026, 7, 9));
		Pedido ped5 = pedidoABM.traerPedido(idPed5);
		itemPlatoABM.agregar(p3, 2, ped5);
		itemPlatoABM.agregar(p4, 6, ped5);
	}
	
	
	public static void main(String[] args) {
		PlatoABM platoABM = PlatoABM.getInstancia();
		PedidoABM pedidoABM = PedidoABM.getInstancia();
		ItemPlatoABM itemPlatoABM = ItemPlatoABM.getInstancia();

		// agregar(platoABM,pedidoABM,itemPlatoABM);
		
		List<Pedido> pedidos1 = pedidoABM.traerPedidosEntreFechas(LocalDate.of(2026, 1, 10), LocalDate.of(2026, 1, 15));
		System.out.println("\n== Entre Fecha 10/01/2026 - 15/01/2026 ==");
		TablaASCII.imprimirPedidos(pedidos1);
		System.out.println("Este Ejemplo tuvo que haber dado Pedido ID = 1, 2 y 3\n\n\n");

		List<Pedido> pedidos2 = pedidoABM.traerPedidosEntreFechas(LocalDate.of(2026, 7, 1), LocalDate.of(2026, 7, 10));
		System.out.println("\n== Entre Fecha 10/07/2026 - 10/07/2026 ==");
		TablaASCII.imprimirPedidos(pedidos2);
		System.out.println("Este Ejemplo tuvo que haber dado ID = 4 y 5.\n");
		
		
		System.out.println("Test de Martin Ruino");
	}

}
