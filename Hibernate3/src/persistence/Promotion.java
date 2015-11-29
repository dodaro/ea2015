package persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "promotion")
public class Promotion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3830341028389658333L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name = "begin_date", nullable = false)
	private Date beginDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", nullable = false)
	private Date endDate;

	@Column(name = "discount", nullable = false)
	private Integer discount;

	@ManyToMany
	@JoinTable(name = "offer", joinColumns = @JoinColumn(name = "promotion_id") , inverseJoinColumns = @JoinColumn(name = "user_id") )
	private List<User> users;

	public Promotion() {
		this.id = 0;
		this.beginDate = new Date();
		this.endDate = new Date();
		this.discount = 0;
		this.users = new ArrayList<User>();
	}

	public Promotion(Integer id, Date beginDate, Date endDate, Integer discount) {
		this.id = id;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.discount = discount;
		this.users = new ArrayList<User>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void addUser(User user) {
		users.add(user);
	}

}
