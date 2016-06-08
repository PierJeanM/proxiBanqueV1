package fr.adaming.model;

/**
 * Classe Carte Bancaire, à étendre par Visa Electron, Visa Premier
 * @author INTI-0232
 *
 */
public abstract class Carte {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
