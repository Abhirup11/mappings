package oneOneMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oneOneMapping.entities.Answer;
import oneOneMapping.entities.Question;

public class ApplicationMain {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationMain.class);

	public static void main(String[] args) {

		logger.info("Inside One One mapping with hibernate start ...");

		Question question = new Question();
		Answer answer = new Answer();
		initializeQuestionAnswerObject(question, answer);

		// open session
		if (executeDatabaseInsertOperation(question, answer)) {
			logger.info("Inside One One mapping with hibernate end ...");
		}

	}

	private static boolean executeDatabaseInsertOperation(Question question, Answer answer) {

		try {
			SessionFactory factory = getSessionFactory();
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

	private static void initializeQuestionAnswerObject(Question question, Answer answer) {
		question.setQuestionId(1);
		question.setQuestion("What is spring boot ?");
		question.setAnswer(answer);
		answer.setAnswerId(100);
		answer.setAnswer("Spring boot is a framwork for rapid application development");
		answer.setQuestion(question);
	}

	private static SessionFactory getSessionFactory() {
		logger.info("Inside getSessionFactory() start ...\n");
		Configuration configuration = new Configuration();
		Configuration configure = configuration.configure("hibernate.cfg.xml");
		logger.info("configured using hibernate.cfg.xml  ...\n");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		logger.info("Session factory object created success ...\n");
		return sessionFactory;
	}
}
