import javax.faces.bean.ManagedBean;

import fr.adaming.dao.ClientDAO;
import fr.adaming.model.Client;
import fr.adaming.service.ClientService;

@ManagedBean
public class ClientMB {

	private ClientService clientService;
	
	public ClientMB() {
		clientService = new ClientService();
		// TODO Auto-generated constructor stub
	}
	
	public void addClient(Client client){
		clientService.add(client);
	}
	
	
	
}
