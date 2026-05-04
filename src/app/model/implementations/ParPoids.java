package app.model.implementations;

import java.util.LinkedList;

import app.model.classes.metier.Marchandise;
import app.model.interfaces.Encombrement;

public class ParPoids implements Encombrement {

	public ParPoids() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calcul(LinkedList<Marchandise> m) {
		// TODO Auto-generated method stub
		/*
		 * Calcul l'encombrement (cumul) par poids 
		 * de la liste de marchandises reçue
		 */
		int cumul = 0, i;
		for (i = 0; i < m.size(); i++)
			// cumul = cumul + m.get(i).getPoids();
			/*
			 * m : liste de marchandises
			 * m.get(i) : i-eme marchandise
			 * m.get(i).getPoids() : le poids de l'i-eme marchandise
			 */
			cumul += m.get(i).getPoids();
		
		return cumul;
	}

}
