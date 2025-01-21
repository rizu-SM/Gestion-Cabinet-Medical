package gestion_medecin;

import gestion_de_person.Person;

public class Docteur extends Person{

	private int ID;
	
    private String specialite;
    
    private String password;
    

    public Docteur(String nom, String prenom, String numeroT, String specialite,int ID, String pass){

        super(nom, prenom, numeroT);
        
        this.specialite=specialite;
        
        this.ID =ID;
        
        this.password=pass;
        
    }

    public String getSpecialite(){
        return specialite;
    }

    public void setSpecialite(String specialite){
       this.specialite=specialite;
    }
    
    public String toString() {
    	return "Docteur ID: "+ID+"\nNom: "+getNom()+"\nPrenom: "+getPrenom()+"\nNuméro De Téléphone: "+getNumeroT()
    	+"\nSpecialité: "+specialite;
    }
    
    public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void afficherDocteur() {
    	System.out.println(toString());
    }
    
    public Boolean passwordMatch(String pass) {
    	
         if(this.password == pass) {
        	 return true;
         }else {
        	 return false;
         }
    }

}

