package gestion_de_rendez_vous;

import application.*;
import java.util.InputMismatchException;


import java.util.Scanner;

import gestion_de_fiche_patient.Patient;
import gestion_de_fiche_patient.Patient_Management;
import gestion_medecin.Docteur;

public class GestionRV {

	
	public static void Modifier_RendezVous(Docteur docteur ,Rendez_vous_Management RV, Patient_Management PM, Scanner sc5) {
		
		boolean onMRV = true;
		
		int input11 =0;
		
		
		while(onMRV == true) {
			
			
			while(true) {
				System.out.println("1:Rechercher le Rendez-Vous par le NOM du Patient, Puis le séléctionner par ID pour modifier\t   "
						+ " 2:Séléctionner directement par ID pour modifier\t      3:Retour");
				
							
				System.out.print("\nEntrer: ");
				
				try {
					
					input11=sc5.nextInt();
					
					break;
					
				}catch(InputMismatchException exception) {
					
					System.out.println("Erreur ! Veuillez saisir un entier parmi les options du menu !");
					
				}
				}
				
				input11 = applicationMain.ChoixMenu(input11,1,3,sc5);
				
				switch (input11) {
				
				case 1:
					
					String nomP;
					
					nomP = sc5.nextLine(); //absorbé le ENTER
					
					System.out.print("\nEntrer le nom du patient: ");
					
					nomP = sc5.nextLine();
					
					if(RV.rechercheRV(nomP) == false) {
						
						System.out.println("Le Rendez-Vous du Patient avec  nom "+nomP+" n'existe pas!");
						
						break;
					}else {
												
						int ID;
						
						while(true) {
							
							System.out.println("\nSéléctioner par ID (Entrer -1 Pour Retour):  ");
											
							try {
								
								ID = sc5.nextInt();
								
								if(ID == -1) {
									break;
								}
								
								if((ID-1)>=0 && (ID-1)<RV.getRendezVousList().size()) {
									
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
							
						}else {
							
							
							Rendez_vous rv;
							
							System.out.println("**RENDEZ-VOUS DU PATIENT "+RV.getRendezVousList().get(ID-1).getPatient().getNom()+" "+RV.getRendezVousList().get(ID-1).getPatient().getPrenom()+" ID: "+ID+" MODIFICATION **\n");
							
							rv = RV.createRendezvous(docteur, RV.getRendezVousList().get(ID-1).getPatient());
							
							RV.edit(ID, rv);
							
							System.out.println("Le Rendez-Vous a été modifier avec succès!");
							
							break;
							
						}
							
		
			
		}
					
				case 2:
					
					int ID;
					
					while(true) {
						
						System.out.println("\nSéléctioner par ID (Entrer -1 Pour Retour):  ");
										
						try {
							
							ID = sc5.nextInt();
							
							if(ID == -1) {
								break;
							}
							
							if((ID-1)>=0 && (ID-1)<RV.getRendezVousList().size()) {
								
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
						
					}else {
						
						
						Rendez_vous rv;
						
						System.out.println("**RENDEZ-VOUS DU PATIENT "+RV.getRendezVousList().get(ID-1).getPatient().getNom()+" "+RV.getRendezVousList().get(ID-1).getPatient().getPrenom()+" ID: "+ID+" MODIFICATION **\n");
						
						rv = RV.createRendezvous(docteur, RV.getRendezVousList().get(ID-1).getPatient());
						
						RV.edit(ID, rv);
						
						System.out.println("Le Rendez-Vous a été modifier avec succès!");
						
						break;
						
					}
					
					
				case 3: onMRV = false;
				       break;
					
					
					
				}
		}
	}
	
	
	
	
	public static void Supprimer_RendezVous(Patient_Management PM, Rendez_vous_Management RV, Scanner sc5) {
		
		
        boolean onSRV = true;
		
		while(onSRV == true) {
		
			System.out.println("1:Rechercher le Rendez-Vous par le NOM du Patient, Puis le séléctionner par ID pour supprimer\t   "
					+ " 2:Séléctionner directement par ID pour supprimer\t      3:Retour");
							
		int input12;
		
		while(true) {
			
			System.out.println("Entrer: ");
			
		    try {
		    	
		    	input12 = sc5.nextInt();
		    	
		    	break;
		    	
		    }catch(InputMismatchException exception) {
		    	
				System.out.println("Erreur ! Veuillez saisir un entier parmi les options du menu !");
				
				sc5.next();
				
		    }
			}
		
		input12 = applicationMain.ChoixMenu(input12,1,3,sc5);
		
		switch(input12) {
		
		case 1:
			
			String nomP;
			
			nomP = sc5.nextLine(); //absorbé le ENTER
			
			System.out.print("\nEntrer le nom du patient: ");
			
			nomP = sc5.nextLine();
			
			if(RV.rechercheRV(nomP) == false) {
				
				System.out.println("Le Rendez-Vous du Patient avec  nom "+nomP+" n'existe pas!");
				
				break;
			}else {
										
				int ID;
				
				while(true) {
					
					System.out.println("\nSéléctioner par ID (Entrer -1 Pour Retour):  ");
									
					try {
						
						ID = sc5.nextInt();
						
						if(ID == -1) {
							break;
						}
						
						if((ID-1)>=0 && (ID-1)<RV.getRendezVousList().size()) {
							
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
					
				}else {
					
		
					
					System.out.println("**RENDEZ-VOUS DU PATIENT "+RV.getRendezVousList().get(ID-1).getPatient().getNom()+" "+RV.getRendezVousList().get(ID-1).getPatient().getPrenom()+" ID: "+ID+" SUPRESSION **\n");
					
                    String confirmer;
					
				    while(true) {
				    	
				    
					System.out.println("Confirmer la suppression de Rendez-Vous de Patient "+RV.getRendezVousList().get(ID-1).getPatient().getNom()
					  +" "+RV.getRendezVousList().get(ID-1).getPatient().getPrenom()+" ?");
					
					System.out.print("\nEntrer (Oui - Non): ");
					
			        confirmer = sc5.nextLine().trim().toLowerCase();
			        
			        if (confirmer.equals("oui")) {
			        	
			        	System.out.println("Le Patient a été supprrimer avec succès!");
			        	
						RV.remove(ID);

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
					

	
}
			
		case 2:
			
			int ID;
			
			while(true) {
				
				System.out.println("\nSéléctioner par ID (Entrer -1 Pour Retour):  ");
								
				try {
					
					ID = sc5.nextInt();
					
					if(ID == -1) {
						break;
					}
					
					if((ID-1)>=0 && (ID-1)<RV.getRendezVousList().size()) {
						
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
				
			}else {
				
	
				
				System.out.println("**RENDEZ-VOUS DU PATIENT "+RV.getRendezVousList().get(ID-1).getPatient().getNom()+" "+RV.getRendezVousList().get(ID-1).getPatient().getPrenom()+" ID: "+ID+" SUPRESSION **\n");
				
                String confirmer;
				
			    while(true) {
			    	
			    
				System.out.println("Confirmer la suppression de Rendez-Vous de Patient "+RV.getRendezVousList().get(ID-1).getPatient().getNom()
				  +" "+RV.getRendezVousList().get(ID-1).getPatient().getPrenom()+" ?");
				
				System.out.print("\nEntrer (Oui - Non): ");
				
		        confirmer = sc5.nextLine().trim().toLowerCase();
		        
		        if (confirmer.equals("oui")) {
		        	
		        	System.out.println("Le Patient a été supprrimer avec succès!");
		        	
					RV.remove(ID);

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
			
		case 3: onSRV= false;
		       break;
		}
		
		
		}
		
		
	
	}
	
	
	public static void Gestion_RendezVous(Docteur docteur, Patient_Management PM, Rendez_vous_Management RV, Scanner sc5 ) {
		
		boolean onRV=true;
		
		int input10 = 0;
		
		while(onRV == true) {
			
			while(true) {
			
			System.out.println("**GESTION DES RENDEZ-VOUS**\n");
			
			System.out.println("1:Planifier un nouveau Rendez-Vous\t   2:Afficher les Rendez-Vous\t   3:Modifier un Rendez-Vous"
					+ "\t    4:Supprimer un Rendez-Vous\t   5:Retour");
             
			System.out.print("\nEntrer: ");
			
			try {
				
				input10=sc5.nextInt();
				
				break;
				
			}catch(InputMismatchException exception) {
				
				System.out.println("Erreur ! Veuillez saisir un entier parmi les options du menu !");
				
				sc5.next();
			}
			
			}
			
			input10 = applicationMain.ChoixMenu(input10,1,5,sc5);
			
              switch (input10) {
			
			case 1: 
				if(PM.getPatients().size() <=0) {
					
					System.out.println("La liste des fiches des Patients est vide!");
					
					System.out.println("Veuillez les charger à partir du dossier médical ou en créer un nouveau.");
					
					break;
				}
				
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
						
						Patient patient = PM.getPatients().get(ID-1);
						
						RV.add(RV.createRendezvous(docteur, patient));
						

					}
					
					break;
					
	           
					
				
			        
			
			case 2: 
				   if(RV.getRendezVousList().size()<=0) {
					   
					   System.out.println("La liste des Rendez-Vous des patients est vide!");
				   }else {

                   RV.afficherRendezvous();
                   
				   }
			        break;
				
			case 3: Modifier_RendezVous(docteur,RV,PM,sc5);
			
			       break;
				
			case 4: Supprimer_RendezVous(PM,RV,sc5);
			
			         break;
			
			case 5: onRV = false;
			break;
			}
		
			
			
		}
		}
	
	
	
}
