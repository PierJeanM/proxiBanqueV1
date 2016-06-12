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
		listConseillers = conseillerService.getAll();

		for (Conseiller c : listConseillers) {
			if (c.getId().equals(conseiller.getId())) {
				setConseiller(c);
				return "/pages/homepage.xhtml?faces-redirect=true";
			}
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Un ou plusieurs champs sont incorrects"));
		return null;
	}
	
	
	/** 
	 * Logout du conseiller
	 * @return 
	 */
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index.xhtml?faces-redirect=true";
	}
	
	
	public void virement(){
		
		Integer debiteur = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("adminLoginForm:compteDebite"));
		Integer crediteur = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("adminLoginForm:compteCredite"));
		double montant = Double.parseDouble(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("adminLoginForm:montant"));
		
		if (compteService.virement(debiteur, crediteur, montant)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Virement effectué avec succès"));
		} else {
			//TODO mettre un message d'erreur selon l'erreur
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le virement n'a pas pu être effectué.", null));
		}
	}
}
