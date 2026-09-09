package util;

import java.util.ArrayList;
import java.util.List;

import datos.Costo;
import datos.Festival;
import datos.FoodTruck;
import datos.PuestoDesarmable;
import datos.UnidadDeVenta;

public class TablaASCII {

	private static String borde(int[] anchos) {
		StringBuilder sb = new StringBuilder("+");
		for (int a : anchos) {
			for (int i = 0; i < a + 2; i++)
				sb.append("-");
			sb.append("+");
		}
		return sb.toString();
	}

	private static String fila(String[] celdas, int[] anchos) {
		StringBuilder sb = new StringBuilder("|");
		for (int i = 0; i < celdas.length; i++) {
			String c = celdas[i] == null ? "" : celdas[i];
			if (c.length() > anchos[i])
				c = c.substring(0, anchos[i]);
			sb.append(" ").append(String.format("%-" + anchos[i] + "s", c)).append(" |");
		}
		return sb.toString();
	}

	private static int[] anchos(String[] cabecera, List<String[]> filas) {
		int[] w = new int[cabecera.length];
		for (int i = 0; i < cabecera.length; i++)
			w[i] = cabecera[i].length();
		for (String[] f : filas) {
			for (int i = 0; i < f.length; i++) {
				int len = f[i] == null ? 0 : f[i].length();
				if (len > w[i])
					w[i] = len;
			}
		}
		// Tope para no deformar la terminal
		for (int i = 0; i < w.length; i++)
			if (w[i] > 45)
				w[i] = 45;
		return w;
	}

	private static void imprimir(String titulo, String[] cabecera, List<String[]> filas) {
		System.out.println("\n== " + titulo + " (" + filas.size() + " filas) ==");
		if (filas.isEmpty()) {
			System.out.println("(sin resultados)");
			return;
		}
		int[] w = anchos(cabecera, filas);
		String b = borde(w);
		System.out.println(b);
		System.out.println(fila(cabecera, w));
		System.out.println(b);
		for (String[] f : filas)
			System.out.println(fila(f, w));
		System.out.println(b);
	}
	
	// Yamil Miño: Festival y Costos

	private static String[] filaFestival(Festival f) {
		return new String[] { String.valueOf(f.getIdFestival()), f.getNombre(), f.getTemporada(),
				String.valueOf(f.getFechaInicio()), String.valueOf(f.getFechaFin()),
				f.getCosto() == null ? "-" : String.valueOf(f.getCosto().getIdCosto()) };
	}

	private static String[] filaCosto(Costo c) {
		return new String[] { String.valueOf(c.getIdCosto()), String.valueOf(c.getPorSuperficie()),
				String.valueOf(c.getPorMontaje()), String.valueOf(c.getPorElectricidad()) };
	}

	public static void imprimirFestivales(List<Festival> lista) {
		List<String[]> filas = new ArrayList<>();
		for (Festival f : lista)
			filas.add(filaFestival(f));
		imprimir("FESTIVALES", new String[] { "ID", "NOMBRE", "TEMPORADA", "INICIO", "FIN", "ID COSTO" }, filas);
	}

	public static void imprimirCostos(List<Costo> lista) {
		List<String[]> filas = new ArrayList<>();
		for (Costo c : lista)
			filas.add(filaCosto(c));
		imprimir("COSTOS", new String[] { "ID", "POR SUPERFICIE", "POR MONTAJE", "POR ELECTRICIDAD" }, filas);
	}

	public static void imprimirCostoConFestivales(Costo c) {
		if (c == null) {
			System.out.println("(costo inexistente)");
			return;
		}
		imprimirCostos(java.util.Collections.singletonList(c));
		List<String[]> filas = new ArrayList<>();
		if (c.getFestivales() != null) {
			for (Festival f : c.getFestivales())
				filas.add(filaFestival(f));
		}
		imprimir("FESTIVALES DEL COSTO " + c.getIdCosto(), new String[] { "ID", "NOMBRE", "TEMPORADA", "INICIO",
				"FIN", "ID COSTO" }, filas);
	}

	public static void imprimirFestivalConUnidades(Festival f) {
		if (f == null) {
			System.out.println("(festival inexistente)");
			return;
		}
		imprimirFestivales(java.util.Collections.singletonList(f));
		List<String[]> filas = new ArrayList<>();
		if (f.getUnidades() != null) {
			for (UnidadDeVenta u : f.getUnidades()) {
				String tipo;
				String detalle;
				if (u instanceof FoodTruck) {
					FoodTruck ft = (FoodTruck) u;
					tipo = "FoodTruck";
					detalle = "Patente: " + ft.getPatente() + ", "
							+ (ft.isConexionElectrica() ? "Eléctrico" : "No eléctrico");
				} else if (u instanceof PuestoDesarmable) {
					PuestoDesarmable p = (PuestoDesarmable) u;
					tipo = "Puesto";
					detalle = "Carpas: " + p.getCantCarpas() + ", Tiempo de armado: " + p.getTiempoDeArmado()
							+ " min.";
				} else {
					tipo = u.getClass().getSimpleName();
					detalle = "-";
				}
				filas.add(new String[] { String.valueOf(u.getIdUnidadDeVenta()), u.getNombreComercial(), tipo,
						String.valueOf(u.getSuperficie()), detalle });
			}
		}
		imprimir("UNIDADES DEL FESTIVAL " + f.getIdFestival(),
				new String[] { "ID", "NOMBRE COMERCIAL", "TIPO", "SUPERFICIE M2", "DETALLE" }, filas);
	}
}
