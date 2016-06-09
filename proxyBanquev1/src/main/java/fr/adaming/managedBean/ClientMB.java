package fr.adaming.managedBean;
import java.io.Serializable;


import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.model.Client;
import fr.adaming.service.ClientService;

/**
 * Managed Bean du client
 * @author INTI-0247
 *
 */
@ManagedBean
public class ClientMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private Client client;
	
	public ClientMB() {
		clientService = new ClientService();
		client = new Client();
		// TODO Auto-generated constructor stub
	}
	
	
	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public void addClient(Client client){
		clientService.add(client);
	}
	
	
	
	
	
}
