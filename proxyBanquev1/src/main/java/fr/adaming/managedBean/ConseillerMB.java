package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;

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

	public List<Client> getClientsOf(Conseiller c) {
		return conseillerService.getClientsOf(c);
	}

}
