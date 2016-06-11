package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.model.Client;
import fr.adaming.model.Conseiller;
import fr.adaming.service.ConseillerService;
import fr.adaming.service.IService;

@ManagedBean
@SessionScoped
@Component
public class ConseillerMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IService<Conseiller> conseillerService;
	private Conseiller conseiller;
	private List<Conseiller> listConseillers;
	
	public ConseillerMB() {
		conseiller = new Conseiller();
	}

	public List<Client> getClientsOf() {
		return ((ConseillerService) conseillerService).getClientsOf(conseiller);
	}

	
	
	/******************
	 * GETTERS & SETTERS
	 *****************/

	public void setConseillerService(ConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}

	public Conseiller getConseiller() {
		return conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}
	
	public List<Conseiller> getListConseillers() {
		return listConseillers;
	}

	public void setListConseillers(List<Conseiller> listConseillers) {
		this.listConseillers = listConseillers;
	}

	/**
	 * Méthode appelée lors du login du conseiller (page Index.xhtml)
	 */
	public String login(){
		listConseillers = conseillerService.getAll();

		for (Conseiller c : listConseillers) {
			if (c.getId().equals(conseiller.getId()) && c.getNom().equals(conseiller.getNom()) &&
				c.getPrenom().equals(conseiller.getPrenom())) {
				return "/pages/homepage.xhtml?faces-redirect=true";
			}
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Un ou plusieurs champs sont incorrects"));
		return null;
	}
}
