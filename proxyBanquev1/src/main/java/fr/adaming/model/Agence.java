package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="agence")
@Table(name="agences")
public class Agence {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="numIdentif")
	private String numIdentif;
	
	@Column(name="dateCreation")
	private String dateCreation;

	/**
	 * ctor vide
	 */
	public Agence() {
		
	}

	/**
	 * ctor chargé
	 * @param numIdentif
	 * @param dateCreation
	 */
	public Agence(String numIdentif, String dateCreation) {
		super();
		this.numIdentif = numIdentif;
		this.dateCreation = dateCreation;
	}

	public String getNumIdentif() {
		return numIdentif;
	}

	public void setNumIdentif(String numIdentif) {
		this.numIdentif = numIdentif;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
	
	
	
	
	

}
