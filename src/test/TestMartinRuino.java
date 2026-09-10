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

	public static void main(String[] args) {
		PlatoABM platoABM = PlatoABM.getInstancia();
		PedidoABM pedidoABM = PedidoABM.getInstancia();
		ItemPlatoABM itemPlatoABM = ItemPlatoABM.getInstancia();

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
