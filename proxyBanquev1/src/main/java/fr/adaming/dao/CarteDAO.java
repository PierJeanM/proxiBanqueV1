package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Carte;

@Repository
@Transactional
public class CarteDAO{
	
	@Autowired // injection automatique
	private SessionFactory sessionFactory;
	
	// Setter pour l'injection
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	public void add(Carte c) {
		Session session = sessionFactory.openSession();
		Transaction t  = session.beginTransaction();
		session.save(c);
		session.flush();
		t.commit();
		session.close();
	}


	public void update(Carte c) {
		// TODO Auto-generated method stub
		
	}


	public void delete(Carte c) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		Carte card = (Carte) session.load(Carte.class, c.getNumeroCarte());
		
		session.delete(card);
		session.flush();
		t.commit();
		session.close();
	}


	public Carte getById(String numero) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM carte c WHERE c.numeroCarte = :carteNumero");
		query.setParameter("carteNumero", numero);
		
		return (Carte) query.uniqueResult();
	}


	@SuppressWarnings("unchecked")
	public List<Carte> getAll() {
		Session session = sessionFactory.openSession();
		
		return session.createQuery("FROM carte").list();
	}
}
