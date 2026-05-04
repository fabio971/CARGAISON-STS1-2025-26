package app.model.implementations;

import java.util.LinkedList;

import app.model.classes.metier.Marchandise;
import app.model.interfaces.Encombrement;

public class ParVolume implements Encombrement {

	public ParVolume() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calcul(LinkedList<Marchandise> m) {
		// TODO Auto-generated method stub
		/*
		 * Calcul l'encombrement (cumul) par volume 
		 * de la liste de marchandises reçue
		 */
		int cumul = 0, i;
		for (i = 0; i < m.size(); i++)
			// cumul = cumul + m.get(i).getVolume();
			/*
			 * m : liste de marchandises
			 * m.get(i) : i-eme marchandise
			 * m.get(i).getVolume() : le volume de l'i-eme marchandise
			 */
			cumul += m.get(i).getVolume();
		
		return cumul;
	}

}
