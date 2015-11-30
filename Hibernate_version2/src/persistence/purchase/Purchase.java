package persistence.purchase;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import persistence.belongs.Belongs;
import persistence.product.Product;
import persistence.user.User;

@Entity
@Table(name = "purchases")
public class Purchase implements Serializable{

	private static final long serialVersionUID = -7899469781390036915L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "user")
	private User user;
	
	@OneToMany(mappedBy = "purchase", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Belongs> belongs = new ArrayList<>();
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false)
	private Date date;

	public Purchase(){
		
	}
	
	public Purchase(User user) {
		
		this.setUser(user);
		this.setDate(getDateQuietly());	
	}

	private Date getDateQuietly() {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			
			date = df.parse("2012-04-09 00:00:00");
			this.setDate(date);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Belongs> getBelongs() {
		return belongs;
	}

	public void setBelongs(List<Belongs> belongs) {
		this.belongs = belongs;
	}
}
