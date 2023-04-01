package OneManyMapping.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop { // One person can have many laptops

	public Laptop() {
		super();
	}

	@Id
	@Column(name = "LAPTOP_ID")
	private int lapId;

	@Column(name = "LAPTOP_NAME")
	private String lname;

	@ManyToOne
	private Person person;

	public Laptop(int lapId, String lname, Person person) {
		super();
		this.lapId = lapId;
		this.lname = lname;
		this.person = person;
	}

	public int getLapId() {
		return lapId;
	}

	public void setLapId(int lapId) {
		this.lapId = lapId;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
