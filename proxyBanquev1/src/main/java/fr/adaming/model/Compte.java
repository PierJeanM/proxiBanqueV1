package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe abstraite Compte qui possede une table dans la base qui contient comptes courants
 * et comptes epargne. Une colonne "typeCompte" permet de differencier les deux.
 * @author INTI-0247
 *
 */
@Entity(name="compte")
@Table(name="comptes")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeCompte")
public abstract class Compte {

	@Id
	@Column(name="numero_compte")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numeroCompte;
	
	@Column(name="solde")
	private double solde;
	
	@Column(name="date_creation")
	private Date dateCreation;
	
	@OneToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id_client")
	private Client titulaire;

	
	
	public Compte() {
	}

	public Compte(double solde, Date dateCreation, Client titulaire) {
		super();
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.titulaire = titulaire;
	}

	/**
	 * CTOR SURCH AVEC NUMERO COMPTE
	 * @param idCompte
	 * @param solde
	 * @param dateCreation
	 */
	public Compte(Integer numeroCompte, double solde, Date dateCreation, Client titulaire) {
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.titulaire = titulaire;
	}
	
	

	public Integer getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(Integer numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Client getTitulaire() {
		return titulaire;
	}

	public void setTitulaire(Client titulaire) {
		this.titulaire = titulaire;
	}
}
