package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe concrete CompteCourant dont les instances dans la BDD auront "courant" pour valeur
 * dans la colonne "typeCompte" de la table "comptes"
 *
 */
@Entity(name="compteCourant")
@Table(name="comptes_courants")
@DiscriminatorValue("courant")
public class CompteCourant extends Compte{

	
	@Column(name="decouvert_autorise")
	private int decouvertAutoris = 1000;
	
	public CompteCourant() {
		super();
	}
	
	public CompteCourant(double solde, Date dateCreation, Client titulaire) {
		super(solde, dateCreation, titulaire);
	}

	public CompteCourant(Integer numeroCompte, double solde, Date dateCreation, Client titulaire) {
		super(numeroCompte, solde, dateCreation, titulaire);
	}
	
	public CompteCourant(double solde, Date dateCreation,	int decouvertAutoris, Client titulaire) {
		super(solde, dateCreation, titulaire);
		this.decouvertAutoris = decouvertAutoris;
	}

	public CompteCourant(Integer numeroCompte, double solde, Date dateCreation,	int decouvertAutoris, Client titulaire) {
		super(numeroCompte, solde, dateCreation, titulaire);
		this.decouvertAutoris = decouvertAutoris;
	}
	

	public int getDecouvertAutoris() {
		return decouvertAutoris;
	}

	public void setDecouvertAutoris(int decouvertAutoris) {
		this.decouvertAutoris = decouvertAutoris;
	}
}
