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
 * Implementation DAO pour la classe Client
 * @author INTI-0232
 *
 */
@Repository
@Transactional
public class ClientDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	// Setter pour l'injection
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Transactional(readOnly=false)
	public void add(Client c) {
		Session session = sessionFactory.openSession();
		Transaction t  = session.beginTransaction();
		session.save(c);
		session.flush();
		t.commit();
		session.close();
	}

	
	@Transactional(readOnly=false)
	public void update(Client c) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		String updateReq = 	"UPDATE client as c SET " +
							"c.nom = :nom," +
					        "c.prenom = :prenom," +
					        "c.adresse = :adresse," +
					        "c.codePostal = :CP," +
					        "c.ville = :ville," +
					        "c.telephone = :tel," +
					        "c.id_conseiller = :conseiller" +
					        "WHERE c.id_client = :clientID";
		Query query = session.createQuery(updateReq);
		query.setParameter("clientID", c.getId());
		query.setParameter("nom", c.getNom());
		query.setParameter("prenom", c.getPrenom());
		query.setParameter("adresse", c.getAdresse());
		query.setParameter("CP", c.getCodePostal());
		query.setParameter("tel", c.getTelephone());
		query.setParameter("conseiller", c.getConseiller());
		query.setParameter("ville", c.getVille());
		query.executeUpdate();
		session.flush();
		t.commit();
		session.close();
	}

	
	@Transactional(readOnly=false)
	public void delete(Client c) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		Client clt = (Client) session.load(Client.class, c.getId());
		
		session.delete(clt);
		session.flush();
		t.commit();
		session.close();
	}

	
	@Transactional(readOnly=true)
	public Client getById(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM client c WHERE c.id = :clientID");
		query.setParameter("clientID", id);
		
		return (Client) query.uniqueResult();
	}
	
	
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<Client> getAll() {
		Session session = sessionFactory.openSession();
		
		return session.createQuery("FROM client").list();
	}
}
