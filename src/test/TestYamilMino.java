package test;

import java.time.LocalDate;
import java.util.List;

import datos.Costo;
import datos.Festival;
import negocio.CostoABM;
import negocio.FestivalABM;
import util.TablaASCII;

public class TestYamilMino {

	public static void main(String[] args) {
		CostoABM costoABM = CostoABM.getInstancia();
		FestivalABM festivalABM = FestivalABM.getInstancia();

		try {
			// Datos de prueba (solo para poder consultar)
			int idCosto1 = costoABM.agregar(1500.0, 800.0, 500.0);
			int idCosto2 = costoABM.agregar(2500.0, 1200.0, 900.0);

			Costo c1 = costoABM.traerCosto(idCosto1);
			Costo c2 = costoABM.traerCosto(idCosto2);

			int idF1 = festivalABM.agregar("Epicentro Gourmet Verano", "Verano 2026", LocalDate.of(2026, 1, 10),
					LocalDate.of(2026, 1, 15), c1);
			int idF2 = festivalABM.agregar("Epicentro Gourmet Invierno", "Invierno 2026", LocalDate.of(2026, 7, 5),
					LocalDate.of(2026, 7, 10), c2);
			System.out.println("Creados costos " + idCosto1 + ", " + idCosto2 + " y festivales " + idF1 + ", " + idF2);

			// Basicas (soporte)
			System.out.println("\n--- Basica: traerFestival(" + idF1 + ") ---");
			TablaASCII.imprimirFestivales(java.util.Collections.singletonList(festivalABM.traerFestival(idF1)));
			System.out.println("\n--- Basica: traerFestival() ---");
			TablaASCII.imprimirFestivales(festivalABM.traerFestival());
			System.out.println("\n--- Basica: traerCosto() ---");
			TablaASCII.imprimirCostos(costoABM.traerCosto());

			// Vigentes en una fecha
			System.out.println("\n--- CU1: traerVigentesEn(2026-01-12) ---");
			List<Festival> vigentes = festivalABM.traerVigentesEn(LocalDate.of(2026, 1, 12));
			TablaASCII.imprimirFestivales(vigentes);

			// Solapados con un rango
			System.out.println("\n--- CU2: traerEntreFechas(2026-01-01, 2026-12-31) ---");
			List<Festival> rango = festivalABM.traerEntreFechas(LocalDate.of(2026, 1, 1),
					LocalDate.of(2026, 12, 31));
			TablaASCII.imprimirFestivales(rango);

			// Festival con unidades
			System.out.println("\n--- CU3: traerFestivalConUnidades(" + idF1 + ") ---");
			Festival conUnidades = festivalABM.traerFestivalConUnidades(idF1);
			TablaASCII.imprimirFestivalConUnidades(conUnidades);

			// Costo con festivales
			System.out.println("\n--- CU4: traerCostoConFestivales(" + idCosto1 + ") ---");
			Costo conFest = costoABM.traerCostoConFestivales(idCosto1);
			TablaASCII.imprimirCostoConFestivales(conFest);

			// CU5: esquemas vigentes en una fecha
			System.out.println("\n--- CU5: traerEsquemaVigenteEn(2026-01-12) ---");
			List<Costo> esquemas = costoABM.traerEsquemaVigenteEn(LocalDate.of(2026, 1, 12));
			TablaASCII.imprimirCostos(esquemas);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
