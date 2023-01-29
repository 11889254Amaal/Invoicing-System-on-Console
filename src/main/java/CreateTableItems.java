import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableItems {
	static final String DB_URL = "jdbc:mysql://localhost:3306/shopSystem";
	  static final String USER = "root";
	  static final String PASS = "root";
	public boolean CreateTableItemsFunction () {
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		        Statement stmt = conn.createStatement();
		     ) {      
			String sql = "CREATE TABLE Items " + "(item_ID INTEGER not NULL, "
				    + "item_name  VARCHAR(100) not NULL  ,"
				    + "shopDetails_id  INTEGER  ,"
					+ "FOREIGN KEY (shopDetails_id) REFERENCES ShopDetails(id) ON DELETE CASCADE ,"
					+ "price  float  ," 
					+ "quantity int , " 
					+ " PRIMARY KEY ( item_ID ))";
		         String sql1="ALTER TABLE Items AUTO_INCREMENT=1";
		         stmt.executeUpdate(sql);
		         stmt.executeUpdate(sql1);
		       
		      
		       
		        System.out.println("=====Table Items Created Succeflly====");  
		       
		     } catch (SQLException e) {
		       System.out.println("Table Items Not Created ");
		       System.out.println("=======================================");
		     }
		return false;
		  }
}
