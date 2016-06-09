package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.ConseillerDAO;
import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;

public class ConseillerService implements IService<Conseiller>{
	
	private ConseillerDAO conseillerDAO;
	
	public ConseillerService() {
		conseillerDAO = new ConseillerDAO();
	}

	public void add(Conseiller conseiller) {
		conseillerDAO.add(conseiller);	
		
	}

	public void update(Conseiller t) {
		
		
	}

	public void delete(Conseiller t) {
		
		
	}

	public Conseiller getById(int id) {
		
		return null;
	}

	public List<Conseiller> getAll() {
		
		return null;
	}
	
	public List<Client> getClientsOf(Conseiller c){
		
		return conseillerDAO.getClientsOf(c);
		
	}

}
