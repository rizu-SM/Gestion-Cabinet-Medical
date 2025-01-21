package gestion_de_person;


public interface Management<T> { 
	
	/* 
	 cette interface est utilsé parce-que on a 4 classes de management qui ont les memes trois méthodes 
	 add,edit et remove un objet T (patient, ordonnance,docteur ou un dossiermédicale)
	 */

	public abstract void add(T objet);
	public abstract void edit(int index, T objet);
	public abstract void remove(int index);
	
}
