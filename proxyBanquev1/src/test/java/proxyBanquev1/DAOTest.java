package proxyBanquev1;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.dao.*;
import fr.adaming.model.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class DAOTest {

	@Autowired
	ClientDAO clientDAO;
	
	@Autowired
	CompteDAO compteDAO;
	
	@Test
	public void testClientDAO(){
		// verif du nombre de clients dans la BDD
		//assertEquals(2, clientDAO.getAll().size());
		
		// verif du fonctionnement de l'ajout client
		Client c = new Client();
		clientDAO.add(c);
		assertEquals(c.getId(), clientDAO.getById(c.getId()).getId());
		
		clientDAO.delete(c);
		
		System.out.println("Fin des tests clientDAO");
	}
	
	/**
	 * Test du DAO Compte, en particulier de la fonctionnalite virement.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testCompteDAO(){
				
		Client client1 = new Client("Rambo", "John", "Rue de la guerre", "32000", "Vietnam", "12");
		clientDAO.add(client1);

		Compte compte1 = new CompteCourant(1200.0, new Date(2016, 11, 11), client1);
		Compte compte2 = new CompteEpargne(0.0, new Date(2016, 11, 11), client1);
		compteDAO.add(compte1);
		compteDAO.add(compte2);
		
		assertEquals(false, compteDAO.virement(compte1.getNumeroCompte(), compte2.getNumeroCompte(), 2500.0));
		assertEquals(true, compteDAO.virement(compte1.getNumeroCompte(), compte2.getNumeroCompte(), 100.0));
		assertEquals(false, compteDAO.virement(compte2.getNumeroCompte(), compte1.getNumeroCompte(), 101.0));
		assertEquals(true, compteDAO.virement(compte2.getNumeroCompte(), compte1.getNumeroCompte(), 100.0));
		assertEquals(true, compteDAO.virement(compte1.getNumeroCompte(), compte2.getNumeroCompte(), 1300.0));
		assertEquals(true, compteDAO.virement(compte1.getNumeroCompte(), compte2.getNumeroCompte(), 900.0));
		
		compteDAO.delete(compte2);
		compteDAO.delete(compte1);
		clientDAO.delete(client1);
		
		System.out.println("Fin des tests compteDAO");
	}
}
