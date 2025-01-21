package gestion_de_suivi_et_dossier_medicale;

import java.util.InputMismatchException;

import java.util.Scanner;

import application.applicationMain;
import gestion_de_fiche_patient.Patient;
import gestion_de_fiche_patient.Patient_Management;

import gestion_medecin.Docteur;
import gestion_ordonnance.Ordonnance;
import gestion_ordonnance.Ordonnance_Management;

public class GestionDossier {

	
	 public static void Gestion_Dossier(Docteur docteur, Patient_Management PM, DossierManagement DSM,Ordonnance_Management OM,Scanner sc5) {
		 
		 boolean onGD = true;
		 
		 int input15;
		 
		 while(onGD == true) {
			 
			 while(true) {
				 
				 System.out.println("**GESTION DES DOSSIERS ET DE SUIVI MEDICALE**");
			 
			 System.out.println("1:Créer un nouveau Dossier Médicale.\t    2:Afficher le Dossier Médicale d'un Patient."
			 		+ "\t    3:Mise à jour un Dossier Médicale d'un Patient.\t    4:Supprimer un Dossier Médicale d'un Patient"
			 		+ "\t    5:Retour");
			 
			 System.out.print("\nEntrer: ");
				
				try {
					
					input15=sc5.nextInt();
					
					break;
					
				}catch(InputMismatchException exception) {
					
					System.out.println("Erreur ! Veuillez saisir un entier parmi les options du menu !");
					
					sc5.next();
					
				}
				}
				
				input15 = applicationMain.ChoixMenu(input15,1,5,sc5);
				
				switch(input15) {
				
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
							
                            DSM.add(DSM.CreeNouveauDossier(patient, docteur));					

						}
					break;
					
				case 2:
					
					if(DSM.getDossiersMedicale().size()<=0) {
						
						System.out.println("La liste des Dossiers Médicale est vide!");
						
						break;
					}else {
						
                        String nom;
	                    
						nom = sc5.nextLine(); //absorbé le ENTER
						
						System.out.print("\nEntrer le nom du patient: ");
						
						nom = sc5.nextLine();
						
						if(DSM.rechercheDossier(nom) == false) {
							
							System.out.println("Le Dossier de patient avec nom "+nom+" n'existe pas!");
							
							break;
							
						}else {
													
							int ID;
							
							boolean trouver = false;
							
							while(true) {
								
								System.out.println("\nSéléctioner par ID (Entrer -1 pour Retour): ");
																			
								try {
									
									ID = sc5.nextInt();
									
									if(ID == -1) {
										
										break;
									}
									
									for(DossierMedicale dsm : DSM.getDossiersMedicale()) {
										
										if(dsm.getPatient().getID() == ID) {
											
										    dsm.affichierDossierMedicale();
										    
										    trouver = true;
										}
									}
									
									if(trouver = true) {
										
									 break;
									 
									}else {
										System.out.println("Veuillez entrer un ID valide!");
									}
									
								}catch(InputMismatchException exception) {
									
									System.out.println("Veuillez entrer un ID valide!");
									
									sc5.nextLine();
									
							}
								
							}
							
                            
                            
					}
					}
					
					
					break;
					
				case 3:
					
                        if(DSM.getDossiersMedicale().size()<=0) {
						
						System.out.println("La liste des Dossiers Médicale est vide!");
						
						break;
					}else {
						
                        String nom;
	                    
						nom = sc5.nextLine(); //absorbé le ENTER
						
						System.out.print("\nEntrer le nom du patient: ");
						
						nom = sc5.nextLine();
						
						if(DSM.rechercheDossier(nom) == false) {
							
							System.out.println("Le Dossier de patient avec nom "+nom+" n'existe pas!");
							
							break;
							
						}else {
													
							int ID;
							
							boolean trouver = false;
							
							DossierMedicale dm = null;
							
							while(true) {
								
								System.out.println("\nSéléctioner par ID (Entrer -1 pour Retour): ");
																			
								try {
									
									ID = sc5.nextInt();
									
									if(ID == -1) {
										
										break;
									}
									
									for(DossierMedicale dsm : DSM.getDossiersMedicale()) {
										
										if(dsm.getPatient().getID() == ID) {
											
                                           dm = dsm;
                                           
										    trouver =true;
										    
										    break;
										}
									}
									
									if(trouver = true) {
										
									 break;
									 
									}else {
										System.out.println("Veuillez entrer un ID valide!");
									}
									
								}catch(InputMismatchException exception) {
									
									System.out.println("Veuillez entrer un ID valide!");
									
									sc5.nextLine();
									
							}
								
							}
							
							if(trouver == true) {
								
								
							int input7;
			                 
                            while(true) {
                        		
                            	System.out.println("1:Créer une nouvelle Ordonnance pour la mise a jour du Suivi\t   "
                                		+ "2:Charger l'Ordonnance depuis la liste des ordonnances(Si déja existe)\t    "
                                		+ "3:Mise à jour le Dossier Médicale sans nouvelle ordonnance");
                        					
                        		System.out.print("\nEntrer: ");
                        		
                        		try {
                        			
                        			input7=sc5.nextInt();
                        			
                        			break;
                        			
                        		}catch(InputMismatchException exception) {
                        			
                        			System.out.println("Erreur ! Veuillez saisir un entier parmi les options du menu !");
                        			
                        		}
                        		}
                        		
                        		input7 = applicationMain.ChoixMenu(input7,1,3,sc5);
                        		
                        		switch(input7) {
                        		
                        		case 1: Ordonnance O;
                        		
                                 O = OM.createOrdonnance(docteur, dm.getPatient());
                                 
                                 DSM.miseAjourSuivi(dm, O);
                                 
                                 break;
                                 
                        		case 2:if(OM.getOrdonnances().size()<=0) {
                        			
                        			System.out.println("La liste des ordonnances est vide!");
                        			
                        		
                        		}else {
                        			
                        			
                        			if(OM.rechercheOrdonnance(dm.getPatient().getNom()) == false) {
                						
                						System.out.println("L'Ordonnance du Patient avec  nom "+dm.getPatient().getNom()+" n'existe pas!");
                						
                						break;
                					}else {
                												
                						int id;
                						
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
                							
                							
                							Ordonnance ordo = OM.getOrdonnances().get(ID-1);
                							
                							DSM.miseAjourSuivi(dm, ordo);
                							
                							System.out.println("Le DossierMédicale du Patient "+dm.getPatient().getNom()+" "+dm.getPatient().getPrenom()+" a été mise a jour avec succès!");
                							
                							break;
                							
                						}
                		}
                        			
                        		}
                        			
                        			break;
                        			
                        		case 3:
                        			
                        			DSM.miseAjourSuivi(dm, null);
                        			
                        		}
                            
							
							
							}		

					}
					}
					
					break;
				
				case 4:
					
                       if(DSM.getDossiersMedicale().size()<=0) {
						
						System.out.println("La liste des Dossiers Médicale est vide!");
						
						break;
					}else {
						
                        String nom;
	                    
						nom = sc5.nextLine(); //absorbé le ENTER
						
						System.out.print("\nEntrer le nom du patient: ");
						
						nom = sc5.nextLine();
						
						if(DSM.rechercheDossier(nom) == false) {
							
							System.out.println("Le Dossier de patient avec nom "+nom+" n'existe pas!");
							
							break;
							
						}else {
													
							int ID;
							
							boolean trouver = false;
							
							DossierMedicale dm = null;
							
							while(true) {
								
								System.out.println("\nSéléctioner par ID (Entrer -1 pour Retour): ");
																			
								try {
									
									ID = sc5.nextInt();
									
									if(ID == -1) {
										
										break;
									}
									
									for(DossierMedicale dsm : DSM.getDossiersMedicale()) {
										
										if(dsm.getPatient().getID() == ID) {
											
                                           DSM.remove(ID);
                                           
										    trouver =true;
										    
										    break;
										}
									}
									
									if(trouver = true) {
										
									 break;
									 
									}else {
										System.out.println("Veuillez entrer un ID valide!");
									}
									
								}catch(InputMismatchException exception) {
									
									System.out.println("Veuillez entrer un ID valide!");
									
									sc5.nextLine();
									
							}
								
							}
						}
					}
					
					
					break;
					
				case 5: onGD = false;
					break;
			 
			 
			 
		 }
		 }
		 
		 
	 }
	
	
	
}


