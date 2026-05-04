package app.model.abstractes;

import app.model.classes.metier.Marchandise;
import app.model.implementations.ParVolume;
import app.model.interfaces.Encombrement;

public abstract class CEncombrementVolume extends Cargaison {

	public CEncombrementVolume(int distance) {
		super(distance, new ParVolume());
		// TODO Auto-generated constructor stub
		this.limite = 80000;
	}

	@Override
	public void ajouter(Marchandise m) {
		// TODO Auto-generated method stub
		if (this.encombrement.calcul(this.lesmarchandises) + m.getVolume() <= this.limite)
			this.lesmarchandises.add(m);
	}

}
