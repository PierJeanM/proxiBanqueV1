package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity(name="compteCourant")
@Table(name="comptes_courants")
@MappedSuperclass
public class CompteCourant extends Compte{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_compte")
	private int idCompte;
	@Column(name="decouvert_autorise")
	private int decouvertAutoris = 1000;
	
	public int getDecouvertAutoris() {
		return decouvertAutoris;
	}

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
