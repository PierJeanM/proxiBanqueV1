package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;

@Repository
@Transactional
public class ConseillerDAO{
	
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

	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<Conseiller> getAll() {
		Session session = sessionFactory.openSession();
		
		return session.createQuery("FROM conseiller").list();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Client> getClientsOf(Conseiller c) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM client c WHERE c.conseiller.id = :cID");
		query.setParameter("cID", c.getId());
		return query.list();
	}
}
