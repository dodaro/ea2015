package persistence.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "purchases")
public class Purchase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8621140630838722201L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int ID;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false)
	private Date date;
	
	
	@ManyToOne
	@JoinColumn(name = "user_username")
	private User user_username;
	
	
	public Purchase() {

		this.ID = 0;
		this.date = null;
		this.user_username = null;
	}
	
	
	public Purchase(Date date, User user_username) {
		this();
		
		this.date = date;
		this.user_username = user_username;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public User getUser_username() {
		return user_username;
	}


	public void setUser_username(User user_username) {
		this.user_username = user_username;
	}
	

	@Override
	public String toString() {
		return "Purchase [ID=" + ID + ", date=" + date + ", user_username=" + user_username + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((user_username == null) ? 0 : user_username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Purchase other = (Purchase) obj;
		if (ID != other.ID)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (user_username == null) {
			if (other.user_username != null)
				return false;
		} else if (!user_username.equals(other.user_username))
			return false;
		return true;
	}
	
}
