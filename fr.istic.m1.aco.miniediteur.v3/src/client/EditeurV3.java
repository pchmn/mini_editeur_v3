package client;

import java.util.Scanner;

import command.*;
import invoker_v3.IHMMV3;
import memento.EnregistreurV3;
import receiver.*;

/**
 * Classe Editeur <br>
 * C'est le main de la version 3 <br>
 * Elle permet de lancer le programme
 * 
 * @author Clément G., Paul C.
 *
 */
public class EditeurV3 {
	
	public MoteurEditionInterface moteurEditionInterface;
	
	public IHMMV3 ihm;
	

	public EditeurV3() {
		super();
	}
	
	
	/**
	 * Demande le texte à saisir et le retourne
	 * 
	 * @return StringBuffer
	 */
	public StringBuffer getTexte(){
		StringBuffer texte = new StringBuffer();		
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez quelque chose : ");
		return texte.append(sc.nextLine());
	}
	
	
	/**
	 * Demande le numero du caractère de debut de sélection et le retourne
	 * 
	 * @return int
	 */
	public int getDebut(){
		Scanner sc = new Scanner(System.in);
		boolean isInteger = false;
		
		while(!isInteger) {
			System.out.println("Entrez le numero du 1er caractere de la sélection : ");
			if(sc.hasNextInt()) {
				isInteger = true;
			}
			else {
				isInteger = false;
				System.err.println("Erreur, veuillez rentrer un nombre");
				sc.nextLine();
			}
		}
		
		return sc.nextInt();
	}
	
	/**
	 * Demande le nombre de caractères à sélectionner et le retourne
	 * 
	 * @return int
	 */
	public int getLongueur(){
		Scanner sc = new Scanner(System.in);
		boolean isInteger = false;
		
		while(!isInteger) {
			System.out.println("Entrez le nombre de caractere à sélectionner : ");
			if(sc.hasNextInt()) {
				isInteger = true;
			}
			else {
				isInteger = false;
				System.err.println("Erreur, veuillez rentrer un nombre");
				sc.nextLine();
			}
		}
		
		return sc.nextInt();
	}
	
	/**
	 * La fonction main de la version 3 <br>
	 * Lance le programme
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		// Initialisation
		IHMMV3 ihm = new IHMMV3();	
		EnregistreurV3 enregistreur = new EnregistreurV3();
		MoteurEdition moteur = new MoteurEditionEnregistrable(enregistreur);
		Scanner sc = new Scanner(System.in);
		String choix;
		
		do {
			
			// Menu
			System.out.println("\nVotre texte : " + moteur.getSelection());
			ihm.menu();
			
			// En attente du choix
			choix = sc.nextLine();
			Command cmd = null;
			
			System.out.println(choix);
			
			// Saisir
			if (choix.equalsIgnoreCase("w")) {
				cmd = new Saisir(moteur, ihm);
				cmd.execute();
				
			// Copier
			} else if (choix.equalsIgnoreCase("c")) {
				cmd = new Copier(moteur);
				cmd.execute();
				
			// Coller
			} else if (choix.equalsIgnoreCase("p")) {
				cmd = new Coller(moteur);
				cmd.execute();
				
			// Couper
			} else if (choix.equalsIgnoreCase("x")) {
				cmd = new Couper(moteur);	
				cmd.execute();
				
			// Sélectionner
			} else if (choix.equalsIgnoreCase("s")) {
				cmd = new Selectionner(moteur, ihm);
				cmd.execute();
			
			// Défaire
			} else if (choix.equalsIgnoreCase("d")) {
				System.out.println("Retour à l'état précédent");
				enregistreur.defaire();
				
			// Refaire
			} else if (choix.equalsIgnoreCase("r")) {
				System.out.println("Avance jusqu'à l'état suivant");
				enregistreur.refaire();
			}
			
		// Quitte quand on écrit q
		} while (!choix.equalsIgnoreCase("q"));
		
	}
}
