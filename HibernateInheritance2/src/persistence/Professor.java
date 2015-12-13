package persistence;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="professor")
@AttributeOverrides({  
    @AttributeOverride(name="id", column=@Column(name="id")),  
    @AttributeOverride(name="first_name", column=@Column(name="first_name")),
    @AttributeOverride(name="last_name", column=@Column(name="last_name"))
})  
public class Professor extends Member{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3830341028389658333L;		
    
    @Column(name = "salary")
    private Double salary;
        
    public Professor() {
		super();
    		this.salary = 0.0;
	}
    
    public Professor(Integer id, String firstName, String lastName, Double salary) {
		super(id, firstName, lastName);
		this.salary = salary;
	}
	
	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
