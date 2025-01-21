package gestion_de_fiche_patient;

import gestion_de_person.Person;

import java.time.LocalDate;


public class Patient extends Person{
	
	private int ID;
 
	private LocalDate DateN; //date de naissance.
	
	private int age;
	
	private String adresse;
	
	private char sexe;
	

	public Patient(String nom, String prenom, String numeroT, LocalDate DateN, int age, 
			
	String adresse, char sexe, int ID) {
		
		super(nom, prenom, numeroT);
		
		this.ID=ID;
		
		this.DateN=DateN;
		
		this.age=age;
		
		this.adresse=adresse;
		
		this.sexe=sexe;
		
	}
	
	
	
    public Patient(String nom, String prenom , int age) {
    	
    	super(nom,prenom);
    	this.age=age;
		
	} /*ce constructeur est utilisé si nous voulons ajouter 
	 
	un patient avec uniquement son nom, son prenom et son age. */
    
    
    public String toString() {
    	return "PATIENT ID: "+ID+"\nNom: "+getNom()+"\nPrenom: "+getPrenom()+"\nNuméro De Téléphone: "+getNumeroT()
    	+"\nDate de Naissance: "+DateN+"\nAge: "+age+"\nAdresse: "+adresse+"\nSexe: "+sexe;
    }
    
    public void afficherPatient() {
    	System.out.println(this.toString());
    }
    
    
    
    //les getters & setters pour les variables privé de Patient class :


	public LocalDate getDateN() {
		return DateN;
	}

	



	public void setDateN(LocalDate dateN) {
		DateN = dateN;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public char getSexe() {
		return sexe;
	}

	public void setSexe(char sexe) {
		this.sexe = sexe;
	}


	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	} 
    
    
	
	

}
