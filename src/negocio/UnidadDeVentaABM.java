package negocio;

import java.util.List;

import dao.UnidadDeVentaDao;
import datos.FoodTruck;
import datos.Persona;
import datos.PuestoDesarmable;
import datos.UnidadDeVenta;

public class UnidadDeVentaABM {

	private UnidadDeVentaDao dao = new UnidadDeVentaDao();

	public int agregarFoodTruck(String nombre, String codigo, double superficie, Persona responsable, String patente,
			boolean conexionElectrica) {
		FoodTruck u = new FoodTruck(nombre, codigo, superficie, responsable, patente, conexionElectrica);
		return dao.agregar(u);
	}

	public int agregarPuestoDesarmable(String nombre, String codigo, double superficie, Persona responsable, int cantCarpas,
			int tiempoDeArmado) {
		PuestoDesarmable u = new PuestoDesarmable(nombre, codigo, superficie, responsable, cantCarpas, tiempoDeArmado);
		return dao.agregar(u);
	}

	public UnidadDeVenta traer(int idUnidadDeVenta) {
		return dao.traer(idUnidadDeVenta);
	}

	public UnidadDeVenta traerPorCodigoUnico(String codigoUnico) {
		return dao.traerPorCodigoUnico(codigoUnico);
	}

	public List<FoodTruck> traerFoodTrucksConConexionElectrica() {
		return dao.traerFoodTrucksConConexionElectrica();
	}

	public List<FoodTruck> traerFoodTrucksPorSuperficieYConexion(double superficieMinima) throws Exception {
		if (superficieMinima < 0)
			throw new Exception("La superficie minima tiene que ser mayor a 0");
		return dao.traerFoodTrucksPorSuperficieYConexion(superficieMinima);
	}
	
	public List<PuestoDesarmable> traerPuestosPorCarpasYTiempo(int cantidadMinimaCarpas) throws Exception {
		if (cantidadMinimaCarpas <=0 )
			throw new Exception("La cantidad de carpas tiene que ser mayor a 0");
		return dao.traerPuestosPorCarpasYTiempo(cantidadMinimaCarpas);
	}
	
	public List<UnidadDeVenta> traerTodas() {
		return dao.traerTodas();
	}

	public void actualizar(UnidadDeVenta objeto) {
		dao.actualizar(objeto);
	}

	public void eliminar(UnidadDeVenta objeto) {
		dao.eliminar(objeto);
	}

}