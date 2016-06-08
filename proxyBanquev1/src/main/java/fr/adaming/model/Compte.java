package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author INTI-0247
 *
 */
@Entity(name="compte")
@Table(name="comptes")
public abstract class Compte {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_compte")
	private int idCompte;
	@Column(name="solde")
	private double solde;
	@Column(name="date_creation")
	private Date dateCreation;

	public Compte() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * CTOR SURCH AVEC ID
	 * @param idCompte
	 * @param solde
	 * @param dateCréation
	 */
	public Compte(int idCompte, double solde, Date dateCréation) {
		super();
		this.idCompte = idCompte;
		this.solde = solde;
		this.dateCreation = dateCréation;
	}

	/**
	 * CTOR SURCH SANS ID
	 * @param solde
	 * @param dateCréation
	 */
	public Compte(double solde, Date dateCréation) {
		super();
		this.solde = solde;
		this.dateCreation = dateCréation;
	}

	public int getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDateCréation() {
		return dateCreation;
	}

	public void setDateCréation(Date dateCréation) {
		this.dateCreation = dateCréation;
	}

}
