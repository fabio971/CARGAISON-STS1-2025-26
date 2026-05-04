package app.model.classes.metier;

import app.model.abstractes.CEncombrementPoids;

public class Fluviale extends CEncombrementPoids {

	public Fluviale(int distance) {
		super(distance);
		// TODO Auto-generated constructor stub
		this.limite = 300000;
	}

	@Override
	public int cout() {
		// TODO Auto-generated method stub
		return this.distance * this.encombrement.calcul(this.lesmarchandises);
	}

}
