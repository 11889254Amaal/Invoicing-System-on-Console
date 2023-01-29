import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateInvoice {
	static final String DB_URL = "jdbc:mysql://localhost:3306/shopSystem";
	  static final String USER = "root";
	  static final String PASS = "root";
	public boolean CreateTableInvoiceFunction () {
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		        Statement stmt = conn.createStatement();
		     ) {      
			String sql = "CREATE TABLE Invoice " + "(Invoice_ID INTEGER not NULL, "
				    + "customer_name  VARCHAR(100) not NULL  ,"
				    + "InvoiceItems_id  INTEGER  ,"
					+ "FOREIGN KEY (InvoiceItems_id ) REFERENCES Items(item_ID) ON DELETE CASCADE ,"
					+ "phone_number  Text  ," 
					+ " invoice_date Date , "  
					+ " total_amount float , " 
					+ " paid_amount float , " 
					+ " PRIMARY KEY ( Invoice_ID ))";
		         String sql1="ALTER TABLE Invoice AUTO_INCREMENT=1";
		         stmt.executeUpdate(sql);
		         stmt.executeUpdate(sql1);
		       
		      
		       
		        System.out.println("=====Table Invoice Created Succeflly====");  
		       
		     } catch (SQLException e) {
		       System.out.println("Table Items Not Created ");
		       System.out.println("=======================================");
		     }
		return false;
		  }
}
