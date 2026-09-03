package datos;

import java.util.HashSet;
import java.util.Set;

public class Costo {

	private int idCosto;
	private double porSuperficie;
	private double porMontaje;
	private double porElectricidad;
	private Set<Festival> festivales = new HashSet<Festival>();

	public Costo() {
	};

	public Costo(double porSuperficie, double porMontaje, double porElectricidad) {
		this.porSuperficie = porSuperficie;
		this.porMontaje = porMontaje;
		this.porElectricidad = porElectricidad;
	}

	public int getIdCosto() {
		return idCosto;
	}

	public void setIdCosto(int idCosto) {
		this.idCosto = idCosto;
	}

	public double getPorSuperficie() {
		return porSuperficie;
	}

	public void setPorSuperficie(double porSuperficie) {
		this.porSuperficie = porSuperficie;
	}

	public double getPorMontaje() {
		return porMontaje;
	}

	public void setPorMontaje(double porMontaje) {
		this.porMontaje = porMontaje;
	}

	public double getPorElectricidad() {
		return porElectricidad;
	}

	public void setPorElectricidad(double porElectricidad) {
		this.porElectricidad = porElectricidad;
	}

	public Set<Festival> getFestivales() {
		return festivales;
	}

	public void setFestivales(Set<Festival> festivales) {
		this.festivales = festivales;
	}

	@Override
	public String toString() {
		return "COSTO [ id: " + this.idCosto + ", porSuperficie: " + this.porSuperficie + ", porMontaje: "
				+ this.porMontaje + ", porElectricidad: " + this.porElectricidad + "]";
	}
}
