package test;

import negocio.PlatoABM;

import java.util.List;

import datos.Plato;
import negocio.ItemPlatoABM;


public class testPlato {

	public static void main(String[] args) {
		
		
		// TODO Hacer que el test funcione desde 0.
		PlatoABM pABM = PlatoABM.getInstancia();
		ItemPlatoABM ipABM = ItemPlatoABM.getInstancia();
		
		int ultimoPlato = pABM.agregar("Tacos", 1500, 700);
		System.out.println("PrimerPlato ID" + ultimoPlato);
		System.out.println("Traido por ID: " + pABM.traerPlato(ultimoPlato));
		System.out.println("Todos los Platos agregados:");
		List<Plato> platos = pABM.traerPlato();
		for (Plato p : platos) {
//			int item = ipABM.agregar(p, 2);
//			System.out.println(item);
			System.out.println(p);
		}
		
		System.out.println(ipABM.traerItemPlato(1));
		System.out.println(ipABM.traerItemPlato(2));

	}

}
