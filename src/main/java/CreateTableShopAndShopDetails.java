import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableShopAndShopDetails {
	static final String DB_URL = "jdbc:mysql://localhost:3306/shopSystem";
	  static final String USER = "root";
	  static final String PASS = "root";

	public boolean CreateTableShop () {
	try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        Statement stmt = conn.createStatement();
	     ) {      
	         String sql = "CREATE TABLE shop " +
	                  "(id int NOT NULL AUTO_INCREMENT, " +
	                  " Shop_Name   VARCHAR(100) not NULL, " +    
	                  " PRIMARY KEY ( id ))";
	         String sql1="ALTER TABLE shop AUTO_INCREMENT=1";
	         stmt.executeUpdate(sql);
	         stmt.executeUpdate(sql1);
	       
	      
	       
	        System.out.println("=====Table Shop Created Succeflly====");  
	       
	     } catch (SQLException e) {
	       System.out.println("Table Shop Not Created ");
	       System.out.println("=======================================");
	     }
	return false;
	  }
	
	public boolean CreateTableShopDetails () {
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		        Statement stmt = conn.createStatement();
		     ) {      
			String sql = "CREATE TABLE ShopDetails " + "(id int NOT NULL AUTO_INCREMENT, "
				    + "shop_id  INTEGER  ,"
					+ "FOREIGN KEY (shop_id) REFERENCES shop(id) ON DELETE CASCADE ,"
					+ "Tel  Text  ," 
					+ "Fax Text , " 
					+ "Email Text , " 
					+ "Website Text , " 
					+ " PRIMARY KEY ( id ))";
		         String sql1="ALTER TABLE ShopDetails AUTO_INCREMENT=1";
		         stmt.executeUpdate(sql);
		         stmt.executeUpdate(sql1);
		       
		      
		       
		        System.out.println("=====Table Shop Details Created Succeflly====");  
		       
		     } catch (SQLException e) {
		       System.out.println("Table Shop Details Not Created ");
		       System.out.println("=======================================");
		     }
		
		
		return false;
		  }
}
