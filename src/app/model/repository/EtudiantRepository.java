package app.model.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import app.model.Etudiant;

public class EtudiantRepository {

	private final List<Etudiant> data = new ArrayList<>();
    private int nextId = 1;

    public EtudiantRepository() {
        create("DURAND", "Léa");
        create("BERNARD", "Noah");
    }

    public List<Etudiant> findAll() {
        return Collections.unmodifiableList(data);
    }

    public Optional<Etudiant> findById(int id) {
        return data.stream().filter(e -> e.getId() == id).findFirst();
    }

    public Etudiant create(String nom, String prenom) {
        Etudiant e = new Etudiant(nextId++, nom, prenom);
        data.add(e);
        return e;
    }

    public boolean update(int id, String nom, String prenom) {
        Optional<Etudiant> opt = findById(id);
        if (opt.isEmpty()) return false;
        opt.get().setNom(nom);
        opt.get().setPrenom(prenom);
        return true;
    }

    public boolean delete(int id) {
        return data.removeIf(e -> e.getId() == id);
    }
	
}
