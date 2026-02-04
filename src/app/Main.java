package app;

import javax.swing.SwingUtilities;

import app.controller.EtudiantController;
import app.model.repository.EtudiantRepository;
import app.view.FenetrePrincipale;

public class Main {
	
	/*
	 * Comment l’appli “circule”
	 * 
	 * L’utilisateur clique Ajouter
	 * Swing appelle le listener du contrôleur
	 * Le contrôleur lit nom/prenom depuis la View
	 * Le contrôleur appelle repo.create(...) (Model)
	 * Le contrôleur appelle refreshTable()
	 * La View met à jour la table via setTableData(...)
	 * 
	 * La View n’appelle pas le Model directement.
	 * Le Model ne connaît pas la View.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(() -> {
            EtudiantRepository repo = new EtudiantRepository();
            FenetrePrincipale frame = new FenetrePrincipale();
            new EtudiantController(repo, frame);
        });
	}

}
