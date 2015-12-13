package persistence;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String street;
	private Integer number;

	public Address() {
		street = "";
		number = 0;
	}

	public Address(String street, Integer number) {
		this.street = street;
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
}
