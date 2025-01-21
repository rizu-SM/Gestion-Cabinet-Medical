package gestion_ordonnance;

import java.util.InputMismatchException;

import java.util.Scanner;

import application.applicationMain;

import gestion_de_fiche_patient.Patient;

import gestion_de_fiche_patient.Patient_Management;

import gestion_medecin.Docteur;

public class GestionOrdo {

	
	
	public static void ModifierOrdonnance(Docteur docteur, Ordonnance_Management OM, Patient_Management PM, Scanner sc5) {
		
		
        boolean onMO = true;
		
		int input13 =0;
		
		
		while(onMO == true) {
			
			
			while(true) {
				
				System.out.println("1:Rechercher l'Ordonnance par le NOM du Patient, Puis le séléctionner par ID pour modifier.\t   "
						+ " 2:Séléctionner directement par ID pour modifier\t      3:Retour");
				
							
				System.out.print("\nEntrer: ");
				
				try {
					
					input13=sc5.nextInt();
					
					break;
					
				}catch(InputMismatchException exception) {
					
					System.out.println("Erreur ! Veuillez saisir un entier parmi les options du menu !");
					
				}
				}
				
				input13 = applicationMain.ChoixMenu(input13,1,3,sc5);
		
		        switch(input13) {
		        
		        case 1:
		        	

					String nomP;
					
					nomP = sc5.nextLine(); //absorbé le ENTER
					
					System.out.print("\nEntrer le nom du patient: ");
					
					nomP = sc5.nextLine();
					
					if(OM.rechercheOrdonnance(nomP) == false) {
						
						System.out.println("L'Ordonnance du Patient avec  nom "+nomP+" n'existe pas!");
						
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
								
								if((ID-1) >=0 && (ID-1) < OM.getOrdonnances().size()) {
									
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
							
							
							Ordonnance O;
							
							System.out.println("**ORDONNANCE DU PATIENT "+OM.getOrdonnances().get(ID-1).getPatient().getNom()+" "+OM.getOrdonnances().get(ID-1).getPatient().getPrenom()+" ID: "+ID+" MODIFICATION **\n");
							
							O = OM.createOrdonnance(docteur, OM.getOrdonnances().get(ID-1).getPatient());
							
							OM.edit(ID, O);
							
							System.out.println("L'Ordonnnace a été modifier avec succès!");
							
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
							
							if((ID-1) >=0 && (ID-1) < OM.getOrdonnances().size()) {
								
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
						
						
						Ordonnance O;
						
						System.out.println("**ORDONNANCE DU PATIENT "+OM.getOrdonnances().get(ID-1).getPatient().getNom()+" "+OM.getOrdonnances().get(ID-1).getPatient().getPrenom()+" ID: "+ID+" MODIFICATION **\n");
						
						O = OM.createOrdonnance(docteur, OM.getOrdonnances().get(ID-1).getPatient());
						
						OM.edit(ID, O);
						
						System.out.println("L'Ordonnnace a été modifier avec succès!");
						
						break;
						
					}
		        	
		        case 3: onMO=false;
		        
		                break;
		        
		        }
		
	}
	}
	
	public static void SupprimerOrdonnance(Ordonnance_Management OM, Patient_Management PM, Scanner sc5) {
		
       boolean onSO = true;
		
		while(onSO == true) {
		
			System.out.println("1:Rechercher l'Ordonnance par le NOM du Patient, Puis la séléctionner par ID pour supprimer\t   "
					+ " 2:Séléctionner directement par ID pour supprimer\t      3:Retour");
							
		int input14;
		
		while(true) {
			
			System.out.println("Entrer: ");
			
		    try {
		    	
		    	input14 = sc5.nextInt();
		    	
		    	break;
		    	
		    }catch(InputMismatchException exception) {
		    	
				System.out.println("Erreur ! Veuillez saisir un entier parmi les options du menu !");
				
				sc5.next();
				
		    }
			}
		
		input14 = applicationMain.ChoixMenu(input14,1,3,sc5);
		
		switch(input14) {
		
		case 1:
			
			String nomP;
			
			nomP = sc5.nextLine(); //absorbé le ENTER
			
			System.out.print("\nEntrer le nom du patient: ");
			
			nomP = sc5.nextLine();
			
			if(OM.rechercheOrdonnance(nomP) == false) {
				
				System.out.println("L'Ordonnance du Patient avec  nom "+nomP+" n'existe pas!");
				
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
						
						if((ID-1) >=0 && (ID-1) < OM.getOrdonnances().size()) {
							
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
					
		
					
					System.out.println("**ORDONNANCE DU PATIENT "+OM.getOrdonnances().get(ID-1).getPatient().getNom()+" "+OM.getOrdonnances().get(ID-1).getPatient().getPrenom()+" ID: "+ID+" SUPRESSION **\n");
					

                    String confirmer;
					
				    while(true) {
				    	
				    
					System.out.println("Confirmer la suppression d'Ordonnance de Patient "+OM.getOrdonnances().get(ID-1).getPatient().getNom()
					  +" "+OM.getOrdonnances().get(ID-1).getPatient().getPrenom()+" ?");
					
					System.out.print("\nEntrer (Oui - Non): ");
					
			        confirmer = sc5.nextLine().trim().toLowerCase();
			        
			        if (confirmer.equals("oui")) {
			        	
			        	System.out.println("L'Ordonnance du Patient "+OM.getOrdonnances().get(ID-1).getPatient().getNom()+" "+OM.getOrdonnances().get(ID-1).getPatient().getPrenom()+
			        			" a été supprrimer avec succès!");
			        	
						OM.remove(ID);

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
			
			if((ID-1) >=0 && (ID-1) < OM.getOrdonnances().size()) {
				
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
		

		
		System.out.println("**ORDONNANCE DU PATIENT "+OM.getOrdonnances().get(ID-1).getPatient().getNom()+" "+OM.getOrdonnances().get(ID-1).getPatient().getPrenom()+" ID: "+ID+" SUPRESSION **\n");
		

        String confirmer;
		
	    while(true) {
	    	
	    
		System.out.println("Confirmer la suppression d'Ordonnance de Patient "+OM.getOrdonnances().get(ID-1).getPatient().getNom()
		  +" "+OM.getOrdonnances().get(ID-1).getPatient().getPrenom()+" ?");
		
		System.out.print("\nEntrer (Oui - Non): ");
		
        confirmer = sc5.nextLine().trim().toLowerCase();
        
        if (confirmer.equals("oui")) {
        	
        	System.out.println("L'Ordonnance du Patient "+OM.getOrdonnances().get(ID-1).getPatient().getNom()+" "+OM.getOrdonnances().get(ID-1).getPatient().getPrenom()+
        			" a été supprrimer avec succès!");
        	
			OM.remove(ID);

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
			
		case 3: onSO=false;
			
			break;
	
}
			
			
		   
		}
	}
	
	
	
	public static void Gestion_Ordonnance(Docteur docteur,Ordonnance_Management OM,Patient_Management PM,
			Scanner sc5) {
		
		boolean onGO = true;
		
		int input=0;
		
		while(onGO == true) {
			
			
			while(true) {
				
				System.out.println("**GESTION ORDONNANCE***");
				
				System.out.println("1:Crèer une nouvelle Ordonnance pour un Patient\t    2:Afficher La liste des Ordonnances\t    "
						+ "3: Modifier une Ordonnances\t    4:Supprimer une Ordonnance\t   5:Retour");


				 
				 System.out.print("\nEntrer: ");
					
					try {
						
						input=sc5.nextInt();
						
						break;
						
					}catch(InputMismatchException exception) {
						
						System.out.println("Erreur ! Veuillez saisir un entier parmi les options du menu !");
						
						sc5.nextLine();
						
					}
					}
					
					input = applicationMain.ChoixMenu(input,1,5,sc5);
					
					switch(input) {
					
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
					
						           OM.add(OM.createOrdonnance(docteur, patient));
						           
						           System.out.println("Odonnance créer avec succès!");
							}
							
							break;
						
					case 2: 
						if(OM.getOrdonnances().size() <=0) {
							
							System.out.println("La liste des Ordonnances est vide!");
						}else {
							
							OM.afficherOrdonnances();
						}
						break;
						
					case 3: ModifierOrdonnance(docteur,OM,PM,sc5);
						
					case 4: SupprimerOrdonnance(OM,PM,sc5);
						
					case 5:onGO = false;
					       break;
					}
					
				
			
		}
		
	}
}
