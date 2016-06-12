package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "conseiller")
@Table(name = "conseillers")
public class Conseiller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conseiller")
	private Integer id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@OneToMany(mappedBy = "conseiller")
	private List<Client> listClients;

	@ManyToOne
	@JoinColumn(name = "agence_id", referencedColumnName = "id_agence")
	private Agence agence;
	
	
	/* Constructeurs */
	public Conseiller() {
	}
	
	/**
	 * Constructeur avec nom, prenom et agence
	 * @param nom
	 * @param prenom
	 */
	public Conseiller(String nom, String prenom, Agence agence) {
		this.nom = nom;
		this.prenom = prenom;
		this.agence = agence;
	}

	/**
	 * ctor charge sans Id
	 * 
	 * @param nom
	 * @param prenom
	 * @param listClient
	 */
	public Conseiller(String nom, String prenom, List<Client> listClients, Agence agence) {
		this.nom = nom;
		this.prenom = prenom;
		this.listClients = listClients;
		this.agence = agence;
	}

	/**
	 * ctor charge
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param listClient
	 */
	public Conseiller(int id, String nom, String prenom, List<Client> listClients) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.listClients = listClients;
	}

	/*************************
	 * 
	 * GETTERS & SETTERS
	 ************************/
	

	public String getNom() {
		return nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Client> getListClients() {
		return listClients;
	}

	public void setListClients(List<Client> listClients) {
		this.listClients = listClients;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}
}
