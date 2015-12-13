package persistence;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="student")
@AttributeOverrides({  
    @AttributeOverride(name="id", column=@Column(name="id")),  
    @AttributeOverride(name="first_name", column=@Column(name="first_name")),
    @AttributeOverride(name="last_name", column=@Column(name="last_name"))
})  
public class Student extends Member {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3420031242749790888L;

	@Column(name = "avgScore")
	private Double avgScore;

	public Student() {
		super();
		avgScore = 0.0;
	}

	public Student(Integer id, String firstName, String lastName, Double avgScore) {
		super(id, firstName, lastName);
		this.avgScore = avgScore;
	}

	public Double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(Double avgScore) {
		this.avgScore = avgScore;
	}	
}
