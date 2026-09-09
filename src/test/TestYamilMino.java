package test;

import java.time.LocalDate;
import java.util.List;

import datos.Costo;
import datos.Festival;
import negocio.CostoABM;
import negocio.FestivalABM;

public class TestFestivalCosto {

	public static void main(String[] args) {
		CostoABM costoABM = CostoABM.getInstancia();
		FestivalABM festivalABM = FestivalABM.getInstancia();

		try {
			int idCosto1 = costoABM.agregar(1500.0, 800.0, 500.0);
			int idCosto2 = costoABM.agregar(2500.0, 1200.0, 900.0);
			System.out.println("Costos agregados: " + idCosto1 + ", " + idCosto2);

			Costo c1 = costoABM.traerCosto(idCosto1);
			Costo c2 = costoABM.traerCosto(idCosto2);

			int idF1 = festivalABM.agregar("Epicentro Gourmet Verano", "Verano 2026", LocalDate.of(2026, 1, 10),
					LocalDate.of(2026, 1, 15), c1);
			int idF2 = festivalABM.agregar("Epicentro Gourmet Invierno", "Invierno 2026", LocalDate.of(2026, 7, 5),
					LocalDate.of(2026, 7, 10), c2);
			System.out.println("Festivales agregados: " + idF1 + ", " + idF2);

			System.out.println("\n[CU Costo] traerCosto(" + idCosto1 + "): " + costoABM.traerCosto(idCosto1));

			System.out.println("\n[CU Costo] traerCosto() todos:");
			List<Costo> costos = costoABM.traerCosto();
			for (Costo c : costos) {
				System.out.println(c);
			}

			System.out.println("\n[CU Costo] traerPorSuperficieMayorA(2000):");
			for (Costo c : costoABM.traerPorSuperficieMayorA(2000)) {
				System.out.println(c);
			}

			System.out.println("\n[CU Costo] traerCostoConFestivales(" + idCosto1 + "):");
			Costo conFest = costoABM.traerCostoConFestivales(idCosto1);
			System.out.println(conFest + " -> festivales: " + conFest.getFestivales());

			Festival basico = festivalABM.traerFestival(idF1);
			System.out.println("\n[CU Festival] traerFestival(" + idF1 + "): id=" + basico.getIdFestival()
					+ ", nombre=" + basico.getNombre() + ", temporada=" + basico.getTemporada());

			System.out.println("\n[CU Festival] traerFestivalConCostoYUnidades(" + idF1 + "): "
					+ festivalABM.traerFestivalConCostoYUnidades(idF1));

			System.out.println("\n[CU Festival] traerFestival() todos:");
			List<Festival> festivales = festivalABM.traerFestival();
			for (Festival f : festivales) {
				System.out.println(f);
			}

			System.out.println("\n[CU Festival] traerPorTemporada('Verano 2026'):");
			for (Festival f : festivalABM.traerPorTemporada("Verano 2026")) {
				System.out.println(f);
			}

			System.out.println("\n[CU Festival] traerVigentesEn(2026-01-12):");
			for (Festival f : festivalABM.traerVigentesEn(LocalDate.of(2026, 1, 12))) {
				System.out.println(f);
			}

			System.out.println("\n[CU Festival] traerPorCosto(" + idCosto2 + "):");
			for (Festival f : festivalABM.traerPorCosto(idCosto2)) {
				System.out.println(f);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
