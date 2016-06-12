package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.ClientDAO;
import fr.adaming.model.Client;

@Service
public class ClientService {

	@Autowired
	private ClientDAO clientDAO;
	
	public ClientService() {
	}
	
	public void add(Client client) {
		clientDAO.add(client);
	}

	public void update(Client t) {
		// TODO
	}

	public void delete(Client t) {
		// TODO
	}

	public Client getById(int id) {
		// TODO
		return null;
	}

	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
