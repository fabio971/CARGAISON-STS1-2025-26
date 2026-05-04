package app.model.classes.metier;

import app.model.abstractes.CEncombrementPoids;

public class Routiere extends CEncombrementPoids {

	public Routiere(int distance) {
		super(distance);
		// TODO Auto-generated constructor stub
		this.limite = 38000;
	}

	@Override
	public int cout() {
		// TODO Auto-generated method stub
		return 4 * this.distance * this.encombrement.calcul(this.lesmarchandises);
	}

}
