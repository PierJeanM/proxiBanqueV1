package fr.adaming.model;

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
 * Classe abstraite Carte qui possede une table dans la base qui contient cartes Premier
 * et cartes Electron. Une colonne "typeCarte" permet de differencier les deux.
 *
 */
@Entity
@Table(name="cartes")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeCarte")
public abstract class Carte {
	
	@Id
	@Column(name="numero_carte")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numeroCarte;
	
	@OneToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id_client")
	private Client proprietaire;
	
	
	public Carte() {
	}

	public Carte(Integer numeroCarte, Client proprietaire) {
		super();
		this.numeroCarte = numeroCarte;
		this.proprietaire = proprietaire;
	}

	public Integer getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(Integer numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	public Client getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Client proprietaire) {
		this.proprietaire = proprietaire;
	}
}
