package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.service.ConseillerService;
import fr.adaming.service.IService;

@ManagedBean
@SessionScoped
@Component
public class ConseillerMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IService<Conseiller> conseillerService;
	
	private Conseiller conseiller;

	public ConseillerMB() {
		conseiller = new Conseiller();
	}

	public List<Client> getClientsOf() {
		return ((ConseillerService) conseillerService).getClientsOf(conseiller);
	}

	
	
	/******************
	 * GETTERS & SETTERS
	 *****************/

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
