package fr.adaming.managedBean;
import java.io.Serializable;





import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.model.Client;
import fr.adaming.service.ClientService;

/**
 * Managed Bean du client
 * @author INTI-0247
 *
 */
@ManagedBean
@SessionScoped
@Component
public class ClientMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClientService clientService;
	
	private Client client;
	
	public ClientMB() {
		client = new Client();
	}
	
	
	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public void addClient(){
		// Recupere le managedbean conseiller pour que le nouveau client y soit associe
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		ConseillerMB conseiller = (ConseillerMB) context.getELResolver().getValue(context, null, "conseillerMB");
		client.setConseiller(conseiller.getConseiller());
		clientService.add(client);
	}


	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
}
