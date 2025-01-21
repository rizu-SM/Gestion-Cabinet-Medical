package gestion_de_fiche_patient;

import gestion_de_person.*;

import java.time.LocalDate;

import java.time.format.DateTimeParseException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Patient_Management implements Management<Patient>  {

	  /* 
    Cette classe est une classe utilitaire pour la class Patient.
    Elle contient toutes les méthodes et structures nécessaires pour faciliter la gestion 
    et la manipulation de ces objets dans l'application principale (classe Main).
    Elle pourrait inclure des opérations comme l'ajout, la suppression, la mise à jour (édition) 
    ou la recherche des patients.
    */
	
	private ArrayList<Patient> patients;
	
	public Patient_Management() {
		patients = new ArrayList<Patient>();
	}

	public Scanner sc = new Scanner(System.in);
	
	
	//cette méthode createPatient est essentielle pour cree un patient  au dépend de user input:
	
	public Patient createPatient() { 
		
		String nom,prenom,numeroT,adresse,Sdate;
		
		int age;
		
		char sexe;
		
		boolean valid_date=false; /* ce variable est utilisé pour la vérification de la format 
		de la date de naissance entré par l'utilisateur si valid ou non */
		
		LocalDate dateN = null;
		
		System.out.println("Entrer Le Nom :");
		
		nom = sc.nextLine();
		
		System.out.println("Entrer Le Prenom :");
		
		prenom = sc.nextLine();
		
		System.out.println("Entrer L'Age :");
		
		while(true) {
			
		
	    try {
		
		age = sc.nextInt();
		
		if(age>0) {
			
			break;
		}else {
			System.out.println("Age invalide!");
		}
		
		}catch(InputMismatchException exception){
			
			System.out.println("Veuillez saisie un age valide!");
			
			sc.next();
			
		}
 
		}
		
		sc.nextLine(); //on consome le \n laissé par nextInt pour n'étre pas consumé par nextLine().
		
		do {
			
		System.out.println("Entrer Le Sexe (M\\F):");
		
		sexe = sc.nextLine().charAt(0);
		
		}while(sexe != 'M' && sexe !='F');
		
		System.out.println("Date de Naissance: ");
		
		while(valid_date == false) {
			
		Sdate = sc.nextLine();
		
		try {
			
		dateN = LocalDate.parse(Sdate);
		
		valid_date = true;
		
		} catch(DateTimeParseException e){
			
			System.out.println("Fromat de la date invalid!, Entrer la date sous la forme 'yyyy-mm-dd': ");
		}
		
		}
	    
		
		System.out.println("Numero Téléphone: ");
		
		numeroT = sc.nextLine();
		
		System.out.println("Adresse: ");
		
		adresse = sc.nextLine();
		
		Patient patient = new Patient(nom,prenom,numeroT,dateN,age,adresse,sexe,0);
		
		/* 
		 Quand on creé un patient , le ID sera étre 0 au debut et aprés on le ajoute dans la liste
		 des Patients , son ID sera automatiquement se mettre a son index dans la liste + 1 (voir la
		 méthode add(Patient patient), Le Patient ID nous aidons a savoir l'index des Patients actuellement 
			sauvgardé dans la Liste , ce qui facilite l'opperation de Modifier un Patient 
			OU Supprimer un Patient dans la Liste. 
		 */
		
		return patient;
		


	}
	
	
	public boolean recherchePatient(String nom) {
		
		boolean  found_aux_moins_1 = false;
		
		for(Patient patient : patients) {
			
			if(patient.getNom().equals(nom)) {
				
				patient.afficherPatient();
				
				found_aux_moins_1 = true;
				
			}
		}
		
		return found_aux_moins_1;
	}
	
	/*
	cette méthode afficherPatients est essentilles pour savoir les patients actuellement creé dans la 
	list des patients :
	*/
	
	public void afficherPatients() {
	
		for(int i=0; i<patients.size(); i++) {
			
			patients.get(i).afficherPatient();		

		}
	}
	
	
	@Override
	public void add(Patient patient) {
		
		patients.add(patient);
		
		patient.setID(patients.indexOf(patient) + 1);
	}

	@Override
	public void edit(int ID, Patient editedPatient) {
	    if(ID-1 >= patients.size() || ID-1<0) {
	    	System.out.println("\nError!, ID n'existe pas!.");
	    }else {
	    	patients.set(ID - 1, editedPatient);
	    	
	    	 /*
	    	 on fait index - 1 car l'affichage des IDS commence apartir de i + 1 , alors
	    	 quand l'utilisateur saise la valeur k , en réalité ce k la est égale a i + 1 , donc on fait
	    	 k - 1 (index - 1 ) 
	    	 */

	    }
	}

	@Override
	public void remove(int ID) {
		if(ID-1 >= patients.size() || ID-1 <0) {
	    	System.out.println("\nError!, ID n'existe pas!.");
	    	
		}else {
			
			/*
			 Quand on supprime un patient dans la liste , on aura un problem de Patients ID car
			 il sera étre un décalage des Patients mais le ID sera étre le meme que précédent
			 
			 EXAMPLE :
			 
			    index 0         index 1      index 2
			 PATIENT ID 1    PATIENT ID 2  PATIENT ID 3
			 
			 si on supprime le Patient ID 2 --> patient.remove(ID-1) 
			 
			 sans faire la modification du Patient ID il sera :
			 
			  index 0          index 1      
			 PATIENT ID 1    PATIENT ID 3  
			 
			 ce qui est faux!
		
			 
			 Si on remarque que le déclage sera fait juste pour les Patients qui sont supérieure
			 a le Patient qui a été supprimer , alors on fait un parcour de patient ID vers la fin
			 et chaque id sera étre décaler par 1.
			 */
			for(int i=ID; i<patients.size(); i++) {
				
				patients.get(i).setID(i);
		
			}
			patients.remove(ID -1);
		}
	}


	
	//Getters & Setters :
	
public ArrayList<Patient> getPatients() {
	return patients;
}

public void setPatients(ArrayList<Patient> patients) {
	this.patients = patients;
	
}
}