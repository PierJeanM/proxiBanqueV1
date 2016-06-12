package fr.adaming.managedBean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class NavigationControler implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String includedPage="homepage.xhtml";


	public NavigationControler() {
		super();
	}


	public String getIncludedPage() {
		return includedPage;
	}


	public void setIncludedPage(String includedPage) {
		this.includedPage = includedPage;
	}
	
	public String goNav() {
		   FacesContext context = FacesContext.getCurrentInstance();
		   String selectedPageViewId = context.getExternalContext().getRequestParameterMap().get("ajouterClient");
		   if (selectedPageViewId.equalsIgnoreCase("pageAjoutClient")){
		        includedPage = "ajouterClient.xhtml?faces-redirect=true";
		    }
	
	return includedPage;
	}
	
	
}
