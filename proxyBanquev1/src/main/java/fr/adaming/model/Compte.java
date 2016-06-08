package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;

/**
 * 
 * @author INTI-0247
 *
 */

public abstract class Compte {

	
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
	 * @param dateCr�ation
	 */
	public Compte(int idCompte, double solde, Date dateCr�ation) {
		super();
		this.solde = solde;
		this.dateCreation = dateCr�ation;
	}

	/**
	 * CTOR SURCH SANS ID
	 * @param solde
	 * @param dateCr�ation
	 */
	public Compte(double solde, Date dateCr�ation) {
		super();
		this.solde = solde;
		this.dateCreation = dateCr�ation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Date getDateCr�ation() {
		return dateCreation;
	}

	public void setDateCr�ation(Date dateCr�ation) {
		this.dateCreation = dateCr�ation;
	}

}
