package test;

import dao.UnidadDeVentaDao;
import datos.FoodTruck;
import datos.PuestoDesarmable;
import datos.UnidadDeVenta;

public class TestSantiagoSaavedra {

	public static void main(String[] args) {

		UnidadDeVentaDao dao = new UnidadDeVentaDao();
		FoodTruck foodTruck1 = new FoodTruck("El Buen Sabor", "FT001", 20.0, null, "AA123BB", true);
		FoodTruck foodTruck2 = new FoodTruck("La Esquina", "FT002", 15.0, null, "AB456CD", false );
		FoodTruck foodTruck3 = new FoodTruck("Sabores Urbanos",	"FT003", 30.0, null, "AC789EF", true);
		PuestoDesarmable puesto1 = new PuestoDesarmable("Puesto Criollo", "PD001", 10.0, null, 3, 20);
		PuestoDesarmable puesto2 = new PuestoDesarmable("Delicias del Festival", "PD002", 25.0, null, 5, 30);

		dao.agregar(foodTruck1, foodTruck2, foodTruck3, puesto1, puesto2);		
		System.out.println("Unidades agregadas: \n");
		for (UnidadDeVenta unidad : dao.traerTodas()) {
			System.out.println(unidad);
		}

		System.out.println("Traer por codigo FT001" + dao.traerPorCodigoUnico("FT001"));

		System.out.println("Foodtryucks con conexion electrica: \n");
		for (FoodTruck foodTruck : dao.traerFoodTrucksConConexionElectrica()) {
			System.out.println(foodTruck);
		}

		System.out.println("Foodtrucks con superficie mayor a >= 20m2 y conexiones electrica:\n");
		for (FoodTruck foodTruck :
				dao.traerFoodTrucksPorSuperficieYConexion(20.0)) {

			System.out.println(foodTruck);
		}


		System.out.println("Puestos con 3 o mas carpas");
		for (PuestoDesarmable p: dao.traerPuestosPorCarpasYTiempo(3)) {
			System.out.println(p);
		}

	}

}