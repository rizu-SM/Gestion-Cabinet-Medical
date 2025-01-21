package gestion_de_person;


public abstract class Person {

	private String nom, prenom , numeroT;

	
	public Person(String nom, String prenom , String numeroT) {
		this.nom=nom;
		this.prenom=prenom;
		this.numeroT=numeroT;
	}
	
	public Person(String nom, String prenom) {
		this.nom=nom;
		this.prenom=prenom;
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

	public String getNumeroT() {
		return numeroT;
	}

	public void setNumeroT(String numeroT) {
		this.numeroT = numeroT;
	}
	

}
