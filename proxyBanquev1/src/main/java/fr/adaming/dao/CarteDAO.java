package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import fr.adaming.model.Carte;
import fr.adaming.tools.HibernateUtil;

public class CarteDAO implements IDAO<Carte> {
	
	@Autowired // injection automatique
	private SessionFactory sessionFactory;
	
	public CarteDAO() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	// Setter pour l'injection
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	public void add(Carte c) {
		Session session = sessionFactory.openSession();
		Transaction t  = session.beginTransaction();
		session.save(c);
		t.commit();
	}


	public void update(Carte c) {
		// TODO Auto-generated method stub
		
	}


	public void delete(Carte c) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		Carte card = (Carte) session.load(Carte.class, c.getId());
		
		session.delete(card);
		t.commit();
	}


	public Carte getById(int id) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Carte c WHERE c.id = :carteID");
		query.setParameter("carteID", id);
		
		return (Carte) query.uniqueResult();
	}


	@SuppressWarnings("unchecked")
	public List<Carte> getAll() {
		Session session = sessionFactory.openSession();
		
		return session.createQuery("FROM Carte").list();
	}
}
