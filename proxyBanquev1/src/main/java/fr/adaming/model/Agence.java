package fr.adaming.model;

import java.util.Date;

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
	@Column(name="id_agence")
	private int id;
	
	

	@Column(name="numIdentif")
	private String numIdentif;
	
	@Column(name="dateCreation")
	private Date dateCreation;

	/**
	 * ctor vide
	 */
	public Agence() {
		
	}

	/**
	 * ctor chargé sans Id
	 * @param numIdentif
	 * @param dateCreation
	 */
	public Agence(String numIdentif, Date dateCreation) {
		super();
		this.numIdentif = numIdentif;
		this.dateCreation = dateCreation;
	}
	
	/**
	 * ctor chargé
	 * @param id
	 * @param numIdentif
	 * @param dateCreation
	 */
	public Agence(int id, String numIdentif, Date dateCreation) {
		super();
		this.id = id;
		this.numIdentif = numIdentif;
		this.dateCreation = dateCreation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumIdentif() {
		return numIdentif;
	}

	public void setNumIdentif(String numIdentif) {
		this.numIdentif = numIdentif;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	
	
	
	
	
	

}
