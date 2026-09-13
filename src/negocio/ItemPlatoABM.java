package negocio;

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

	public ItemPlato traerItemPlatoConPlato(int idItemPlato){
		return dao.traerConPlato(idItemPlato);
	}
	
	public ItemPlato traerItemPlatoConPedido(int idItemPlato){
		return dao.traerConPedido(idItemPlato);
	}
	
	public ItemPlato traerItemPlatoConPlatoyPedido(int idItemPlato){
		return dao.traerConPlatoYPedido(idItemPlato);
	}

	public int agregar(Plato p,int cantidad,Pedido ped) throws Exception {
		if (cantidad<1)
			throw new Exception("La cantidad no es valida. Tiene que ser positiva");

		ItemPlato ip = new ItemPlato(p,cantidad,ped);
		return dao.agregar(ip);
	}
	public void modificar(ItemPlato ip) {
		dao.actualizar(ip);
	}
	
	public void eliminar (int idItemPlato) {
		ItemPlato p = dao.traer(idItemPlato);
		dao.eliminar(p);
	}
	
}
