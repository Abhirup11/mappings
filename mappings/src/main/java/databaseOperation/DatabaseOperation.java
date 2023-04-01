package databaseOperation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import OneManyMapping.entities.Laptop;
import OneManyMapping.entities.Person;
import oneOneMapping.entities.Answer;
import oneOneMapping.entities.Question;
import sessionFactoryInitialization.SessionFactoryInitialization;

public class DatabaseOperation {

	private static final Logger logger = LoggerFactory.getLogger(DatabaseOperation.class);

	public static boolean executeDatabaseInsertOperation(Question question, Answer answer) {

		try {
			SessionFactory factory = SessionFactoryInitialization.getSessionFactory();
			logger.info("Opening Session ...");
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(question);
			session.save(answer);
			tx.commit();
			logger.info("Closing Session ...");
			session.close();
			logger.info("Closing SessionFactory ...");
			factory.close();
			return true;
		} catch (Exception ex) {
			logger.error("Unable to perform database insert operation");
			ex.printStackTrace();
			return false;
		}

	}

	public static boolean executeDatabaseInsertOperation(Person person, List<Laptop> listOfLaptops) {
		try {
			SessionFactory factory = SessionFactoryInitialization.getSessionFactory();
			logger.info("Opening Session ...");
			System.out.println(listOfLaptops.size());
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(person);
			session.save(listOfLaptops.get(0));
			session.save(listOfLaptops.get(1));
			session.save(listOfLaptops.get(2));
			session.save(listOfLaptops.get(3));
			tx.commit();
			logger.info("Closing Session ...");
			session.close();
			logger.info("Closing SessionFactory ...");
			factory.close();
			return true;
		} catch (Exception ex) {
			logger.error("Unable to perform database insert operation");
			ex.printStackTrace();
			return false;
		}
	}
}
