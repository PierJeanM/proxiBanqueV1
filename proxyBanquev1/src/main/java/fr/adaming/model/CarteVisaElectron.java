package fr.adaming.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe concrete CarteVisaElectron dont les instances dans la BDD auront "electron" pour valeur
 * dans la colonne "typeCarte" de la table "cartes".
 * Tous ses attributs et methodes sont definis dans la classe Carte
 *
 */
@Entity(name="carteVisaElectron")
@Table(name="carte_visa_electron")
@DiscriminatorValue("electron")
public class CarteVisaElectron extends Carte {
	
}
