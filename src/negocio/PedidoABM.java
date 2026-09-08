package negocio;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import dao.PedidoDao;
import datos.ItemPlato;
import datos.Pedido;
import datos.UnidadDeVenta;

public class PedidoABM {
	private static PedidoABM abm = null;
	private PedidoDao dao = PedidoDao.getInstancia();

	private PedidoABM() {
	}

	public static PedidoABM getInstancia() {
		if (abm == null) {
			abm = new PedidoABM();
		}
		return abm;
	}

	public Pedido traerPedido(int idPedido) {
		return dao.traer(idPedido);
	}

	public Pedido traerPedidoConItems(int idPedido) {
		return dao.traerConItems(idPedido);
	}
	
	public Pedido traerPedidoConItemsYUnidadDeVenta(int idPedido) {
		return dao.traerConItemsYUnidadDeVenta(idPedido);
	}

	public List<Pedido> traerPedidos(UnidadDeVenta unidad) {
		return dao.traer(unidad);
	}

	public List<Pedido> traerPedidosEnFecha(LocalDate fecha) {
		return dao.traerDeFecha(fecha);
	}

	public List<Pedido> traerPedidosEntreFechas(LocalDate fecha1,LocalDate fecha2) {
		return dao.traerEntreFechas(fecha1,fecha2);
	}
	
	public int agregar(LocalDate fecha) {
		Pedido p = new Pedido(fecha);
		return dao.agregar(p);
	}
	
	public int agregar(UnidadDeVenta unidad, LocalDate fecha) {
		Pedido p = new Pedido(unidad, fecha);
		return dao.agregar(p);
	}

	public int agregar(UnidadDeVenta unidad, LocalDate fecha,Set<ItemPlato> items) {
		Pedido p = new Pedido(unidad, fecha,items);
		return dao.agregar(p);
	}
	
	public void modificar(Pedido p) {
		dao.actualizar(p);
	}

	public void eliminar(int idPedido) {
		Pedido p = dao.traer(idPedido);
		if (p != null) {
			dao.eliminar(p);
		}
	}
}
