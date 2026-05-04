package app.model.classes.metier;

public class AerienneUrgence extends Aerienne {

	public AerienneUrgence(int distance) {
		super(distance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int cout() {
		// TODO Auto-generated method stub
		return super.cout() * 2;
	}

}
