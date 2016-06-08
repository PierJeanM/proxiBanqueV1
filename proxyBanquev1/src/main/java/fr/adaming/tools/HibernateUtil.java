package fr.adaming.tools;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Classe utilitaire Hibernate pour g�n�rer une
 * sessionFactory.
 *
 * @author INTI-0232
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
	static {
		try {
            // Cree la SessionFactory � partir du fichier de config (hibernate.cfg.xml)
			Configuration configuration = new Configuration();
		    configuration.configure();
		    ServiceRegistry  serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			// Gestion exception
			System.err.println("Erreur lors de la cr�ation de la SessionFactory." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
