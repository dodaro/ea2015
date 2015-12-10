package persistence;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("student") 
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
