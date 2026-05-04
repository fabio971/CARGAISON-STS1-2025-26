package app.model.classes.metier;

public class Client {
	// ATTRIBUTS
	private String identifiant;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String email;
	
	// METHODES
	
	// Constructeur d'initialisation
	public Client(String identifiant, 
			      String nom, 
			      String prenom, 
			      String adresse, 
			      String telephone, 
			      String email) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
	}
	
	// Constructeur par défaut
	public Client() {
		super();
		this.identifiant = "";
		this.nom = "";
		this.prenom = "";
		this.adresse = "";
		this.telephone = "";
		this.email = "";
	}

	// GETTERS et SETTERS
	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [identifiant=" + identifiant + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", telephone=" + telephone + ", email=" + email + "]";
	}
}
