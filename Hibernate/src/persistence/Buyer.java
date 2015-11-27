public class Buyer {

}

public class Buyer {
	   private int id;
	   private String firstName; 
	   private String lastName; 
	   private String Product;
	   private int Amount;  

	   public Buyer() {}
	   public Buyer(String fname, String lname,  int Amount, String Product) 
	   {
	      this.firstName = fname;
	      this.lastName = lname;
	      this.Product = product;
	      this.Amount = amount;
	   }
	   public int getId() {
	      return id;
	   }
	   public void setId( int id ) {
	      this.id = id;
	   }
	   public String getFirstName() {
	      return firstName;
	   }
	   public void setFirstName( String first_name ) {
	      this.firstName = first_name;
	   }
	   public String getLastName() {
	      return lastName;
	   }
	   public void setLastName( String last_name ) {
	      this.lastName = last_name;
	   }
	   
	   public String getProduct() {
		      return product;
		   }
		   public void setProduct( String Product) {
		      this.product = product;
		   }
	   public int getAmount() {
	      return amount;
	   }
	   public void setAmount( int amount ) {
	      this.amount = amount;
	   
	}
	
	create table Buyer (
	   id INT NOT NULL auto_increment,
	   first_name VARCHAR(20) default NULL,
	   last_name  VARCHAR(20) default NULL,
	   product  VARCHAR(20) default NULL,
	   amount     INT  default NULL,
	   PRIMARY KEY (id)
	);
