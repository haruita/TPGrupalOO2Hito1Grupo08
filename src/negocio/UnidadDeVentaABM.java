package negocio;

import java.util.List;

import dao.UnidadDeVentaDao;
import datos.UnidadDeVenta;

public class UnidadDeVentaABM {

	private UnidadDeVentaDao dao = new UnidadDeVentaDao();

	public int agregar(UnidadDeVenta objeto) {
		return dao.agregar(objeto);
	}

	public UnidadDeVenta traer(int idUnidadDeVenta) {
		return dao.traer(idUnidadDeVenta);
	}

	public UnidadDeVenta traerPorCodigoUnico(String codigoUnico) {
		return dao.traerPorCodigoUnico(codigoUnico);
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