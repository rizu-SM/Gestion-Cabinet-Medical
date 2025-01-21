package gestion_ordonnance;

import java.util.List;

import gestion_de_fiche_patient.Patient;
import gestion_medecin.Docteur;

import java.time.LocalDate;

public class Ordonnance {
	
	private Docteur docteur;
	
	private Patient patient;

	private List<String> medicaments;
	
	private String instructions;
	
	private LocalDate dateDePrescription;
	

	public Ordonnance(Docteur docteur, Patient patient, List<String> medicaments, String instructions,
			LocalDate dateDePrescription) {
		
		this.docteur = docteur;
		
		this.patient = patient;
		
		this.medicaments = medicaments;
		
		this.instructions = instructions;
		
		this.dateDePrescription = dateDePrescription;
	}
	
	
	
	//ce constructeur est utilisé si nous voulons ajouter une ordonnance sans instructions :
	public Ordonnance(Docteur docteur, Patient patient, List<String> medicaments, LocalDate date) {
		
        this.docteur = docteur;
		
		this.patient = patient;
		
		this.medicaments = medicaments;
		
		this.dateDePrescription = date;
	}


	
	
	public String toString() {
		String abre;
		
		if(patient.getSexe() == 'F' || patient.getSexe() == 'f' ) {
			
			abre="Mme";
			
		}else {
			
			abre="M";
		}
		
		return "Docteur: "+docteur.getNom()+" "+docteur.getPrenom()+" Specialité: "+docteur.getSpecialite()
		+"\nPrescription Pour: "+abre+". "+patient.getNom()+" "+patient.getPrenom()+" "+patient.getAge() +"ans."
		+"\nDate de Prescription: "+dateDePrescription+"\nMedicaments: "+medicaments+"\nInstructions: "+instructions;
		
		
	}
	
	public void afficherOrdonnance() {
		System.out.println(this.toString());
	}
	
	

	//getters and setters :
	
	public Docteur getDocteur() {
		return docteur;
	}



	public void setDocteur(Docteur docteur) {
		this.docteur = docteur;
	}



	public Patient getPatient() {
		return patient;
	}



	public void setPatient(Patient patient) {
		this.patient = patient;
	}



	public List<String> getMedicaments() {
		return medicaments;
	}



	public void setMedicaments(List<String> medicaments) {
		this.medicaments = medicaments;
	}



	public String getInstructions() {
		return instructions;
	}



	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}



	public LocalDate getDateDePrescription() {
		return dateDePrescription;
	}



	public void setDateDePrescription(LocalDate dateDePrescription) {
		this.dateDePrescription = dateDePrescription;
	}
	
	
	
	
	
	

	
	
}
