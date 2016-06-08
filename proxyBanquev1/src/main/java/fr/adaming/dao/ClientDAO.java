package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Client;

/**
 * Implémentation DAO pour la classe Client
 * @author INTI-0232
 *
 */
@Repository
@Transactional
public class ClientDAO implements IDAO<Client> {
	
	@Autowired // injection automatique
	private SessionFactory sessionFactory;
	
	// Setter pour l'injection
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public void add(Client c) {
		Session session = sessionFactory.openSession();
		Transaction t  = session.beginTransaction();
		session.save(c);
		t.commit();
	}

	
	public void update(Client c) {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(Client c) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		Client clt = (Client) session.load(Client.class, c.getId());
		
		session.delete(clt);
		t.commit();
	}


	public Client getById(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Client c WHERE c.id = :clientID");
		query.setParameter("clientID", id);
		
		return (Client) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Client> getAll() {
		Session session = sessionFactory.openSession();
		
		return session.createQuery("FROM Client").list();
	}
}
