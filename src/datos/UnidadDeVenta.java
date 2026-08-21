package datos;

import java.util.ArrayList;
import java.util.List;

public abstract class UnidadDeVenta {

	private int idUnidadDeVenta;
	private String nombreComercial;
	private String codigoUnico;
	private double superficie;
	private Persona responsable;
	private List<Persona> lstPersonas;
	private List<Plato> lstPlatos;
	private List<Pedido> lstPedidos;

	public UnidadDeVenta() {
		super();
		this.lstPersonas = new ArrayList<Persona>();
		this.lstPlatos = new ArrayList<Plato>();
		this.lstPedidos = new ArrayList<Pedido>();
	}

	public UnidadDeVenta(String nombreComercial, String codigoUnico, double superficie, Persona responsable) {
		this();
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

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}

	public List<Plato> getLstPlatos() {
		return lstPlatos;
	}

	public void setLstPlatos(List<Plato> lstPlatos) {
		this.lstPlatos = lstPlatos;
	}

	public List<Pedido> getLstPedidos() {
		return lstPedidos;
	}

	public void setLstPedidos(List<Pedido> lstPedidos) {
		this.lstPedidos = lstPedidos;
	}

	public boolean agregarEmpleado(Persona empleado) {
		return this.lstPersonas.add(empleado);
	}

	public boolean agregarPlato(Plato plato) {
		return this.lstPlatos.add(plato);
	}

	public boolean agregarPedido(Pedido pedido) {
		return this.lstPedidos.add(pedido);
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
