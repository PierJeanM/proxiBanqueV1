package fr.adaming.managedBean;
import java.io.Serializable;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.model.Client;
import fr.adaming.service.IService;

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
	private IService<Client> clientService;
	
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
		clientService.add(client);
	}


	public void setClientService(IService<Client> clientService) {
		this.clientService = clientService;
	}
}
