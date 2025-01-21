package gestion_ordonnance;

import gestion_de_person.*;
import gestion_medecin.Docteur;

import java.time.LocalDate;

import java.time.format.DateTimeParseException;

import java.util.ArrayList;

import java.util.Scanner;

import gestion_de_fiche_patient.Patient;

import java.util.InputMismatchException;


public class Ordonnance_Management implements Management<Ordonnance>{

	  /* 
  Cette classe est une classe utilitaire pour la class Ordonnance.
  Elle contient toutes les méthodes et structures nécessaires pour faciliter la gestion 
  et la manipulation de ces objets dans l'application principale (classe Main).
  Elle pourrait inclure des opérations comme l'ajout, la suppression, la mise à jour (édition) 
  ou la recherche des ordonnances.
  */
	
     private ArrayList<Ordonnance> ordonnances;  
     
     public Ordonnance_Management() {
    	 
    	 ordonnances = new ArrayList<Ordonnance>();
    	 
     }
     
     public Scanner sc1 = new Scanner(System.in);
     
 	//cette méthode createOrdonnance est essentielle pour cree un patient  au dépend de user input:

     public Ordonnance createOrdonnance(Docteur docteur, Patient patient) {
    	 
         String SPdate;
         
         LocalDate Pdate=null;
                  
         boolean valid_date=false;  /* ce variable est utilisé pour la vérification de la format 
 		de la date de naissance entré par l'utilisateur si valid ou non */
         
         boolean valid_input=false;  /* ce variable est utilisé pour la vérification de type de valeur
 		entré par l'utilisateur si valid ou non */
     
    	System.out.println("Date de Pescritption: ");
    	
    	while(valid_date == false) {
    		
    	SPdate = sc1.nextLine();
    	
    	try {
			
    		Pdate = LocalDate.parse(SPdate);
    		
    		valid_date = true;
    		
    		} catch(DateTimeParseException exception){
    			
    			System.out.println("Fromat de la date invalid!, Entrer la date sous la forme 'yyyy-mm-dd': ");
    		}
    	}
    
    	System.out.println("Entrez le nombre de médicaments à prescrire: ");
    	
        int n = -1;
    	
    	while(valid_input==false && n<0) { /*si la valeur entré est de différente type , il se boucle jusqu'a la 
    	valeur entré est un entier positive.*/
          try {
          	
        	  n = sc1.nextInt();
        	  
        	  if(n>=0) {
        		  
              valid_input=true;
              
        	  }else {
        		  
            	  System.out.println("Erreur! : Veuillez entrer un nombre entier positive valide.");

        	  }
          }catch(InputMismatchException exception) {
        	  
        	  System.out.println("Erreur! : Veuillez entrer un nombre entier positive valide.");
        	  
        	  sc1.next();
          }
    	}
    	
		sc1.nextLine(); //on consome le \n laissé par nextInt pour n'étre pas consumé par nextLine().

    	ArrayList<String> medicaments = new ArrayList<String>();
    	
    	String medic;
    	
    	for(int i=0; i<n; i++) {
    		System.out.println("Medicament n°"+(i+1)+": ");
    		
    		medic = sc1.nextLine();
    		
    		medicaments.add(medic);
    		
    	}
    	
    	
    	System.out.println("Instructions :");
    	
    	medic = sc1.nextLine();  
    	
    	 Ordonnance ordonnance = new Ordonnance(docteur, patient, medicaments,medic, Pdate);
    	 
    	 return ordonnance;
     }
     
     
     public boolean rechercheOrdonnance(String nom) {
 		
 		boolean  found_aux_moins_1 = false;
 		
 		for(Ordonnance ordonnance : ordonnances) {
 			
 			if(ordonnance.getPatient().getNom().equals(nom)) {
 				
 			   ordonnance.afficherOrdonnance();
 				
 				found_aux_moins_1 = true;
 				
 			}
 		}
 		
 		return found_aux_moins_1;
 	}
     
     public void afficherOrdonnances() {
    		
 		for(int i=0; i<ordonnances.size(); i++) {
 			
 			System.out.println("\nOrdonnance index "+ i + 1 +" :"); /* on affiche index + 1 pour commencer
 			 a partir d' Ordonnance index 1 au lieu de index 0 */
 			
 		    /* L'Ordonnance Index nous aidons a savoir l'index
 			des Ordonnances actuellement sauvgardé dans la Liste,
 			ce qui facilite l'opperation de Modifier une Ordonnance 
 			OU Supprimer une Ordonnance dans la Liste. */
 			
 			ordonnances.get(i).afficherOrdonnance();		

 		}
 	}
     
    

     
	@Override
	public void add(Ordonnance o) {
		ordonnances.add(o);
	}

	@Override
	public void edit(int index, Ordonnance o) {
		if(index-1>= ordonnances.size() || index-1<0) {
			System.out.println("\nError!, index hors limites.");
		}else {
	    	ordonnances.set(index-1, o);
	    	
	    	/*
	    	 on fait index - 1 car l'affichage des indexes commence apartir de i + 1 , alors
	    	 quand l'utilisateur saise la valeur k , en réalité ce k la est égale a i + 1 , donc on fait
	    	 k - 1 (index - 1 ) 
	    	 */

		}
		
	}

	@Override
	public void remove(int index) {
		if(index-1>= ordonnances.size() || index-1<0) {
			System.out.println("\nError!, index hors limites.");
		}else {
	    	ordonnances.remove(index-1);

		}
		
	}


     
//Geters & Setters :
	

public ArrayList<Ordonnance> getOrdonnances() {
	return ordonnances;
}

public void setOrdonnances(ArrayList<Ordonnance> ordonnances) {
	this.ordonnances = ordonnances;

}
}
