package Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private String id;
	private String Name;
	@ManyToMany	
	@JoinTable (name="jnd_pers_addr",
		joinColumns = @JoinColumn(name = "person_fk"),
		inverseJoinColumns = @JoinColumn(name = "address_fk"))
    private List<Address> peopleOnAddress;
	
	@OneToMany
	//@JoinColumn(name = "CreditCardId")
	private List<CreditCard> creditcards;
	
	
	public String getId() {
        return id;
    }
	
    public void setId(String Id) {
        this.id = Id;
    }
    
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		this.Name = name;
	}

	public List<Address> getPeopleOnAddress() {
		return peopleOnAddress;
	}

	public void setPeopleOnAddress(List<Address> peopleOnAddress) {
		this.peopleOnAddress = peopleOnAddress;
	}

	public List<CreditCard> getCreditcards() {
		return creditcards;
	}

	public void setCreditcards(List<CreditCard> creditcards) {
		this.creditcards = creditcards;
	}
	
	

	
}
