package Main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Address;
import Model.Bank;
import Model.CreditCard;
import Model.Person;
import Model.Pincode;

public class Main {
	 private static final String PERSISTENCE_UNIT_NAME = "banking";
	    private static EntityManagerFactory factory;

	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        //Query q = em.createQuery("select t from Todo t");
        //List<Todo> todoList = q.getResultList();
        //for (Todo todo : todoList) {
            //System.out.println(todo);
        //}
        //System.out.println("Size: " + todoList.size());

        // create new todo
        em.getTransaction().begin();
        Person person = new Person();
        Bank bank = new Bank();
        Pincode pincode = new Pincode();
        CreditCard card = new CreditCard();
        Address address = new Address();
        
        //Person
        
        //Pincode
        pincode.setCount(2);
        pincode.setPincode("1337");
        //Pincode done
        
        //CreditCard
        card.setBalance(420000);
        card.setLimit(69);
        card.setNumber(694201337);
        card.setPincode(pincode);
        
        //Bank
        bank.setName("ToBigToFail");
        List<CreditCard> cards = new ArrayList<CreditCard>();
        cards.add(card);
        bank.setCards(cards);
        //Bank Done
        card.setBank(bank);
        //Card done
        //Address
        address.setNumber(1363);
        address.setStreet("Elite Street"); 
        //Person
        person.setName("Are");
        List<CreditCard> cards2 = new ArrayList<CreditCard>();
        cards2.add(card);
        person.setCreditcards(cards2);
        
        List<Address> addresses = new ArrayList<Address>();
        addresses.add(address);
        
        person.setPeopleOnAddress(addresses);
        List<Person> persons = new ArrayList<Person>();
        persons.add(person);
        
        address.setAddresses(persons);
        //person.setCreditcards();
        em.persist(pincode);
        em.persist(bank);
        em.persist(card);
        em.persist(person);
        em.persist(address);
       
        em.getTransaction().commit();

        em.close();
	}

}
