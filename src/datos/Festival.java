package datos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Festival {

	private int idFestival;
	private String nombre;
	private String temporada;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Costo costo;
	private Set<UnidadDeVenta> unidades;

	public Festival() {
		this.unidades = new HashSet<UnidadDeVenta>();
	}

	public Festival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin, Costo costo) {
		this();
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.costo = costo;
	}

	public int getIdFestival() {
		return idFestival;
	}

	public void setIdFestival(int idFestival) {
		this.idFestival = idFestival;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Costo getCosto() {
		return costo;
	}

	public void setCosto(Costo costo) {
		this.costo = costo;
	}

	public Set<UnidadDeVenta> getUnidades() {
		return unidades;
	}

	public void setUnidades(Set<UnidadDeVenta> unidades) {
		this.unidades = unidades;
	}

	public void setLstUnidades(Set<UnidadDeVenta> unidades) {
		this.unidades = unidades;
	}

	public boolean agregarUnidadDeVenta(UnidadDeVenta unidad) {
		boolean agregar = false;
		// Solo se agrega si no esta en el set.
		if (unidad != null && !(unidades.contains(unidad))) {
			agregar = unidades.add(unidad);
		}
		return agregar;
	}

	public boolean eliminarUnidadDeVenta(UnidadDeVenta unidad) {
		UnidadDeVenta borrar = null;
		boolean eliminar = false;
		Iterator<UnidadDeVenta> iter = unidades.iterator();

		// Para cuando encuentra uno, no deberia de haber duplicados en el set
		// Pero es mas rápio que pare cuando encuentra
		while ((iter.hasNext()) && (borrar == null)) {
			UnidadDeVenta actual = iter.next();
			if (actual.equals(unidad))
				borrar = actual;
		}
		eliminar = unidades.remove(borrar);
		return eliminar;
	}

	@Override
	public String toString() {
		return "\nFESTIVAL [ id: " + this.idFestival + ", nombre: " + this.nombre + ", temporada: " + this.temporada
				+ ", fechaInicio: " + this.fechaInicio + ", fechaFin: " + this.fechaFin + ", costo: " + this.costo
				+ "]";
	}

	public boolean equals(Festival festival) {
		return (this.getNombre().equals(festival.getNombre()));
	}
}
