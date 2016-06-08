package fr.adaming.managedBean;

import java.io.Serializable;

import javax.annotation.ManagedBean;

@ManagedBean
public class ConseillerMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ConseillerService conseillerService;
	
	public ConseillerMB() {
		
		conseillerService = new ConseillerMB();
	}
	
	
	
	

}
