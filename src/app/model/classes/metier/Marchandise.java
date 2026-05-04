package app.model.classes.metier;

public class Marchandise {
	// ATTRIBUTS
	private int poids;
	private int volume;
	
	// Constructeur d'initiation
	public Marchandise(int poids, 
			           int volume) {
		/*
		 * super() : fait appel au constructeur de la classe mère (Object)
		 */
		super();
		this.poids = poids;
		this.volume = volume;
	}
	
	// Constructeur par défaut
	public Marchandise() {
		super();
		this.poids = 0;
		this.volume = 0;
	}

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Marchandise [poids=" + poids + ", volume=" + volume + "]";
	}

}
