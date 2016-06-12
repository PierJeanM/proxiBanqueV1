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
import fr.adaming.service.CompteService;
import fr.adaming.service.ConseillerService;

@ManagedBean
@SessionScoped
@Component
public class ConseillerMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ConseillerService conseillerService;
	@Autowired
	private CompteService compteService;
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
		System.out.println("==========>"+conseillerService);
		listConseillers = conseillerService.getAll();
		
		for (Conseiller c : listConseillers) {
			if (c.getId().equals(conseiller.getId())) {
				return "/pages/homepage.xhtml?faces-redirect=true";
			}
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Un ou plusieurs champs sont incorrects"));
		return null;
	}
	
	
	public boolean virement(){
		///compteService.vi
		return false;
	}
}
