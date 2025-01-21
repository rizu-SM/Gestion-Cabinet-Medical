package gestion_medecin;

import java.util.InputMismatchException;

import application.*;

import java.util.Scanner;

public class GestionDocteur {
	
	
	
	public static void Supprimer_Medecin(Docteur_Management DM,Scanner sc5) {
		
		boolean on3 = true;
		
		while(on3 == true) {
		
		System.out.println("1:Afficher la liste des Médcins avec ID Puis Supprimer\t    2: Supprimer directement par ID\t     3: Retour");
		
		int input3;
		
		while(true) {
			
			System.out.println("Entrer: ");
			
		    try {
		    	
		    	input3 = sc5.nextInt();
		    	
		    	break;
		    	
		    }catch(InputMismatchException exception) {
		    	
				System.out.println("Erreur ! Veuillez saisir un entier parmi les options du menu !");
				
				sc5.next();
				
		    }
			}
		
		input3 = applicationMain.ChoixMenu(input3,1,3,sc5);
		
		
		switch(input3) {
		
		case 1: if(DM.getDocteurs().size() <= 0) {
			
			System.out.println("Pas de Profiles de Docteurs!");
			
			break;
			
	}else {
	
	   DM.afficherDocteurs();
	
	 int ID;
	 
	 while(true) {
		 
		 System.out.print("\nEntrer ID :");
		 
		 try {
			 
			 ID = sc5.nextInt();
			 
		     break;	 
		     
		 }catch(InputMismatchException exception) {
			 
			 System.out.println("ID invalide!\n");
			 sc5.nextLine();
		 }
	 }
	 
	 DM.remove(ID);
	

	
	}
		case 2:
			
			int ID;
			 
			 while(true) {
				 
				 System.out.print("\nEntrer ID (Entrer -1 pour Retour) :");
				 
				 try {
					 
					 ID = sc5.nextInt();
					 
				     break;	 
				     
				 }catch(InputMismatchException exception) {
					 
					 System.out.println("ID invalide!\n");
					 sc5.nextLine();
				 }
			 }
			 
			 DM.remove(ID);
			 
			 break;
			 
			 
		case 3: on3 = false;
		
		        break;
			 
			
			
		}
		}

		
	}

}
