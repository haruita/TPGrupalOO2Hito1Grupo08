package test;

import datos.UnidadDeVenta;
import negocio.UnidadDeVentaABM;

public class TestSantiagoSaavedra {

	public static void main(String[] args) {

		UnidadDeVentaABM unidadABM = new UnidadDeVentaABM();

		try {
			System.out.println("Traer por codigo FT001" + unidadABM.traerPorCodigoUnico("FT001"));

			System.out.println("Foodtrucks con conexion electrica: \n");
			for (UnidadDeVenta foodTruck : unidadABM.traerFoodTrucksConConexionElectrica()) {
				System.out.println(foodTruck);
			}

			System.out.println("Foodtrucks con superficie mayor a >= 20m2 y conexiones electrica:\n");
			for (UnidadDeVenta foodTruck : unidadABM.traerFoodTrucksPorSuperficieYConexion(20.0)) {

				System.out.println(foodTruck);
			}

			System.out.println("Puestos con 3 o mas carpas");
			for (UnidadDeVenta p : unidadABM.traerPuestosPorCarpasYTiempo(3)) {
				System.out.println(p);
			}

			System.out.println("Unidades del Festival Primavera:");

			for (UnidadDeVenta unidad : festivalABM.traerUnidadesPorFestival("Festival Primavera")) {
    			System.out.println(unidad);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}