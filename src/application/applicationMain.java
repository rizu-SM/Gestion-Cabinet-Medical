package application;

import gestion_de_rendez_vous.*;

import gestion_medecin.Docteur;

import gestion_medecin.Docteur_Management;

import gestion_medecin.GestionDocteur;
import gestion_ordonnance.GestionOrdo;
import gestion_ordonnance.Ordonnance_Management;

import java.util.InputMismatchException;

import java.util.Scanner;

import gestion_de_fiche_patient.*;

import gestion_de_suivi_et_dossier_medicale.*;

public class applicationMain {
	
	private static String mot_de_pass="admin";

	public static void main(String[] args) {
		
		
		
    Patient_Management patientManager = new Patient_Management();
		   
    Docteur_Management doctorManager = new Docteur_Management();
	        
    Ordonnance_Management ordonnanceManager = new Ordonnance_Management();
	        
    DossierManagement DossierManager = new DossierManagement();
    
    Rendez_vous_Management RvManager = new Rendez_vous_Management();
    
    
    Scanner sc5 = new Scanner(System.in);
   
    
    MenuPrincipale(sc5,doctorManager,ordonnanceManager,patientManager,RvManager,DossierManager);
    
    
    
	}
	        
	        
	        public static int ChoixMenu(int choix, int min , int max, Scanner sc5) {
				
				int input;
				
				while(choix<min || choix>max) {
					
					System.out.println("Le choix saisi n'existe pas ! Veuillez choisir parmi les options du menu.");
					System.out.print("\nEntrer: ");
					
					try {
						
						input = sc5.nextInt();
						
						if(input >=min && input <= max) {
							
							choix = input;
						}
						
					}catch(InputMismatchException exception) {
						
						System.out.println("Erreur ! Veuillez saisir un entier parmi les options du menu !");
						
						sc5.next();
						
					}
					
				}
				return choix;
			}
			
			
			public static void MenuPrincipale(Scanner sc5,Docteur_Management DM,Ordonnance_Management OM,Patient_Management PM,Rendez_vous_Management RV
					,DossierManagement DSM) {
				
				boolean onMP=true;
				
				int input = 0;
				
				while(onMP == true) {
					
					while(true) {
					
					System.out.println("**GESTION CABINET MEDICALE**\n");
					
					System.out.println("1:Espace Médecin\t    2:Espace Admin\t   3:Quitter");
					
					System.out.print("\nEntrer: ");
					
					try {
						
						input=sc5.nextInt();
						
                         break;
                         
					}catch(InputMismatchException exception) {
						
						System.out.println("Erreur ! Veuillez saisir un entier parmi les options du menu !");
						
					}
					}
					
					
					input = applicationMain.ChoixMenu(input,1,3,sc5);
				
				switch(input) {

				case 1: Espace_Medecin(DM,PM,OM,DSM,RV,sc5);
				
				break;
				 
				
				case 2: Espace_Admin(sc5,DM);
				
		                break;
					
				case 3: onMP = false;
				
					break;
				}
				
				}
			}
				
			
			
			public static void Espace_Admin(Scanner sc5,Docteur_Management DM) {
				
				boolean on = true;
				
				
					
				String input;
				
				input = sc5.nextLine();
				
				do {

				System.out.println("*ESPACE ADMIN*");
				
				if(mot_de_pass.equals("admin")) {
					
					System.out.println("Nouvelle Utilisation Détecté! : le mot de pass est: "+mot_de_pass+"\nVeuillez le changer aprés!.");
					
				}
				
				System.out.print("\nSaise le mot de pass : ");
				
				input = sc5.nextLine();
				
				if(mot_de_pass.equals(input) == false) {
					
					System.out.println("Mot de pass INVALIDE!");
				}
				
				}while(mot_de_pass.equals(input) == false);
				
				System.out.println("Bienvenue!\n");
				
				
				while(on == true) {
					
					System.out.println("*ESPACE ADMIN*\n");
					
				System.out.println("1:Créer un nouveau profil de médecin\t2:Supprimer un profil de médecin"
						+ "\t3:Changer le mot de pass\t4:Retour");
				
				
				int input1;
				
				while(true) {
					
				System.out.println("Entrer: ");
				
			    try {
			    	
			    	input1 = sc5.nextInt();
			    	
			    	break;
			    	
			    }catch(InputMismatchException exception) {
			    	
					System.out.println("Erreur ! Veuillez saisir un entier parmi les options du menu !");
					
					sc5.next();
					
			    }
				}
				
				input1 = ChoixMenu(input1,1,4,sc5);
				
				switch(input1) {
				
				case 1: 
					      Docteur doc = DM.createDocteur();
					      DM.add(doc);
				System.out.println("*Le Profile du Médecin "+doc.getNom()+" "+doc.getPrenom()+" a été créer avec succès!*\n");
				        break;
					
				case 2: GestionDocteur.Supprimer_Medecin(DM,sc5);
				       break;
					
				case 3: 
					String password,confirmer;
					
				       confirmer = sc5.nextLine(); //on a fait ça juste pour consumer le charactére "ENTER".

					
				while(true) {
					
					System.out.print("\nEntrer le nouveau mot de pass: ");
										
					password = sc5.nextLine();
					
					System.out.println("Mote de passe: \""+password+"\" Confirmer?");
					
					System.out.print("\nEntrer (Oui - Non): ");
					
			        confirmer = sc5.nextLine().trim().toLowerCase();
			        
			        if (confirmer.equals("oui")) {
			        	
			            break;
			            
			        } else {
			        	
			        	if(!confirmer.equals("non")) {
			        		
			        	  System.out.println("Réponse invalide!.");
			        	  
			        	}
			            
			        }

					}
				
				mot_de_pass = password;
				
				System.out.println("Mot de pass a été changé avec scuccès!\n");
				
				break;
					
				
				case 4: on=false;
				        break;
					
				}
	        
		
			}
			}
		
			



			public static void Espace_Medecin(Docteur_Management DM, Patient_Management PM, Ordonnance_Management OM, 
					DossierManagement DSM,Rendez_vous_Management RV, Scanner sc5) {
				
				
				System.out.println("Vous étes qui?");
				
				int input4;
				
				boolean on4 = true;
				
				while(on4 == true) {

				while(true) {
					
					
				System.out.println("1:Entrer votre ID directement\t2:Afficher la liste des Médcins avec ID puis entrer\t"
						+ "3:Retour");
				
				System.out.print("\nEntrer: ");
								
				try {
					
					input4=sc5.nextInt();
					
					break;
					
				}catch(InputMismatchException exception) {
					
					System.out.println("Erreur ! Veuillez saisir un entier parmi les options du menu !");
					
				}
				}
				
				input4 = ChoixMenu(input4,1,3,sc5);
				
				if(input4 == 3) {
					
					on4 = false;
					break;
					
				}else {
					
				if(input4 == 2) {
					
					if(DM.getDocteurs().size() <= 0) {
						
						System.out.println("La liste des Docteurs est vide!");
					}
					
					DM.afficherDocteurs();
				}
				
				int ID;
				
				while(true) {
					
				System.out.println("Entrer ID (Entrer -1 Pour Retour):  ");
								
				try {
					
					ID = sc5.nextInt();
					
					if(ID == -1) {
						break;
					}
					if((ID-1)>=0 && (ID-1)<DM.getDocteurs().size()) {
						
					 break;
					}else {
						System.out.println("Veuillez entrer un ID valide!");
					}
					
				}catch(InputMismatchException exception) {
					
					System.out.println("Veuillez entrer un ID valide!");
					
					sc5.nextLine();
					
				}
				
			}
				if(ID == -1) {
					
					break;
					
				}
				Docteur docteur;
				
				docteur = DM.getDocteurs().get(ID-1);
				
				String pass;
				
				boolean passed=false;
				
		        pass = sc5.nextLine();
				
				while(true) {
					
					System.out.print("\nEntrer le mot de pass de Dr."+docteur.getNom()+" "+docteur.getPrenom()+": ");
					
					pass = sc5.nextLine();
					
					if(pass.equals(docteur.getPassword())) {
						
						passed = true;
						
						break;
					}else {
						if(pass.equals("-1")) {
							break;
						}else {
							
							System.out.println("Mot de pass incorrect!");
						}
					}
					
				}
							
				if(passed == true) {
					
				
				boolean on = true;
				
				while(on == true) {
					
					System.out.println("\nBienvenue Dr."+docteur.getNom()+" "+docteur.getPrenom());
					
				System.out.println("1:Gestion des fiches des patients\t2:Gestion des Rendez-Vous\t3:"
						+ "Gestion des Ordonnances\t4:Gestion des Dossier Médicales\t5:Retour");
				
				int input5;
				
				while(true) {
					
					System.out.print("\nEntrer: ");
									
					try {
						
						input5=sc5.nextInt();
						
						break;
						
					}catch(InputMismatchException exception) {
						
						System.out.println("Erreur ! Veuillez saisir un entier parmi les options du menu !");
						
						sc5.next();
						
					}
					}
					
					input5 = ChoixMenu(input5,1,5,sc5);
					
					switch (input5) {
					
					case 1: GestionPatient.Gestion_Patients(PM,sc5);
					        break;
						
					case 2: GestionRV.Gestion_RendezVous(docteur,PM,RV,sc5);
					        break;
						
					case 3: GestionOrdo.ModifierOrdonnance(docteur, OM, PM, sc5);
					        break;
						
					case 4: GestionDossier.Gestion_Dossier(docteur, PM, DSM, OM, sc5);
						    break;
						
					case 5: on = false;
					       break;
					}
				
				}
				}
				
				}
				
				
			}
			}
			
			
	}