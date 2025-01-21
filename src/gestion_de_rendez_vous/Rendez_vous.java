package gestion_de_rendez_vous;

import java.time.LocalDate;

import gestion_de_fiche_patient.Patient;
import gestion_medecin.Docteur;

import java.time.LocalTime;


public class Rendez_vous {
	
	private int ID;
	
    private Docteur docteur;
    
    private Patient patient;
    
    private LocalDate date;
    
    private LocalTime temp;
    

    
    public Rendez_vous(Docteur docteur, Patient patient, LocalDate date, LocalTime temp) {
        
        this.docteur = docteur;
        
        this.patient = patient;
        
        this.date = date;
        
        this.temp = temp;
    }
    public String display() {
        
        return "Rendez-Vous ID: "+ID+"\nDocteur: "+docteur.getNom()+" "+docteur.getPrenom()+" Specialité: "+docteur.getSpecialite()
        +"\nPatient: "+patient.getNom()+" "+patient.getPrenom()+" "+patient.getAge() +"ans."
        +"\nDate de rendez-vous: "+date+"\na l'heur: "+temp;
        
    }
    //getter and setter
    public void afficherRendezvous() {
        System.out.println(this.display());
    }
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
    
    
    
    public LocalDate getdate() {
        return date;
    }
    
    
    
    public void setdate(LocalDate date) {
        this.date = date;
    }
    
    
    public LocalTime gettemp() {
        return temp;
    }
    
    
    
    public void settemp(LocalTime temp) {
        this.temp=temp;
    }
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
    
}