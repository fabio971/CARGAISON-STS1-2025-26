package app.controller;

import java.util.List;

import app.model.Etudiant;
import app.model.repository.EtudiantRepository;
import app.view.FenetrePrincipale;
import app.view.panels.EtudiantsPanel;

public class EtudiantController {

	private final EtudiantRepository repo;
    private final EtudiantsPanel view;

    public EtudiantController(EtudiantRepository repo, FenetrePrincipale frame) {
        this.repo = repo;
        this.view = frame.getEtudiantsPanel();

        brancherActions();
        refreshTable();
    }

    private void brancherActions() {
        view.getBtnAjouter().addActionListener(e -> ajouter());
        view.getBtnModifier().addActionListener(e -> modifier());
        view.getBtnSupprimer().addActionListener(e -> supprimer());
        view.getBtnRafraichir().addActionListener(e -> refreshTable());
    }

    private void ajouter() {
        String nom = view.getNomSaisi();
        String prenom = view.getPrenomSaisi();

        if (nom.isBlank() || prenom.isBlank()) {
            view.showError("Nom et prénom obligatoires.");
            return;
        }

        repo.create(nom.toUpperCase(), prenom);
        view.clearForm();
        refreshTable();
        view.showInfo("Étudiant ajouté.");
    }

    private void modifier() {
        Integer id = view.getSelectedId();
        if (id == null) {
            view.showError("Sélectionne une ligne dans la table.");
            return;
        }

        String nom = view.getNomSaisi();
        String prenom = view.getPrenomSaisi();

        if (nom.isBlank() || prenom.isBlank()) {
            view.showError("Nom et prénom obligatoires pour modifier.");
            return;
        }

        boolean ok = repo.update(id, nom.toUpperCase(), prenom);
        if (!ok) {
            view.showError("Étudiant introuvable (id=" + id + ").");
            return;
        }

        view.clearForm();
        refreshTable();
        view.showInfo("Étudiant modifié.");
    }

    private void supprimer() {
        Integer id = view.getSelectedId();
        if (id == null) {
            view.showError("Sélectionne une ligne dans la table.");
            return;
        }

        boolean ok = repo.delete(id);
        if (!ok) {
            view.showError("Impossible de supprimer (id=" + id + ").");
            return;
        }

        refreshTable();
        view.showInfo("Étudiant supprimé.");
    }

    private void refreshTable() {
        List<Etudiant> all = repo.findAll();

        Object[][] rows = new Object[all.size()][3];
        for (int i = 0; i < all.size(); i++) {
            Etudiant e = all.get(i);
            rows[i][0] = e.getId();
            rows[i][1] = e.getNom();
            rows[i][2] = e.getPrenom();
        }
        view.setTableData(rows);
    }
	
}
