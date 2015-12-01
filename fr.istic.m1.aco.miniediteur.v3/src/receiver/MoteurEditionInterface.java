package receiver;

/**
 * Interface pour le MoteurEdition
 * 
 * @author Clément G., Paul C.
 */
public  interface MoteurEditionInterface 
{	
	public void coller() ;
	
	public void copier() ;

	public void couper() ;
	
	public void saisir(StringBuffer texte) ;
	
	public void selectionner(int debut, int longueur) ;
	
	public String getContent();
	
	public String getSelection();
}

