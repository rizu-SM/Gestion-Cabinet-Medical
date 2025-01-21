package gestion_medecin;

import java.util.ArrayList;

import java.util.Scanner;

import gestion_de_person.Management;


public class Docteur_Management implements Management<Docteur> {
	
	
	private ArrayList<Docteur> docteurs;
	
	public Docteur_Management() {
		
		docteurs = new ArrayList<Docteur>();
		
	}
	
	public Scanner sc2 = new Scanner(System.in);
	
	
	public Docteur createDocteur() {
		
		String nom,prenom,numeroT,specialite,password,confirmer;
		
		System.out.println("Entrer le Nom du Docteur: ");
		
		nom = sc2.nextLine();
		
		System.out.println("Entrer le Prenom: ");
		
		prenom = sc2.nextLine();
		
		System.out.println("Entrer Numéro de Télephone: ");
		
		numeroT = sc2.nextLine();
		
		System.out.println("Entrer la Specialté du Docteur: ");
		
		specialite = sc2.nextLine();
		
		while(true) {
			
		System.out.println("Creé un mot de passe: ");
		
		password = sc2.nextLine();
		
		System.out.println("Mote de passe: \""+password+"\" Confirmer?");
		
		System.out.print("\nEntrer (Oui - Non): ");
		
        confirmer = sc2.nextLine().trim().toLowerCase();
        
        if (confirmer.equals("oui")) {
        	
            break;
            
        } else {
        	
        	if(!confirmer.equals("non")) {
        		
        	  System.out.println("Réponse invalide!.");
        	  
        	}
            
        }

		}
		
		Docteur docteur = new Docteur(nom,prenom,numeroT,specialite,0,password);
		
		
		/* 
		 Quand on creé un docteur  , le ID sera étre 0 au debut et aprés on le ajoute dans la liste
		 des docteurs , son ID sera automatiquement se mettre a son index dans la liste + 1 (voir la
		 méthode add(Docteur docteur), Le Docteur ID nous aidons a savoir l'index des Docteurs actuellement 
			sauvgardé dans la Liste , ce qui facilite l'opperation de Modifier un Docteur 
			OU Supprimer un Docteur dans la Liste. 
		 */
		
		return docteur;
		
	}
	
	
	public void afficherDocteurs() {
		
	
		for(int i=0; i<docteurs.size(); i++) {
			
	        /* Le Docteur ID  nous aidons a savoir l'index
			des Docteurs actuellement sauvgardé dans la Liste , ce qui facilite l'opperation de Modifier un Docteur 
			OU Supprimer un Docteur dans la Liste. */
			
			docteurs.get(i).afficherDocteur();
	}
		
	}
	@Override
	public void add(Docteur docteur) {
		
		docteurs.add(docteur);
		docteur.setID(docteurs.indexOf(docteur) + 1);
		
	}


	@Override
	public void edit(int ID, Docteur docteur) {
		
		if(ID - 1>= docteurs.size() || ID - 1<0) {
			
	    	System.out.println("\nError!, ID n'existe pas!.");

		}else {
			docteurs.set(ID - 1, docteur);
			
			
			 /*
			 on fait index - 1 car l'affichage des indexes commence apartir de i + 1 , alors
	    	 quand l'utilisateur saise la valeur k , en réalité ce k la est égale a i + 1 , 
	    	 donc on fait k - 1 (index - 1 )
	    	 */

		}
		
	}

	@Override
	public void remove(int ID) {
	
if(ID - 1>= docteurs.size() || ID - 1<0) {
			
	    	System.out.println("\nError!, ID n'existe pas!");

		}else {
			
          for(int i=ID; i<docteurs.size(); i++) {
				
				docteurs.get(i).setID(i);
		
			}
          
			docteurs.remove(ID - 1);
		}
	}

//getters & setters :
	
	public ArrayList<Docteur> getDocteurs() {
		return docteurs;
	}

	public void setDocteurs(ArrayList<Docteur> docteurs) {
		this.docteurs = docteurs;
	}

	
	
}



