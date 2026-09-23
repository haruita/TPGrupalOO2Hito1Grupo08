package test;

import util.TablaASCII;

import java.time.LocalDate;
import java.util.List;

import datos.Pedido;
import datos.UnidadDeVenta;
import negocio.PedidoABM;
import negocio.UnidadDeVentaABM;

public class TestMartinRuino {

	public static void main(String[] args) {

		PedidoABM pedidoABM = PedidoABM.getInstancia();
		UnidadDeVentaABM unidadABM = new UnidadDeVentaABM();

		UnidadDeVenta u1 = unidadABM.traerPorCodigoUnico("FT001");
		try {
			List<Pedido> pedidos1 = pedidoABM.traerPedidosEntreFechas(u1, LocalDate.of(2026, 1, 10), LocalDate.of(2026, 1, 13));

			System.out.println("\n== Pedidos de FT001 (El Buen Sabor) entre 10/01/2026 y 13/01/2026 ==");
			TablaASCII.imprimirPedidos(pedidos1);

			List<Pedido> pedidos2 = pedidoABM.traerPedidosEntreFechas(u1, LocalDate.of(2026, 1, 10), LocalDate.of(2026, 1, 15));

			System.out.println("\n== Pedidos de FT001 (El Buen Sabor) entre 10/01/2026 y 15/01/2026 ==");
			TablaASCII.imprimirPedidos(pedidos2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
