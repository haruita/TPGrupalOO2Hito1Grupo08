package datos;

import java.util.Set;

public abstract class UnidadDeVenta {

	private int idUnidadDeVenta;
	private String nombreComercial;
	private String codigoUnico;
	private double superficie;
	private Persona responsable;
	private Set<Persona> personal;
	private Set<Plato> platos;
	private Set<Pedido> pedidos;

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

	public void setPersonal(Set<Persona> personas) {
		this.personal = personas;
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

	public boolean equals(UnidadDeVenta unidad) {
		return this.codigoUnico.equals(unidad.getCodigoUnico());
	}

	// CALCULARCANON ABSTRACTO, SE HACE OVERRIDE EN LAS HIJAS
	public abstract double calcularCanon(double costoSuperficie, double costoAdicional);
}
