package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.service.ConseillerService;

@ManagedBean
public class ConseillerMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private ConseillerService conseillerService;
	
	
	private Conseiller conseiller;

	public ConseillerMB() {

		conseillerService = new ConseillerService();
		conseiller = new Conseiller();
	}

	public List<Client> getClientsOf() {
		return conseillerService.getClientsOf(conseiller);
	}

	
	
	
	/******************
	 * GETTERS & SETTERS
	 *****************/
	
	public ConseillerService getConseillerService() {
		return conseillerService;
	}

	public void setConseillerService(ConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	
	
}
