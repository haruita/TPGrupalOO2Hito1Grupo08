package datos;

public class ItemPlato {

	private int idItemPlato;
	private int cantidad;
	private double subtotal;
	private Plato plato;
	private Pedido pedido;
	
	public ItemPlato() {
	}

	public ItemPlato(Plato plato, int cantidad) {
		this.plato = plato;
		this.cantidad = cantidad;
		this.subtotal = ItemPlato.calcularSubtotal(cantidad, plato);
	}

	public ItemPlato(Plato plato, int cantidad, Pedido pedido) {
		this.plato = plato;
		this.cantidad = cantidad;
		this.subtotal = ItemPlato.calcularSubtotal(cantidad, plato);
		this.pedido = pedido;
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

	public Pedido getPedido() {
		return this.pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	static private double calcularSubtotal(int cantidad, Plato plato) {
		return cantidad * plato.getPrecio();
	}

	@Override
	public String toString() {
		return "ItemPlato [idItemPlato=" + idItemPlato + ", plato=" + plato + ", cantidad=" + cantidad +", subtotal=" + subtotal+ "]";
	}

	public boolean equals(ItemPlato item) {
		return (this.getPlato().equals(item.getPlato()) && this.cantidad == item.cantidad && this.subtotal == item.subtotal);
	}
}
