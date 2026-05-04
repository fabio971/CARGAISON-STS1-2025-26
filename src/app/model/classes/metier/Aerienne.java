package app.model.classes.metier;

import app.model.abstractes.CEncombrementVolume;

public class Aerienne extends CEncombrementVolume {

	public Aerienne(int distance) {
		super(distance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int cout() {
		// TODO Auto-generated method stub
		return 10 * this.distance * this.encombrement.calcul(this.lesmarchandises);
	}

}
