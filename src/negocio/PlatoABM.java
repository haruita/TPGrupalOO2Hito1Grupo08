package negocio;

import java.util.List;

import dao.PlatoDao;
import datos.Plato;

public class PlatoABM {
	private static PlatoABM abm = null;
	private PlatoDao dao = PlatoDao.getInstancia();
	
	private PlatoABM() {};
	
	public static PlatoABM getInstancia() {
		if(abm == null) {
			abm = new PlatoABM();
		}
		return abm;
	}
	
	public Plato traerPlato(int idPlato) {
		Plato p = dao.traerPlato(idPlato);
		return p;
	}


	public int agregar (String nombre,double precio,double costo) {
		Plato p = new Plato(nombre, precio, costo);
		return dao.agregar(p);
	}
	
	public void modificar (Plato p) {
		dao.actualizar(p);
	}
	
	public void eliminar (int idPlato) {
		Plato p = dao.traerPlato(idPlato);
		dao.eliminar(p);
	}
	
	public List<Plato> traerPlato() {
		return dao.traerPlato();
	}
}
