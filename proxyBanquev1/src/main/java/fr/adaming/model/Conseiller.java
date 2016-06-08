package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "conseiller")
@Table(name = "conseillers")
public class Conseiller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conseiller")
	private int id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	private List<Client> listClient;

	/**
	 * ctor
	 */
	public Conseiller() {
		super();
	}

	/**
	 * ctor chargé sans Id
	 * 
	 * @param nom
	 * @param prenom
	 * @param listClient
	 */
	public Conseiller(String nom, String prenom, List<Client> listClient) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.listClient = listClient;
	}

	/**
	 * ctor chargé
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param listClient
	 */
	public Conseiller(int id, String nom, String prenom, List<Client> listClient) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.listClient = listClient;
	}

	/*************************
	 * 
	 * GETTERS & SETTERS
	 ************************/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
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

	public List<Client> getListClient() {
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

}
