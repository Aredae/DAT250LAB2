package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
@Entity
public class CreditCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private int number;
	private int limit;
	private int balance;
	private Pincode pincode;
	@ManyToOne
	private Bank bank;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Pincode getPincode() {
		return pincode;
	}
	public void setPincode(Pincode pincode) {
		this.pincode = pincode;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	

}
