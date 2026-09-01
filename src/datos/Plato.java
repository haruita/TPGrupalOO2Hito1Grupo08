package datos;

import java.util.Set;

public class Plato {

	private int idPlato;
	private String nombre;
	private double precio;
	private double costo;
	private Set<ItemPlato> itemPlatos;

	public Plato() {
	}

	public Plato(String nombre, double precio, double costo) {
		this.nombre = nombre;
		this.precio = precio;
		this.costo = costo;
	}

	public int getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public Set<ItemPlato> getItemPlatos() {
		return itemPlatos;
	}

	public void setItemPlatos(Set<ItemPlato> items) {
		this.itemPlatos = items;
	}

	@Override
	public String toString() {
		return "Plato [idPlato=" + idPlato + ", nombre=" + nombre + ", precio=" + precio + ", costo=" + costo + "]";
	}

	public boolean equals(Plato plato) {
		return (this.getNombre().equalsIgnoreCase(plato.getNombre()));
	}
}
