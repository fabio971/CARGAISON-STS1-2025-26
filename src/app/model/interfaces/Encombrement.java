/**
 * 
 */
package app.model.interfaces;

import java.util.LinkedList;

import app.model.classes.metier.Marchandise;

/**
 * Interface qui contient une méthode
 * abstraite pour effectuer le calcul de
 * l'encombrement de la liste
 * des marchandises reçue.
 */
public interface Encombrement {

	public abstract int calcul(LinkedList<Marchandise> m);
	
}
