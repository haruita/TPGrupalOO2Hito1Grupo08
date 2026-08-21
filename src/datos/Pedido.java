package datos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private int idPedido;
	private Festival festival;
	private LocalDate fecha;
	private List<ItemPlato> lstItemPlatos;

	public Pedido() {
		super();
		this.lstItemPlatos = new ArrayList<ItemPlato>();
	}

	public Pedido(Festival festival, LocalDate fecha) {
		this();
		this.festival = festival;
		this.fecha = fecha;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<ItemPlato> getLstItemPlatos() {
		return lstItemPlatos;
	}

	public void setLstItemPlatos(List<ItemPlato> lstItemPlatos) {
		this.lstItemPlatos = lstItemPlatos;
	}

	public boolean agregarItemPlato(ItemPlato item) {
		return this.lstItemPlatos.add(item);
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", festival=" + (festival != null ? festival.getNombre() : null)
				+ ", fecha=" + fecha + ", lstItemPlatos=\n" + lstItemPlatos + "]";
	}

	public boolean equals(Pedido pedido) {
		return (this.getIdPedido() == pedido.getIdPedido());
	}

	public double calcularTotal() {
		double total = 0;
		for (ItemPlato i : this.lstItemPlatos) {
			total += i.calcularTotalPorItem();
		}
		return total;
	}

	public double calcularGanancia() {
		double costos = 0;
		for (ItemPlato i : this.lstItemPlatos) {
			costos += i.getPlato().getCosto() * i.getCantidad();
		}
		return (this.calcularTotal() - costos);
	}
}
