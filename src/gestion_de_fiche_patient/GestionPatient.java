package gestion_de_fiche_patient;

import java.util.InputMismatchException;

import java.util.Scanner;

import application.*;

public class GestionPatient {

	
	
	public static void ModifierPatient(Patient_Management PM, Scanner sc5) {
		
		
		boolean onMP = true;
		
		int input7 = 0;
		
		while(onMP == true) {
			
			while(true) {
		System.out.println("1:Rechercher le patient par son NOM, Puis le séléctionner par ID pour modifier\t   "
				+ " 2:Séléctionner directement par ID pour modifier\t      3:Retour");
		
					
		System.out.print("\nEntrer: ");
		
		try {
			
			input7=sc5.nextInt();
			
			break;
			
		}catch(InputMismatchException exception) {
			
			System.out.println("Erreur ! Veuillez saisir un entier parmi les options du menu !");
			
			sc5.next();
			
		}
		}
		
		input7 = applicationMain.ChoixMenu(input7,1,3,sc5);
		
		switch (input7) {
		
		case 1:
			
			String nomP;
			
			nomP = sc5.nextLine(); //absorbé le ENTER
			
			System.out.print("\nEntrer le nom du patient: ");
			
			nomP = sc5.nextLine();
			
			if(PM.recherchePatient(nomP) == false) {
				
				System.out.println("Le patient avec nom "+nomP+" n'existe pas!");
				
				break;
			}else {
										
				int ID;
				
				while(true) {
					
					System.out.println("\nSéléctioner par ID: ");
									
					try {
						
						ID = sc5.nextInt();
						
						if((ID-1)>=0 && (ID-1)<PM.getPatients().size()) {
							
						 break;
						}else {
							System.out.println("Veuillez entrer un ID valide!");
						}
						
					}catch(InputMismatchException exception) {
						
						System.out.println("Veuillez entrer un ID valide!");
						
						sc5.nextLine();
						
					}
					
				}
					Patient patient;
					
					System.out.println("**PATIENT "+PM.getPatients().get(ID-1).getNom()+" "+PM.getPatients().get(ID-1).getPrenom()+" ID: "+ID+" MODIFICATION **\n");
					
					patient = PM.createPatient();
					
					PM.edit(ID, patient);
					
					System.out.println("Le Patient a été modifier avec succès!");
					
					break;
						
				
			}
			
			
			
		case 2:
			
			if(PM.getPatients().size()<=0) {
				
				System.out.println("La liste des fiches des patients est vide");
				break;
			}else {
				
			
			int ID;
			
			while(true) {
				
				System.out.println("\nSéléctioner par ID: ");
								
				try {
					
					ID = sc5.nextInt();
					
					if((ID-1)>=0 && (ID-1)<PM.getPatients().size()) {
						
					 break;
					}else {
						System.out.println("Veuillez entrer un ID valide!");
					}
					
				}catch(InputMismatchException exception) {
					
					System.out.println("Veuillez entrer un ID valide!");
					
					sc5.nextLine();
					
				}
				
			}
				Patient patient;
				
				System.out.println("**PATIENT"+PM.getPatients().get(ID-1).getNom()+" "+PM.getPatients().get(ID-1).getPrenom()+" ID: "+ID+" MODIFICATION **\n");
				
				patient = PM.createPatient();
				
				PM.edit(ID, patient);
				
				System.out.println("Le Patient a été modifier avec succès!");
				
				break;
				
			}
			
		case 3: onMP = false;
                break;
		
		
			}
		}
		
		
	}

	
	
	
	public static void SupprimerPatient(Patient_Management PM, Scanner sc5) {
		

		boolean onSP = true;
		
		while(onSP == true) {
		
			System.out.println("1:Rechercher le patient par son NOM, Puis le séléctionner par ID pour supprimer\t   "
					+ " 2:Séléctionner directement par ID pour supprimer\t      3:Retour");
							
		int input9;
		
		while(true) {
			
			System.out.println("Entrer: ");
			
		    try {
		    	
		    	input9 = sc5.nextInt();
		    	
		    	break;
		    	
		    }catch(InputMismatchException exception) {
		    	
				System.out.println("Erreur ! Veuillez saisir un entier parmi les options du menu !");
				
				sc5.next();
				
		    }
			}
		
		input9 = applicationMain.ChoixMenu(input9,1,3,sc5);
		
		
		switch(input9) {
		
		case 1:	
			
            String nomP;
            
			nomP = sc5.nextLine(); //absorbé le ENTER
			
			System.out.print("\nEntrer le nom du patient: ");
			
			nomP = sc5.nextLine();
			
			if(PM.recherchePatient(nomP) == false) {
				
				System.out.println("Le patient avec nom "+nomP+" n'existe pas!");
				
				break;
			}else {
										
				int ID;
				
				while(true) {
					
					System.out.println("\nSéléctioner par ID: ");
									
					try {
						
						ID = sc5.nextInt();
						
						if((ID-1)>=0 && (ID-1)<PM.getPatients().size()) {
							
						 break;
						}else {
							System.out.println("Veuillez entrer un ID valide!");
						}
						
					}catch(InputMismatchException exception) {
						
						System.out.println("Veuillez entrer un ID valide!");
						
						sc5.nextLine();
						
					}
					
				}						
				
				
				    String confirmer;
					
				    while(true) {
				    	
				    
					System.out.println("Confirmer la suppression de fiche de Patient "+PM.getPatients().get(ID-1).getNom()
					  +" "+PM.getPatients().get(ID-1).getPrenom()+" ?");
					
					System.out.print("\nEntrer (Oui - Non): ");
					
			        confirmer = sc5.nextLine().trim().toLowerCase();
			        
			        if (confirmer.equals("oui")) {
			        	
			        	System.out.println("Le Patient a été supprrimer avec succès!");
			        	
						PM.remove(ID);

			            break;
			            
			        } else {
			        	
			        	if(!confirmer.equals("non")) {
			        		
			        	  System.out.println("Réponse invalide!.");
			        	  
			        	}else {
			        		break;
			        	}
			            
			        }
			        
				    }
				    
				    break;

					
				
				
			}
			
			
		
		case 2:
			
			int ID;
			
			while(true) {
				
				System.out.println("\nSéléctioner par ID (Entrer -1 pour Retour): ");
								
				try {
					
					ID = sc5.nextInt();
					
					if(ID == -1) {
						break;
					}
					
					if((ID-1)>=0 && (ID-1)<PM.getPatients().size()) {
						
					 break;
					}else {
						System.out.println("Veuillez entrer un ID valide!");
					}
					
				}catch(InputMismatchException exception) {
					
					System.out.println("Veuillez entrer un ID valide!");
					
					sc5.nextLine();
					
				}
				
			}		
			
			if(ID != -1) {
			  String confirmer;
				
			    while(true) {
			    	
			    
				System.out.println("Confirmer la suppression de fiche de Patient "+PM.getPatients().get(ID-1).getNom()
				  +" "+PM.getPatients().get(ID-1).getPrenom()+" ?");
				
				System.out.print("\nEntrer (Oui - Non): ");
				
		        confirmer = sc5.nextLine().trim().toLowerCase();
		        
		        if (confirmer.equals("oui")) {
		        	
		        	System.out.println("Le Patient a été supprrimer avec succès!");
		        	
					PM.remove(ID);

		            break;
		            
		        } else {
		        	
		        	if(!confirmer.equals("non")) {
		        		
		        	  System.out.println("Réponse invalide!.");
		        	  
		        	}else {
		        		break;
		        	}
		            
		        }
		        
			    }
			}
			    
			    break;
			 
			 
		case 3: onSP = false;
		
		        break;
			 
			
			
		}
		}

		
		
	}

	
	
	
	public static void Gestion_Patients(Patient_Management PM, Scanner sc5) {
		
		boolean onGP = true;
		
		 int input6 = 0;

		while(onGP == true ) {
								
			while(true) {
				
			
		System.out.println("\n1:Crée une nouvelle fiche d'un patient\t2:Afficher les fiches des patients\t3:"
				+ "Modifier une fiche d'un Patient\t4:Supprimer un fiche d'un Patient\t5:Retour");

		 
		 System.out.print("\nEntrer: ");
			
			try {
				
				input6=sc5.nextInt();
				
				break;
				
			}catch(InputMismatchException exception) {
				
				System.out.println("Erreur ! Veuillez saisir un entier parmi les options du menu !");
								
				sc5.next();
				
			}
			}
			
			input6 = applicationMain.ChoixMenu(input6,1,5,sc5);
			
			switch (input6) {
			
			case 1: 
				PM.add(PM.createPatient());
			        System.out.println("Le fiche du Patient a été créer avec succès!");
			break;
			
			case 2: 
				   if(PM.getPatients().size()<=0) {
					   
					   System.out.println("La liste des fiches des patients est vide!");
				   }else {

				PM.afficherPatients();
				   }
			        break;
				
			case 3: ModifierPatient(PM,sc5);
			
			       break;
				
			case 4: SupprimerPatient(PM,sc5);
			
			         break;
			
			case 5: onGP = false;
			break;
			}
		
		
	}
	}
	
	
	
	
}



