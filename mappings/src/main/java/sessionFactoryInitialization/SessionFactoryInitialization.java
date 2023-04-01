package sessionFactoryInitialization;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionFactoryInitialization {
	private static final Logger logger = LoggerFactory.getLogger(SessionFactoryInitialization.class);
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration();
		Configuration configure = configuration.configure("hibernate.cfg.xml");
		logger.info("Perform configuration from hibernate.cfg.xml - Success "+configure);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		logger.info("SessionFactory Object Creation - Success "+sessionFactory);
		return sessionFactory;
	}
}
