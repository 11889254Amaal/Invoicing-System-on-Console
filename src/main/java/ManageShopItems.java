import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManageShopItems {
	public static List<String> getManageShopItemsArray(){
		return Arrays.asList("1.Add Items (Item should be saved/serialized",
				"2.Delete Item",
				"3.Change Item Price",
				"4.Report All Items ",
				"5.Go Back "
				
				
				);
		
	}
	public static void ADDITEMS() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/shopSystem";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		if (con != null) {
			System.out.println("==============ADD ITEMS================");
			Scanner sc = new Scanner(System.in);
			System.out.println("Plz enter Name of shop");
			String shop_name=sc.next();
			System.out.println("Plz Enter item name ");
			String Tel=sc.next();
			System.out.println("Plz Enter price ");
			String Fax=sc.next();
			System.out.println("Plz Enter quantity");
			String Email=sc.next();
			
			
			String Sql = "SELECT id FROM Shop Where Shop_Name=?";
        	
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url1111111 = "jdbc:mysql://localhost:3306/shopSystem";
			String username1 = "root";
			String password1 = "root";

			Connection con1 = DriverManager.getConnection(url1111111, username1, password1);
			PreparedStatement shopPreparedStatment = con1.prepareStatement(Sql);
            shopPreparedStatment.setString(1, shop_name);
            int shopId = 0;
           
            ResultSet shopResultSet = shopPreparedStatment.executeQuery();
            if(shopResultSet.next())
            {
           	    shopId = shopResultSet.getInt("id");
                System.out.println(shopId);
            }
            String sql1 = "insert into shopdetails(shop_id,Tel,Fax,Email,Website)"
    				+ " values('"+ shopId+"','"+ Tel+"','"+ Fax+"','"+ Email+"','"+ Website+"')";
    		Statement st = con.createStatement();
    		//
    		// Executing query
    		int m = st.executeUpdate(sql1);
    		if (m >= 1)
    			System.out.println("inserted successfully : " + sql1);
    		else
    			System.out.println("insertion failed");

		con.close();
		}
	}
	 public static void SettingsubMenuManageShopItems() {
		System.out.println("******************************************************");
		  System.out.println("   Manage Shop Items sub Menu    ");
		  System.out.println("******************************************************");
		  System.out.println("Welcome...Please Select one of the following options:");
		for(String x:ManageShopItems.getManageShopItemsArray())
		{
			
		
			  System.out.println(x);
		}
		do {
			
			Scanner sc = new Scanner(System.in);
			// user inter which case you want
			int userInput = sc.nextInt();
			switch (userInput) {
			case 1:
				CreateTableItems CreateTableItems = new CreateTableItems();
				CreateTableItems.CreateTableItemsFunction();
				
				System.out.println("******************************************************");
				  System.out.println("   Manage Shop Items sub Menu    ");
				  System.out.println("******************************************************");
				  System.out.println("Welcome...Please Select one of the following options:");
				for(String x:ManageShopItems.getManageShopItemsArray())
				{
					  System.out.println(x);
				}
			break;
			
			case 2:
				//this case to load all data of items and Invoices
				System.out.println("******************************************************");
				  System.out.println("   Add Items to Items Table    ");
				  System.out.println("******************************************************");
////////////////////////
				for(String x:ManageShopItems.getManageShopItemsArray())
				{
					  System.out.println(x);
				}
				break;
			
			case 3:
				break;
			}
		} while (true);
	}

}
