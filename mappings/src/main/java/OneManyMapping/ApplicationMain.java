package OneManyMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import OneManyMapping.entities.Laptop;
import OneManyMapping.entities.Person;
import databaseOperation.DatabaseOperation;
/*One person Can have many laptops 
 * hence its a one to many relation
 * Since many laptop can belong to one person hence is many to one opeation*/
public class ApplicationMain {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationMain.class);

	public static void main(String[] args) {

		Person person = new Person();
		
		List<Laptop> listOfLaptops = initializePersonandLaptops(person);
		System.out.println("Checking list size "+listOfLaptops.size());
		//to initialize the person and laptop objects 
		if(DatabaseOperation.executeDatabaseInsertOperation(person,listOfLaptops)) {
			logger.info("Inside One One mapping with hibernate end ...");
		}
		
	}

	public static List<Laptop> initializePersonandLaptops(Person person) {
		List<Laptop> listOfLaptops=new ArrayList<Laptop>();
		try {
			logger.info("initializePersonandLaptops objects START...");
			listOfLaptops = Arrays.asList(new Laptop(1, "DELL", person), new Laptop(2, "HP", person),
					new Laptop(3, "Lenovo", person), new Laptop(4, "MAC", person));
			person.setPerId(194);
			person.setPname("Abhirup Chatterjee");
			person.setListOfLaptops(listOfLaptops);
			logger.info("initializePersonandLaptops objects END...");
		} catch (Exception ex) {
			logger.debug("Unable to initialize Laptop and Person Objects");
			ex.printStackTrace();
		}
		return listOfLaptops;
	}
}
