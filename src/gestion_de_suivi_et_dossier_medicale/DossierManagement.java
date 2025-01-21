package gestion_de_suivi_et_dossier_medicale;

import gestion_de_person.*;
import gestion_medecin.Docteur;
import gestion_ordonnance.Ordonnance;

import java.util.ArrayList;

import gestion_de_fiche_patient.Patient;

import java.util.Scanner;


public class DossierManagement implements Management<DossierMedicale> {
	
	
	private ArrayList<DossierMedicale> dossiersMedicale;
	
	public Scanner sc4 = new Scanner(System.in);

	
	public DossierManagement() {
		
		this.dossiersMedicale = new ArrayList<DossierMedicale>();
	}


	
	
	public DossierMedicale CreeNouveauDossier(Patient patient, Docteur docteur) {
		
		 DossierMedicale dossier = new DossierMedicale(patient,docteur);
		 
		 return dossier;
	}
	
	public DossierMedicale miseAjourSuivi(DossierMedicale dossier,Ordonnance ordonnance) {
		
		double poids = 0,taille = 0;
		
		boolean valide=false;
		
		String Observation,resume;
		
		while(!valide) {
		
		System.out.println("Poids du patient: ");
		
		String Spoids = sc4.nextLine();
		
		Spoids = Spoids.replace(',', '.');
		
		try {
   
            poids = Double.parseDouble(Spoids);
            
            valide = true;
            
        } catch (NumberFormatException e) {
        	
            System.out.println("Poids Entré invalide!.");
        }
		
    }

		valide = false;
		
		while(!valide) {

		
		System.out.println("La taille du patient: ");
		
		String Staille = sc4.nextLine();
		
		Staille = Staille.replace(',', '.');
		
		try {
           
            taille = Double.parseDouble(Staille);
            
            valide = true; 
            
        } catch (NumberFormatException e) {
        	
            System.out.println("Taille Entré invalide!.");
            
        }
    }

		
		
		
		System.out.println("Observation: ");
		
		Observation = sc4.nextLine();
		
		System.out.println("Résumé: ");
		
		resume = sc4.nextLine();
		
		SuiviMedicale Suivi = new SuiviMedicale(dossier.getPatient(),ordonnance,poids,taille,Observation,resume);
		
		dossier.getSuivi_de_Patient().add(Suivi);
				
		return dossier;
		
	}
		
		public boolean rechercheDossier(String nom) {
			
			boolean  found_aux_moins_1 = false;
			
			for(DossierMedicale DSM : dossiersMedicale) {
				
				if(DSM.getPatient().getNom().equals(nom)) {
					
                    DSM.getPatient().afficherPatient();
                    
					found_aux_moins_1 = true;
					
				}
			}
			
			return found_aux_moins_1;
		}
		
	
	
	public ArrayList<DossierMedicale> getDossiersMedicale() {
		return dossiersMedicale;
	}




	public void setDossiersMedicale(ArrayList<DossierMedicale> dossiersMedicale) {
		this.dossiersMedicale = dossiersMedicale;
	}




	@Override
	public void add(DossierMedicale dossier) {
		
		boolean existe = false;
		
		int index = 0;
		
		while(existe == false && index <dossiersMedicale.size()) {
			
			if(dossiersMedicale.get(index).getPatient().getID() == dossier.getPatient().getID()) {
				
				existe = true;
				
			}else {
				
				index++;
				
			}
		}
		
		if(existe == true) {
			
			System.out.println("Erreur!, dossier médicale de patient "+dossier.getPatient().getNom()+" déja existe!");
			
		}else {
			
			dossiersMedicale.add(dossier);
		}
		
	}

	@Override
	public void edit(int PatientID, DossierMedicale dossierModifie) {
		
		boolean trouver = false;
		
		int index=0;
		
		while(trouver == false && index <dossiersMedicale.size()) {
			
			if(dossiersMedicale.get(index).getPatient().getID() == PatientID) {
				
				dossiersMedicale.set(index, dossierModifie);
				
				trouver = true;
				
				System.out.println("Dossier Medicale de Patient "+dossierModifie.getPatient().getNom()+" est modifié avec succès.");
				
			}else {
				
				index++;
			}
			
		}
		
		if(trouver == false) {
			
			System.out.println("Erreur! PatientID n'existe pas dans les dossiers medicales.");
		}
			
	
		
	}

	@Override
	public void remove(int PatientID) {
        
		boolean trouver = false;
		
		int index=0;
		
		while(trouver == false && index <dossiersMedicale.size()) {
			
		if(dossiersMedicale.get(index).getPatient().getID() == PatientID) {
			
			System.out.println("Dossier médicale de Patient "+dossiersMedicale.get(index).getPatient().getNom()+" est supprimer avec succès.");

			dossiersMedicale.remove(index);
			
			trouver = true;
	}else {
		
		index++;
	}
	
	}
		
		if(trouver == false) {
			
			System.out.println("Erreur! PatientID n'existe pas dans les dossiers médicales.");
			
		}
	}

}
