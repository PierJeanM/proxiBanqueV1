package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.ConseillerDAO;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;

@Service
public class ConseillerService {
	
	@Autowired
	private ConseillerDAO conseillerDAO;
	
	
	public ConseillerService() {
	}

	public void add(Conseiller conseiller) {
		conseillerDAO.add(conseiller);	
	}

	public void update(Conseiller t) {
		//TODO
	}

	public void delete(Conseiller t) {
		//TODO
	}

	public Conseiller getById(int id) {
		//TODO
		return null;
	}

	public List<Conseiller> getAll() {
		return conseillerDAO.getAll();
	}
	
	
	public List<Client> getClientsOf(Conseiller c){
		return conseillerDAO.getClientsOf(c);
	}
}
