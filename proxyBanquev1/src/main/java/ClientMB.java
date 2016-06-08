import javax.faces.bean.ManagedBean;

import fr.adaming.dao.ClientDAO;
import fr.adaming.model.Client;

@ManagedBean
public class ClientMB {

	private ClientDAO clientDAO;
	
	public ClientMB() {
		clientDAO = new ClientDAO();
		// TODO Auto-generated constructor stub
	}
	
	public void addClient(Client client){
		clientDAO.add(client);
	}
	
	
	
}
