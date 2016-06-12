package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;

@Repository
@Transactional
public class CompteDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	// Setter pour l'injection
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Transactional(readOnly=false)
	public void add(Compte c) {
		Session session = sessionFactory.openSession();
		Transaction t  = session.beginTransaction();
		session.save(c);
		session.flush();
		t.commit();
		session.close();
	}

	
	@Transactional(readOnly=false)
	public void updateSolde(Compte c) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		String updateReq = 	"UPDATE compte c SET " +
							"c.solde = :solde "+
					        "WHERE c.numeroCompte = :numCompte";
		Query query = session.createQuery(updateReq);
		query.setParameter("solde", c.getSolde());
		query.setParameter("numCompte", c.getNumeroCompte());
		query.executeUpdate();
		session.flush();
		t.commit();
		session.close();
	}

	
	@Transactional(readOnly=false)
	public void delete(Compte c) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		Compte compte = (Compte) session.load(Compte.class, c.getNumeroCompte());
		
		session.delete(compte);
		session.flush();
		t.commit();
		session.close();
	}

	
	@Transactional(readOnly=true)
	public Compte getById(Integer numeroCompte) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM compte c WHERE c.numeroCompte = :compteNumero");
		query.setParameter("compteNumero", numeroCompte);
		
		Compte c = (Compte) query.uniqueResult();
		session.flush();
		session.close();
		
		return c;
	}
	
	
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<Compte> getAll() {
		Session session = sessionFactory.openSession();
		
		List<Compte> listComptes =  session.createQuery("FROM compte").list();
		
		session.flush();
		session.close();
		
		return listComptes;
	}

	
	/**
	 * Methode effectuant un virement entre deux comptes
	 * @param compteADebiter numero du compte a debiter
	 * @param compteACrediter numero du compte a crediter
	 * @param montant montant a transferer
	 * @return vrai si le virement a pu etre effectue sans problemes
	 */
	@Transactional(readOnly=false)
	public boolean virement(Integer compteADebiter, Integer compteACrediter, double montant) {
		// Recuperation des deux comptes depuis la BDD
		Compte c1 = getById(compteADebiter);
		Compte c2 = getById(compteACrediter);
		
		// Si compte debiteur courant, verif qu'on ne depasse pas le decouvert
		if (c1.getClass().getSimpleName().equals("CompteCourant")) {
			if (c1.getSolde() - montant < ((CompteCourant) c1).getDecouvertAutoris()*-1) {
				return false;
			}
		} else {
			// Si compte debiteur epargne, verifier que le solde est suffisat
			if (c1.getSolde() < montant)
				return false;
		}
		// Tout est ok, MAJ des comptes dans la BDD
		c1.setSolde(c1.getSolde() - montant);
		c2.setSolde(c2.getSolde() + montant);
		updateSolde(c1);
		updateSolde(c2);
		return true;
	}
}





