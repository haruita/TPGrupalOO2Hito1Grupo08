package datos;

import java.time.LocalDate;
import java.util.Set;

public class Pedido {

	private int idPedido;
	private UnidadDeVenta unidad;
	private LocalDate fecha;
	private Set<ItemPlato> items;

	public Pedido() {
	}

	public Pedido(UnidadDeVenta unidad, LocalDate fecha) {
		this.unidad = unidad;
		this.fecha = fecha;
	}
	public Pedido(UnidadDeVenta unidad, LocalDate fecha, Set<ItemPlato> items) {
		this.unidad = unidad;
		this.fecha = fecha;
		this.items = items;
	}
	
	public Pedido(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public UnidadDeVenta getUnidad() {
		return unidad;
	}

	public void setUnidad(UnidadDeVenta unidad) {
		this.unidad = unidad;
	}

	public UnidadDeVenta getUnidadDeVenta() {
		return unidad;
	}

	public void setUnidadDeVenta(UnidadDeVenta unidad) {
		this.unidad = unidad;
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
		boolean agregar = false;
		if (!(items.contains(item))) {
			agregar = this.items.add(item);
		}
		return agregar;
	};

	@Override
	public String toString() {
		if (items!= null)
			return "Pedido [idPedido=" + idPedido + ", " + "fecha=" + fecha + ", lstItemPlatos=\n" + items + "]";
		else
			return "Pedido [idPedido=" + idPedido + ", " + "fecha=" + fecha;
	}

	public boolean equals(Pedido pedido) {
		return (this.getIdPedido() == pedido.getIdPedido());
	}

	public double calcularTotal() {
		double total = 0;
		if (this.items != null) {
			for (ItemPlato i : this.items) {
				total += i.getSubtotal();
			}			
		}
		return total;
	}

    public double calcularGanancia() {
        double ganancia = 0;
        if (this.items != null) {
            for (ItemPlato i : this.items) {
            	Plato plato = i.getPlato();
            	if (plato != null) {
                    ganancia += (plato.getPrecio() - plato.getCosto() )* i.getCantidad();
                }
            }
        }
        return ganancia;
    }

}
