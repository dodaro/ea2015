package persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="member")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Member implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4619651034034731538L;
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")	
	private Integer id;
	
	@Column(name = "first_name", length = 255, nullable = false)
	private String firstName;
	
	@Column(name = "last_name", length = 255, nullable = false)
	private String lastName;

	public Member() {
		id = 0;
		firstName = "";
		lastName = "";		
	}
	
	public Member(Integer id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + ": " + firstName + " - " + lastName;
	}
}
