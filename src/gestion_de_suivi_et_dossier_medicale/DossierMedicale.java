package gestion_de_suivi_et_dossier_medicale;

import java.util.ArrayList;

import gestion_de_fiche_patient.*;

import gestion_medecin.*;

public class DossierMedicale {
	
	private Patient patient;
	
	private Docteur docteur;
		
	private ArrayList<SuiviMedicale> Suivi_de_Patient;

	
	
	public DossierMedicale (Patient patient , Docteur docteur) {
				
	    this.Suivi_de_Patient = new ArrayList<SuiviMedicale>();
	    
	    this.patient = patient;
	    
	    this.docteur = docteur;
		
	}
	
	
	
	
		
	public void affichierDossierMedicale() {
		
		System.out.println("------------------------------------------------------------------------\n");
		
		System.out.println("DOSSIER MEDICALE DE PATIENT: "+patient.getNom()+" "+patient.getPrenom()+" ID: "+patient.getID()+"\n"
				+ "Suivi par: Dr."+docteur.getNom()+" "+docteur.getPrenom()+"\n");
		
		for(SuiviMedicale Suivi : Suivi_de_Patient) {
			
			System.out.println(Suivi.afficherSuiviMedicale());
			System.out.print("\n");
		    
		}
		
		System.out.println("------------------------------------------------------------------------");

		
	}



	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Docteur getDocteur() {
		return docteur;
	}

	public void setDocteur(Docteur docteur) {
		this.docteur = docteur;
	}


	public ArrayList<SuiviMedicale> getSuivi_de_Patient() {
		return Suivi_de_Patient;
	}

	public void setSuivi_de_Patient(ArrayList<SuiviMedicale> suivi_de_Patient) {
		Suivi_de_Patient = suivi_de_Patient;
	}
	
	
	
	
		

}
