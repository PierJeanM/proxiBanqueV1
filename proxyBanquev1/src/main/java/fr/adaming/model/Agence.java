package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="agence")
@Table(name="agences")
public class Agence {
	
	@Id
	@Column(name="id_agence", nullable=false)
	private String id;
	
	@Column(name="dateCreation")
	private Date dateCreation;

	@OneToMany(mappedBy = "agence")
	private List<Conseiller> conseillers;
	
	
	/* Constructeurs */
	public Agence() {
	}
	
	public Agence(String numIdentif, Date dateCreation) {
		this.id = numIdentif;
		this.dateCreation = dateCreation;
	}
	
	public Agence(Date dateCreation, List<Conseiller> conseillers) {
		this.dateCreation = dateCreation;
		this.conseillers = conseillers;
	}
	
	public Agence(String id, Date dateCreation, List<Conseiller> conseillers) {
		this.id = id;
		this.dateCreation = dateCreation;
		this.conseillers = conseillers;
	}


	/* Getters and setters */

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<Conseiller> getConseillers() {
		return conseillers;
	}

	public void setConseillers(List<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}
}
