package proxyBanquev1;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.dao.ClientDAO;
import fr.adaming.model.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class DAOTest {

	@Autowired
	ClientDAO clientDAO;
	
	@Test
	public void test(){
		// verif du nombre de clients dans la BDD
		//assertEquals(2, clientDAO.getAll().size());
		
		// verif du fonctionnement de l'ajout client
		Client c = new Client();
		clientDAO.add(c);
		assertEquals(c.getId(), clientDAO.getById(c.getId()).getId());
		System.out.println("Fin des tests");
	}
}
