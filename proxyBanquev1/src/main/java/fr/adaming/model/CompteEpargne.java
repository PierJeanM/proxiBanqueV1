package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe concrete CompteEpargne dont les instances dans la BDD auront "epargne" pour valeur
 * dans la colonne "typeCompte" de la table "comptes"
 *
 */
@Entity(name="compteEpargne")
@Table(name="comptes_epargnes")
@DiscriminatorValue("epargne")
public class CompteEpargne extends Compte {
	
	@Column(name="remuneration")
	private Double remuneration = 0.03;
	
	public CompteEpargne() {
		super();
	}

	public CompteEpargne(Double remuneration) {
		super();
		this.remuneration = remuneration;
	}
	
	public CompteEpargne(Integer numeroCompte, double solde, Date dateCreation, Client titulaire) {
		super(numeroCompte, solde, dateCreation, titulaire);
	}
	
	public CompteEpargne(double solde, Date dateCreation, Client titulaire) {
		super(solde, dateCreation, titulaire);
	}
	
	public CompteEpargne(double solde, Date dateCreation, Double remuneration, Client titulaire) {
		super(solde, dateCreation, titulaire);
		this.remuneration = remuneration;
	}

	public CompteEpargne(Integer numeroCompte, double solde, Date dateCreation,	Double remuneration, Client titulaire) {
		super(numeroCompte, solde, dateCreation, titulaire);
		this.remuneration = remuneration;
	}
	

	public Double getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(Double remuneration) {
		this.remuneration = remuneration;
	}
}
