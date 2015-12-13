package persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4619651034034731538L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")	
	private Integer id;
	
	@Column(name = "first_name", length = 255, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 255, nullable = false)
	private String lastName;

	@ElementCollection
    @CollectionTable(name="mobile_numbers", joinColumns=@JoinColumn(name="person_id"))
    @Column(name="number")
	private Set<String> mobileNumbers;
	
	@ElementCollection
	@CollectionTable(name="addresses", joinColumns=@JoinColumn(name="person_id"))
	private List<Address> addresses; 
	
	public Person() {
		id = 0;
		firstName = "";
		lastName = "";
		mobileNumbers = new HashSet<String>();
		addresses = new ArrayList<Address>();
	}
	
	public Person(Integer id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		mobileNumbers = new HashSet<String>();
		addresses = new ArrayList<Address>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Set<String> getMobileNumbers() {
		return mobileNumbers;
	}		

	public void setMobileNumbers(Set<String> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}
	
	public void addMobileNumber(String mobile) {
		this.mobileNumbers.add(mobile);
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public void addAddress(Address address) {
		this.addresses.add(address);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder s = new StringBuilder();
		s.append(id + ": " + firstName + " - " + lastName);
		for(String mobile : mobileNumbers)
			s.append(" - " + mobile);

		return s.toString();
	}
}
