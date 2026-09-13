package datos;

import java.util.HashSet;
import java.util.Set;

public abstract class UnidadDeVenta {

	private int idUnidadDeVenta;

	private String nombreComercial;

	private String codigoUnico;

	private double superficie;

	private Persona responsable;

	private Set<Persona> personal = new HashSet<Persona>();

	private Set<Plato> platos = new HashSet<Plato>();

	private Set<Pedido> pedidos = new HashSet<Pedido>();

	public UnidadDeVenta() {

	}

	public UnidadDeVenta(String nombreComercial, String codigoUnico, double superficie, Persona responsable) {

		this.nombreComercial = nombreComercial;

		this.codigoUnico = codigoUnico;

		this.superficie = superficie;

		this.responsable = responsable;

	}

	public int getIdUnidadDeVenta() {
		return idUnidadDeVenta;
	}

	public void setIdUnidadDeVenta(int idUnidadDeVenta) {
		this.idUnidadDeVenta = idUnidadDeVenta;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getCodigoUnico() {
		return codigoUnico;
	}

	public void setCodigoUnico(String codigoUnico) {
		this.codigoUnico = codigoUnico;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public Persona getResponsable() {
		return responsable;
	}

	public void setResponsable(Persona responsable) {
		this.responsable = responsable;
	}

	public Set<Persona> getPersonal() {
		return personal;
	}

	public void setPersonal(Set<Persona> personal) {
		this.personal = personal;
	}

	public Set<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(Set<Plato> platos) {
		this.platos = platos;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public boolean agregarEmpleado(Persona empleado) {
		return this.personal.add(empleado);
	}

	public boolean agregarPlato(Plato plato) {
		return this.platos.add(plato);
	}

	public boolean agregarPedido(Pedido pedido) {
		return this.pedidos.add(pedido);
	}

	@Override
	public String toString() {
		return "UnidadDeVenta [idUnidadDeVenta=" + idUnidadDeVenta + ", nombreComercial=" + nombreComercial
				+ ", codigoUnico=" + codigoUnico + ", superficie=" + superficie + ", \nresponsable=" + responsable
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		UnidadDeVenta unidad = (UnidadDeVenta) obj;

		return codigoUnico.equals(unidad.getCodigoUnico());
	}

	@Override
	public int hashCode() {
		return codigoUnico.hashCode();
	}

	public abstract double calcularCanon(double costoSuperficie, double costoAdicional);

}