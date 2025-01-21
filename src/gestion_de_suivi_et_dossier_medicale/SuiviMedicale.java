package gestion_de_suivi_et_dossier_medicale;

import gestion_de_fiche_patient.*;
import gestion_ordonnance.Ordonnance;

import java.time.LocalDate;

import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class SuiviMedicale {
	
	private LocalDate date;
	
	private LocalTime temp;
	
	private Patient patient;
	
	private Ordonnance ordonnance;
	
	private double poids,taille;
	
	private String observationMedicale;
	
	private String resumeDeTraitement;

	
	
	public SuiviMedicale (Patient patient,Ordonnance ordonnance,double poids, double taille,String Observation, String Resume){
	
		this.date = LocalDate.now(); //la date sera saise automatiquement.
		
		this.temp = LocalTime.now(); // le temp aussi.
		
		this.patient = patient;
		
		this.ordonnance = ordonnance;
		
		this.poids = poids;
		
		this.taille = taille;
		
		this.observationMedicale = Observation;
		
		this.resumeDeTraitement = Resume;
		
	
	}
	
	public String afficherSuiviMedicale() {
		
		
        LocalDate currentDate = LocalDate.now();
        
        // Calculate the period between the birthdate and the current date
        Period period = Period.between(patient.getDateN(), currentDate);
        
        // Get the age in years
        int age = period.getYears();
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		
        String formattedTime = temp.format(formatter);
        
		return "[ DATE: "+date+" HEURE: "+formattedTime+" ]: "+"\n\nDonnées Anthropométriques et Démographique: "+"\nAge: "+age+"\tSexe: "+patient.getSexe()+"\tPoids: "+poids+"Kg"+"\tTaille: "+taille+"cm"+"\n\nOrdonnance Prescrite: \n"+ordonnance.toString()+"\n\n"
				+ "Observation Médicale: "+observationMedicale+"\n\nResumé de Triatement: "+ resumeDeTraitement;
	}
	 
		
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTemp() {
		return temp;
	}

	public void setTemp(LocalTime temp) {
		this.temp = temp;
	}

	public Ordonnance getOrdonnance() {
		return ordonnance;
	}

	public void setOrdonnance(Ordonnance ordonnance) {
		this.ordonnance = ordonnance;
	}

	public String getObservationMedicale() {
		return observationMedicale;
	}

	public void setObservationMedicale(String observationMedicale) {
		this.observationMedicale = observationMedicale;
	}

	public String getResumeDeTraitment() {
		return resumeDeTraitement;
	}

	public void setResumeDeTraitment(String resumeDeTraitment) {
		this.resumeDeTraitement = resumeDeTraitment;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(float taille) {
		this.taille = taille;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
	
	
	

}
