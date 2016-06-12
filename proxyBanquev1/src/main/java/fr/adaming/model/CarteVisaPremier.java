package fr.adaming.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe concrete CarteVisaPremier dont les instances dans la BDD auront "premier" pour valeur
 * dans la colonne "typeCarte" de la table "cartes".
 * Tous ses attributs et methodes sont definis dans la classe Carte
 *
 */
@Entity(name="carteVisaPremier")
@Table(name="carte_visa_premier")
@DiscriminatorValue("premier")
public class CarteVisaPremier extends Carte {

}
