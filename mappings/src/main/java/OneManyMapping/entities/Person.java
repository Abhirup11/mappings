package OneManyMapping.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {

	public Person() {
		super();
	}

	@Id
	@Column(name = "PersonId")
	private int perId;

	@Column(name = "PersonName")
	private String pname;

	@OneToMany(mappedBy = "person")
	private List<Laptop> listOfLaptops;

	public Person(int perId, String pname, List<Laptop> listOfLaptops) {
		super();
		this.perId = perId;
		this.pname = pname;
		this.listOfLaptops = listOfLaptops;
	}

	public int getPerId() {
		return perId;
	}

	public void setPerId(int perId) {
		this.perId = perId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public List<Laptop> getListOfLaptops() {
		return listOfLaptops;
	}

	public void setListOfLaptops(List<Laptop> listOfLaptops) {
		this.listOfLaptops = listOfLaptops;
	}

}
