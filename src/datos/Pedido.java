package datos;

import java.time.LocalDate;
import java.util.Set;

public class Pedido {

	private int idPedido;
	private Festival festival;
	private LocalDate fecha;
	private Set<ItemPlato> items;

	public Pedido() {
	}

	public Pedido(Festival festival, LocalDate fecha) {
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

	public Set<ItemPlato> getItems() {
		return this.items;
	}

	public void setItems(Set<ItemPlato> items) {
		this.items = items;
	}

	public boolean agregarItemPlato(ItemPlato item) {
		return this.items.add(item);
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", festival=" + (festival != null ? festival.getNombre() : null)
				+ ", fecha=" + fecha + ", lstItemPlatos=\n" + items + "]";
	}

	public boolean equals(Pedido pedido) {
		return (this.getIdPedido() == pedido.getIdPedido());
	}

	public double calcularTotal() {
		double total = 0;
		for (ItemPlato i : this.items) {
			total += i.calcularTotalPorItem();
		}
		return total;
	}

	public double calcularGanancia() {
		double costos = 0;
		for (ItemPlato i : this.items) {
			costos += i.getPlato().getCosto() * i.getCantidad();
		}
		return (this.calcularTotal() - costos);
	}
}
