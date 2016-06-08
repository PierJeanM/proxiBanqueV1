package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.ClientDAO;
import fr.adaming.model.Client;

public class ClientService implements IService<Client>{

	private ClientDAO clientDAO;
	
	public ClientService() {
		clientDAO = new ClientDAO();
		
	}
	
	public void add(Client client) {
		clientDAO.add(client);
		
	}

	public void update(Client t) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Client t) {
		// TODO Auto-generated method stub
		
	}

	public Client getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
