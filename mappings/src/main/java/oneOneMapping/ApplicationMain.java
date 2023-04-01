package oneOneMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import databaseOperation.DatabaseOperation;
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
		if (DatabaseOperation.executeDatabaseInsertOperation(question, answer)) {
			logger.info("Inside One One mapping with hibernate end ...");
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

}
