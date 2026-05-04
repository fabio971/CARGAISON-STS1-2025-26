package app.model.abstractes;

import java.util.LinkedList;

import app.model.classes.metier.Marchandise;
import app.model.interfaces.Encombrement;

public abstract class Cargaison  {
	protected int distance;
	protected int limite;
	
	/*
	 * Agrégation car les marchandises
	 * continuent à exister une fois 
	 * la cargaison arrivée à sa destination
	 */
	protected LinkedList<Marchandise> lesmarchandises;
	
	protected Encombrement encombrement;
	
	// Constructeur d'initialisation
	public Cargaison(int distance, Encombrement e) {
		super();
		this.distance = distance;
		this.lesmarchandises = new LinkedList<Marchandise>();
		this.encombrement = e;
	}
	
	public abstract void ajouter(Marchandise m);
	public abstract int cout();
}
