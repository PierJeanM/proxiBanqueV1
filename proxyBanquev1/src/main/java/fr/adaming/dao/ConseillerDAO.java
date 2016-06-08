package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;

public class ConseillerDAO implements IDAO<Conseiller> {
	
	@Autowired // injection automatique
	private SessionFactory sessionFactory;

	public void add(Conseiller c) {
		// TODO Auto-generated method stub
		
	}

	public void update(Conseiller c) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Conseiller c) {
		// TODO Auto-generated method stub
		
	}

	public Conseiller getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Conseiller> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> getClientsOf(Conseiller c) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Client c WHERE c.conseillerID = :cID");
		query.setParameter("cID", c.getId());
		return query.list();
	}
}
