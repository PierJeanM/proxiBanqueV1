package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.CompteDAO;
import fr.adaming.model.Compte;

@Service
public class CompteService {
	
	@Autowired
	private CompteDAO compteDAO;


	public void add(Compte c) {
		compteDAO.add(c);		
	}


	public void update(Compte c) {
		compteDAO.updateSolde(c);
	}


	public void delete(Compte c) {
		compteDAO.delete(c);
	}


	public Compte getById(int numeroCompte) {
		return compteDAO.getById(numeroCompte);
	}


	public List<Compte> getAll() {
		return compteDAO.getAll();
	}
	
	public boolean virement(Integer compteADebiter, Integer compteACrediter, double montant){
		return compteDAO.virement(compteADebiter, compteACrediter, montant);
	}

}
