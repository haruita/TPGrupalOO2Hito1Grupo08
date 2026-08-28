package datos;

public class ItemPlato {

	private int idItemPlato;
	private Plato plato;
	private int cantidad;
	private double subtotal;
	
	public ItemPlato() {
	}

	public ItemPlato(Plato plato, int cantidad, int subTotal) {
		this.plato = plato;
		this.cantidad = cantidad;
		this.subtotal = subTotal;
	}

	public int getIdItemPlato() {
		return idItemPlato;
	}

	public void setIdItemPlato(int idItemPlato) {
		this.idItemPlato = idItemPlato;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	public double calcularSubtotal() {
		return plato.getPrecio() * cantidad;
	}
	
	@Override
	public String toString() {
		return "ItemPlato [idItemPlato=" + idItemPlato + ", plato=" + plato + ", cantidad=" + cantidad + "]";
	}

	public boolean equals(ItemPlato item) {
		return (this.getPlato().equals(item.getPlato()) && this.getCantidad() == item.getCantidad());
	}
}
