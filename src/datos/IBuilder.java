package datos;

public interface IBuilder<T> {
	
	// <T> "generico", la interfaz permite generar un objeto de cualquier tipo"
	public T build(); //Metodo build crea el objeto

}
