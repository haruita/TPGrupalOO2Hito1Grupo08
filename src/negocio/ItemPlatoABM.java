package negocio;

import java.util.List;

import datos.Plato;
import datos.ItemPlato;
import datos.Pedido;
import dao.ItemPlatoDao;

public class ItemPlatoABM {
	private static ItemPlatoABM abm = null;
	private ItemPlatoDao dao = ItemPlatoDao.getInstancia();
	
	private ItemPlatoABM() {};
	
	public static ItemPlatoABM getInstancia() {
		if(abm == null) {
			abm = new ItemPlatoABM();
		}
		return abm;
	}
	
	public ItemPlato traerItemPlato(int idItemPlato){
		return dao.traer(idItemPlato);
	}
	
	public List<ItemPlato> traerItemPlato(Plato p){
		return dao.traer(p);
	}	
	public ItemPlato traerItemPlatoBasico(int idItemPlato){
		return dao.traerBasico(idItemPlato);
	}

	public int agregar(Plato p,int cantidad,Pedido ped) {
		ItemPlato ip = new ItemPlato(p,cantidad,ped);
		return dao.agregar(ip);
	}
	
	public void modificar(ItemPlato ip) {
		dao.actualizar(ip);
	}
	
	public void eliminar (int idItemPlato) {
		ItemPlato p = dao.traerBasico(idItemPlato);
		dao.eliminar(p);
	}
	
}
