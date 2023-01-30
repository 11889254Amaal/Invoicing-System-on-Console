import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class LoadDataOfItemsAndInvoices {


	public static void LoadDtatOfItems() {
		String url = "jdbc:mysql://localhost:3306/shopSystem";
		String username = "root";
		String password = "root";
		String sql = "SELECT * from items";
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			// Executing query

			
			ResultSet n = st.executeQuery(sql);
			while (n.next()) {
				System.out.println("==================================");
				System.out.println(" id:" + n.getString(1));
			    System.out.println(" item_name:" + n.getString(2));
			    System.out.println(" shopDetails_id:" + n.getString(3));
			    System.out.println(" price:" + n.getString(4));
			    System.out.println(" quantity:" + n.getString(5));
			    System.out.println("==================================");
			   
			}
			
			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
}
