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

@Entity(name = "client")
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client")
	private int id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "adresse")
	private String adresse;

	@Column(name = "codePostal")
	private String codePostal;

	@Column(name = "ville")
	private String ville;

	@Column(name = "telephone")
	private String telephone;

	@ManyToOne
	@JoinColumn(name = "conseiller_id", referencedColumnName = "id_conseiller")
	private Conseiller conseiller;
	
	@OneToMany(mappedBy = "titulaire")
	private List<Compte> comptes;
	
	@OneToMany(mappedBy = "proprietaire")
	private List<Carte> cartesBancaires;


	public Client() {
	}

	/**
	 * ctor charg�
	 * 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param telephone
	 */
	public Client(int id, String nom, String prenom, String adresse, String codePostal, String ville, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}

	/**
	 * ctor charg� sans Id
	 * 
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param telephone
	 */
	public Client(String nom, String prenom, String adresse, String codePostal, String ville, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}

	/*********************
	 * GETTERS & SETTERS
	 ********************/
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public List<Carte> getCartesBancaires() {
		return cartesBancaires;
	}

	public void setCartesBancaires(List<Carte> cartesBancaires) {
		this.cartesBancaires = cartesBancaires;
	}
}
