package app.model.abstractes;

import app.model.classes.metier.Marchandise;
import app.model.implementations.ParPoids;
import app.model.interfaces.Encombrement;

public abstract class CEncombrementPoids extends Cargaison {

	public CEncombrementPoids(int distance) {
		super(distance, new ParPoids());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouter(Marchandise m) {
		// TODO Auto-generated method stub
		/*
		 * si l'encombrement actuel des marchandises
		 * +
		 * le poids de la nouvelle marchandises
		 * est inferieur ou egale à la limite
		 * alors on ajoute la marchandise "m"
		 */
		if (this.encombrement.calcul(this.lesmarchandises) + m.getPoids() <= this.limite)
			this.lesmarchandises.add(m);
	}

}
