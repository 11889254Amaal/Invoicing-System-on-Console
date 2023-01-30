import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class ShopSettings {
	//this case to set shop Name
	public static void ADDInvoiceHeader() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/shopSystem";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		if (con != null) {
			System.out.println("==============Invoice Header================");
			Scanner sc = new Scanner(System.in);
			System.out.println("Plz enter Name of shop");
			String shop_name=sc.next();
			System.out.println("Plz Enter Tel Of Shop");
			String Tel=sc.next();
			System.out.println("Plz Enter Fax Of Shop");
			String Fax=sc.next();
			System.out.println("Plz Enter Email Of Shop");
			String Email=sc.next();
			System.out.println("Plz Enter Website Of Shop");
			String Website=sc.next();
			
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
	public static void ADDSHOP() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/shopSystem";
	String username = "root";
	String password = "root";
	Connection con = DriverManager.getConnection(url, username, password);
	if (con != null) {
		System.out.println("==============================");
		System.out.println("Plz Enter Name Of Shop");
		Scanner sc = new Scanner(System.in);
		String Name_of_shop=sc.next();
		String sql = "insert into shop(Shop_Name)"
				+ " values('"+ Name_of_shop+"')";
		Statement st = con.createStatement();
		//
		// Executing query
		int m = st.executeUpdate(sql);
		if (m >= 1)
			System.out.println("inserted successfully : " + sql);
		else
			System.out.println("insertion failed");

		// Closing the connections
	}
	con.close();
	}
	public static void ShopSettingsMenu() {
		System.out.println("*******************************************************");
		System.out.println("Welcome...To Shop Seeting plz enter number of case:");
		System.out.println("0. Create All Table");
		System.out.println("1. Load Data (Items and invoices)");
		System.out.println("2. Set Shop Name (data should be saved) ");
		System.out.println("3. Set Invoice Header (Tel / Fax / Email / Website) (Data should be saved) ");
		System.out.println("4. Go Back");
		
		// this statment to load function (ApplicationMainMenuChoicesFunction())
	
	}
	public static void SettingsMenu() throws ClassNotFoundException, SQLException {
		ShopSettingsMenu();
		do {
			
			Scanner sc = new Scanner(System.in);
			// user inter which case you want
			int userInput = sc.nextInt();
			switch (userInput) {
			case 0:
				CreateTableShopAndShopDetails CreateTableShopAndDetails = new CreateTableShopAndShopDetails();
				CreateTableShopAndDetails.CreateTableShop();
				CreateTableShopAndDetails.CreateTableShopDetails();
				ShopSettingsMenu();
			break;
			
			case 1:
				//this case to load all data of items and Invoices
				System.out.println("==========lOAD DATA OF Items===================");
				LoadDataOfItemsAndInvoices LoadDataOfItems = new LoadDataOfItemsAndInvoices();
				LoadDataOfItems.LoadDtatOfItems();
				System.out.println("==============================================");
				ShopSettingsMenu();
				break;
			
			case 2:
				ADDSHOP();
				System.out.println("Are You Want To insert anther shop if yes press 1 IF NOT press 0");
				int add_more_shop=sc.nextInt();
				if(add_more_shop==1) {
					ADDSHOP();
				}
				else if(add_more_shop==0)
				{
					ShopSettingsMenu();
				}
				break;
				
			case 3:
				ADDInvoiceHeader();
				System.out.println("Are You Want To insert anther shop Details if yes press 1 IF NOT press 0");
				int add_more_shop_Details=sc.nextInt();
				if(add_more_shop_Details==1) {
					ADDInvoiceHeader();
				}
				else if(add_more_shop_Details==0)
				{
					ShopSettingsMenu();
				}
				break;
			case 4:
				System.out.println("==========Go Back To Main Menu===================");
				Main MainClass = new Main();
				MainClass.main(null);;
				System.out.println("========================================================");
			break;
			}
		} while (true);
	}

}
	
	
