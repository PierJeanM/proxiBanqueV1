package fr.adaming.managedBean;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.dao.ClientDAO;
import fr.adaming.model.Client;
import fr.adaming.service.ClientService;

@ManagedBean
public class ClientMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClientService clientService;
	
	public ClientMB() {
		clientService = new ClientService();
		// TODO Auto-generated constructor stub
	}
	
	
	public void addClient(Client client){
		clientService.add(client);
	}
	
	
	
	
	
}
