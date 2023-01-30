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
	public static List<String> getManageShopItemsArray() {
		return Arrays.asList("1.Add Items (Item should be saved/serialized", "2.Delete Item", "3.Change Item Price",
				"4.Report All Items ", "5.Go Back "

		);

	}
	public static void ChangeItemsPrice() throws ClassNotFoundException {
		
		System.out.println("==========Update From Table Items===================");
		System.out.println("plz enter name that want to update price");
		Scanner sc1 = new Scanner(System.in); // System.in is a standard input stream
		String items_name = sc1.next();
		System.out.println("plz enter new price");
		int price = sc1.nextInt();
		String sqlDB1 = " update items set price = ? where item_name =?";

		Class.forName("com.mysql.cj.jdbc.Driver");
		String url1111 = "jdbc:mysql://localhost:3306/shopSystem";
		String username1 = "root";
		String password1 = "root";
		try (
				// gets connection with database
				Connection connection = DriverManager.getConnection(url1111, username1, password1);

				// sends queries and receives results
				PreparedStatement statement = connection.prepareStatement(sqlDB1);) {
			// this way to prevent sql injection
			statement.setInt(1, price);
			statement.setString(2, items_name);
            
			statement.executeUpdate();

			System.out.println(" updated item successfuly>>> " );
		} catch (SQLException e) {
			// some logic depending on scenario
			// maybe LOGGER.log(e.getMessage()) and "result false"
			e.printStackTrace();
		}
		System.out.println("Are You Want To change Price of Nather items if yes press 1 IF NOT press 0");
		Scanner sc = new Scanner(System.in);
		int change_items_Price = sc.nextInt();
		if (change_items_Price == 1) {
			ChangeItemsPrice();
		} else if (change_items_Price == 0) {
			for(String x:ManageShopItems.getManageShopItemsArray())
			{
				System.out.println(x);
			}
		}
		
	
	}
	public static void DELETEITEMS() {
		System.out.println("plz enter name of items that want to delete");
		Scanner sc11 = new Scanner(System.in); // System.in is a standard input stream
		String items_name = sc11.next();
		Connection conn111 = null;
		Statement stmt = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (Exception e) {
				System.out.println(e);
			}
			conn111 = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/shopSystem", "root",
					"root");
			
			stmt = (Statement) conn111.createStatement();
			String query1 = "DELETE FROM items WHERE item_name='"+items_name + "'";
			stmt.executeUpdate(query1);
			System.out.println("Record is deleted from the table successfully..................");
		} catch (SQLException excep) {
			excep.printStackTrace();
		} catch (Exception excep) {
			excep.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn111.close();
			} catch (SQLException se) {
			}
			try {
				if (conn111 != null)
					conn111.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println("Please check it in the MySQL Table. Record is now deleted.......");
		System.out.println("Are You Want To DELETE anther Items if yes press 1 IF NOT press 0");
		Scanner sc = new Scanner(System.in);
		int Delete_more_ITEMS = sc.nextInt();
		if (Delete_more_ITEMS == 1) {
			DELETEITEMS();
		} else if (Delete_more_ITEMS == 0) {
			for(String x:ManageShopItems.getManageShopItemsArray())
			{
				System.out.println(x);
			}
		}
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
			System.out.println("Plz Enter name of shop ");
			String shop_name = sc.next();
			System.out.println("Plz Enter item name ");
			String item_name = sc.next();
			System.out.println("Plz Enter price ");
			String price = sc.next();
			System.out.println("Plz Enter quantity");
			String quantity = sc.next();
			
			

			Class.forName("com.mysql.cj.jdbc.Driver");
			String url1111111 = "jdbc:mysql://localhost:3306/shopSystem";
			String username1 = "root";
			String password1 = "root";
			String Sql2 = "SELECT shopdetails.id FROM shopdetails INNER JOIN shop ON shop.id = shopdetails.shop_id  where shop.Shop_Name=?";
			Connection con1 = DriverManager.getConnection(url1111111, username1, password1);
			PreparedStatement shopPreparedStatment = con1.prepareStatement(Sql2);
			shopPreparedStatment.setString(1, shop_name);
			int shopDetails_id = 0;
            //int item_ID=0;
			ResultSet shopResultSet = shopPreparedStatment.executeQuery();
			if (shopResultSet.next()) {
				shopDetails_id = shopResultSet.getInt("id");
				System.out.println(shopDetails_id);
			}
			
			String sql1 = "insert into items(item_name,shopDetails_id,price,quantity)" + " values('"+ item_name + "','"
					+ shopDetails_id + "','" + price + "','" + quantity + "')";
			Statement st = con.createStatement();
			//
			// Executing query
			int m = st.executeUpdate(sql1);
			if (m >= 1) {
				System.out.println("inserted successfully : " + sql1);
			}
			else
				System.out.println("insertion failed");

			con.close();
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Are You Want To insert anther Items if yes press 1 IF NOT press 0");
		int add_more_shop = sc.nextInt();
		if (add_more_shop == 1) {
			ADDITEMS();
		} else if (add_more_shop == 0) {
			for(String x:ManageShopItems.getManageShopItemsArray())
			{
				System.out.println(x);
			}
		}
	}

	public static void SettingsubMenuManageShopItems() throws ClassNotFoundException, SQLException {
		System.out.println("******************************************************");
		System.out.println("   Manage Shop Items sub Menu    ");
		System.out.println("******************************************************");
		System.out.println("Welcome...Please Select one of the following options:");
		for (String x : ManageShopItems.getManageShopItemsArray()) {

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

				// this case to load all data of items and Invoices
				System.out.println("******************************************************");
				System.out.println("   Add Items to Items Table    ");
				System.out.println("******************************************************");
				ADDITEMS();
//				System.out.println("Are You Want To insert anther Items if yes press 1 IF NOT press 0");
//				int add_more_shop = sc.nextInt();
//				if (add_more_shop == 1) {
//					ADDITEMS();
//				} else if (add_more_shop == 0) {
//					for(String x:ManageShopItems.getManageShopItemsArray())
//					{
//						System.out.println(x);
//					}
//				}
				break;

			case 2:
				System.out.println("******************************************************");
				System.out.println("   deletes Items By Nmae from Items Table    ");
				System.out.println("******************************************************");
				DELETEITEMS();
//				System.out.println("Are You Want To DELETE anther Items if yes press 1 IF NOT press 0");
//				int Delete_more_ITEMS = sc.nextInt();
//				if (Delete_more_ITEMS == 1) {
//					DELETEITEMS();
//				} else if (Delete_more_ITEMS == 0) {
//					for(String x:ManageShopItems.getManageShopItemsArray())
//					{
//						System.out.println(x);
//					}
//				}
				break;
			case 3:
				System.out.println("******************************************************");
				System.out.println("   updates price of  Items By Name from Items Table    ");
				System.out.println("******************************************************");
				ChangeItemsPrice();
//				System.out.println("Are You Want To change Price of Nather items if yes press 1 IF NOT press 0");
//				int change_items_Price = sc.nextInt();
//				if (change_items_Price == 1) {
//					ChangeItemsPrice();
//				} else if (change_items_Price == 0) {
//					for(String x:ManageShopItems.getManageShopItemsArray())
//					{
//						System.out.println(x);
//					}
//				}
				break;
				
			case 4:
				System.out.println("==========lOAD DATA OF Items===================");
				LoadDataOfItemsAndInvoices LoadDataOfItems = new LoadDataOfItemsAndInvoices();
				LoadDataOfItems.LoadDtatOfItems();
				System.out.println("==============================================");
				for(String x:ManageShopItems.getManageShopItemsArray())
				{
					System.out.println(x);
				}
				break;
			case 5:
				System.out.println("==========Go Back To Main Menu===================");
				Main MainClass = new Main();
				MainClass.main(null);;
				System.out.println("========================================================");
				break;
			}
		} while (true);
	}

}
