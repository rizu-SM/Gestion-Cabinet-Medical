package gestion_de_rendez_vous;

import gestion_de_person.*;
import gestion_medecin.Docteur;

import java.time.LocalDate;

import java.time.format.DateTimeParseException;

import gestion_de_fiche_patient.Patient;

import java.util.ArrayList;

import java.util.Scanner;

import java.time.LocalTime;

import java.time.format.DateTimeFormatter;

public class Rendez_vous_Management implements Management<Rendez_vous> {

    /* 
    Cette classe est une classe utilitaire pour la gestion des objets Rendez_vous.
    Elle fournit les méthodes nécessaires pour ajouter, modifier, supprimer et afficher
    les rendez-vous dans le système principal (classe Main).
    */

    private ArrayList<Rendez_vous> rendezVousList;

    public Rendez_vous_Management() {
        rendezVousList = new ArrayList<>();
    }

    private Scanner sc3 = new Scanner(System.in);

    // Créer un rendez-vous basé sur l'entrée utilisateur
    public Rendez_vous createRendezvous(Docteur docteur, Patient patient) {
        String date;
        
        String Stemp;
        
        LocalTime temp=null;
        
        LocalDate Pdate=null;
        
        boolean validedate=false; /* ce variable est utilisé pour la vérification de la format 
 		de la date de rendez-vous entré par l'utilisateur si valid ou non */

        System.out.println("Entrez la date du rendez-vous (yyyy-mm-dd) : ");
        while(validedate == false) {
    		
        	date = sc3.nextLine();
        	
        	try {
    			
        		Pdate = LocalDate.parse(date);
        		
        		validedate = true;
        		
        		} catch(DateTimeParseException exception){
        			
        			System.out.println("Fromat de la date invalid!, Entrer la date sous la forme 'yyyy-mm-dd': ");
        		}
        	}

        System.out.println("Entrez l'heure du rendez-vous (hh:mm) : ");
        
        Stemp = sc3.nextLine();
        
        DateTimeFormatter paramétre = DateTimeFormatter.ofPattern("HH:mm");
        
        try {
        	temp = LocalTime.parse(Stemp,paramétre);
        	
        } catch(Exception faux) {
        	
        	System.out.println("Format de temp est invalide!, Entrer le Temp sous la fomre 'HH:mm':");
        }

        return new Rendez_vous(docteur, patient, Pdate, temp);
    }

    
public boolean rechercheRV(String nom) {
		
		boolean  found_aux_moins_1 = false;
		
		for(Rendez_vous rv : rendezVousList) {
			
			if(rv.getPatient().getNom().equals(nom)) {
				
				rv.afficherRendezvous();
				
				found_aux_moins_1 = true;
				
			}
		}
		
		return found_aux_moins_1;
	}

    // Afficher tous les rendez-vous
    public void afficherRendezvous() {
    	
        for (int i = 0; i < rendezVousList.size(); i++) {
        	
            System.out.println("\nRendez-vous index " + (i + 1) + " :");
            
            rendezVousList.get(i).afficherRendezvous();
        }
    }

    @Override
    public void add(Rendez_vous rv) {
    	
        rendezVousList.add(rv);
        
		rv.setID(rendezVousList.indexOf(rv) + 1);

        
    }

    @Override
    public void edit(int index, Rendez_vous rv) {
    	
        if (index - 1 >= rendezVousList.size() || index - 1 < 0) {
        	
            System.out.println("\nErreur ! Index hors limites.");
            
        } else {
        	
            rendezVousList.set(index - 1, rv);
            /*
             L'index est décrémenté de 1 car l'affichage commence à partir de 1 pour une meilleure lisibilité.
             */
        }
    }

    @Override
    public void remove(int index) {
    	
        if (index - 1 >= rendezVousList.size() || index - 1 < 0) {
        	
            System.out.println("\nErreur ! Index hors limites.");
            
        } else {
        	
            rendezVousList.remove(index - 1);
        }
    }

    // Getters et Setters
    public ArrayList<Rendez_vous> getRendezVousList() {
    	
        return rendezVousList;
        
    }

    public void setRendezVousList(ArrayList<Rendez_vous> rendezVousList) {
    	
        this.rendezVousList = rendezVousList;
        
    }
}

