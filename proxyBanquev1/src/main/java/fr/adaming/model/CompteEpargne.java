package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@Entity(name="compteEpargne")
@Table(name="comptes_epargnes")
public class CompteEpargne extends Compte {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_compte")
	private int idCompte;
	@Column(name="remuneration")
	private int remuneration = 3;

	public int getRemuneration() {
		return remuneration;
	}
	
	public CompteEpargne() {
		super();
		
	}

}
