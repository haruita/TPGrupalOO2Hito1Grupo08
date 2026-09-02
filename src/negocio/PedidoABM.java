package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PedidoDao;
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

	public Pedido traerPedidoBasico(int idPedido) {
		return dao.traerBasico(idPedido);
	}

	public List<Pedido> traerPedidos() {
		return dao.traer();
	}

	public List<Pedido> traerPedidos(UnidadDeVenta unidad) {
		return dao.traer(unidad);
	}

	public List<Pedido> traerPedidos(LocalDate fecha) {
		return dao.traer(fecha);
	}

	public int agregar(UnidadDeVenta unidad, LocalDate fecha) {
		Pedido p = new Pedido(unidad, fecha);
		return dao.agregar(p);
	}

	public void modificar(Pedido p) {
		dao.actualizar(p);
	}

	public void eliminar(int idPedido) {
		Pedido p = dao.traerBasico(idPedido);
		if (p != null) {
			dao.eliminar(p);
		}
	}
}
