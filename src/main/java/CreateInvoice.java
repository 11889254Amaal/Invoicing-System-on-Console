import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class CreateInvoice {
	static final String DB_URL = "jdbc:mysql://localhost:3306/shopSystem";
	static final String USER = "root";
	static final String PASS = "root";
	public static void REPORT() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/shopSystem";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		if (con != null) {
			
		//prepared statment to get all number of items from invoices
		String SqlNoOfItems = "SELECT SUM(no_of_items) from invoice";
		PreparedStatement NoOfITEMSPreparedStatment = con.prepareStatement(SqlNoOfItems);
		int No_of_items = 0;
		ResultSet NoOfItemsResultSet = NoOfITEMSPreparedStatment.executeQuery();
		if (NoOfItemsResultSet.next()) {
			No_of_items = NoOfItemsResultSet.getInt(1);
			System.out.println("NO of ITEMS   "+No_of_items);
		}
		
		//prepared statment to get all number of Invoices from invoices
		String SqlNoOfInvoices = "SELECT COUNT(*) FROM invoice";
		PreparedStatement NoOfInvoicesPreparedStatment = con.prepareStatement(SqlNoOfInvoices);
		int No_of_Invoices = 0;
		ResultSet NoOfInvoicesResultSet = NoOfInvoicesPreparedStatment.executeQuery();
		if (NoOfInvoicesResultSet.next()) {
			No_of_Invoices = NoOfInvoicesResultSet.getInt(1);
			System.out.println("NO of Invoices  "+No_of_Invoices);
		}
		
		//prepared statment to get all Total from invoices
				String SqlTotalOfInvoices = "SELECT SUM(total_amount) FROM invoice";
				PreparedStatement TotalOfInvoicesPreparedStatment = con.prepareStatement(SqlTotalOfInvoices);
				int Total_of_Invoices = 0;
				ResultSet TotalOfInvoicesResultSet = TotalOfInvoicesPreparedStatment.executeQuery();
				if (TotalOfInvoicesResultSet.next()) {
					Total_of_Invoices = TotalOfInvoicesResultSet.getInt(1);
					System.out.println("Total  "+Total_of_Invoices);
				}
		}
	}
	
	public static void SearchInvoicesById() {
		String url = "jdbc:mysql://localhost:3306/shopSystem";
		String username = "root";
		String password = "root";
		System.out.println("plz enter id of invoice that want to search");
		Scanner sc1 = new Scanner(System.in); // System.in is a standard input stream
		String id_of_invoice = sc1.next();
		String sql = " SELECT * from invoice where Invoice_ID='"+id_of_invoice + "'";
		
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
				System.out.println(" Invoice_number:" + n.getInt(1));
			    System.out.println(" invoice date:" + n.getString(6));
			    System.out.println(" Customer Name:" + n.getString(2));
			    System.out.println(" no of items:" + n.getInt(5));
			    System.out.println(" total amount:" + n.getInt(7));
			    System.out.println(" Balance:" + n.getInt(9));
			    System.out.println("==================================");
			   
			}
			
			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
	
	public static void ReportAllInvoices() {
		String url = "jdbc:mysql://localhost:3306/shopSystem";
		String username = "root";
		String password = "root";
		String sql = "SELECT * from invoice";
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
				System.out.println(" Invoice_number:" + n.getInt(1));
			    System.out.println(" invoice date:" + n.getString(6));
			    System.out.println(" Customer Name:" + n.getString(2));
			    System.out.println(" no of items:" + n.getInt(5));
			    System.out.println(" total amount:" + n.getInt(7));
			    System.out.println(" Balance:" + n.getInt(9));
			    System.out.println("==================================");
			   
			}
			
			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

	public boolean CreateTableInvoiceFunction() {
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();) {
			String sql = "CREATE TABLE Invoice " + "(Invoice_ID int NOT NULL AUTO_INCREMENT, "
					+ "customer_name  VARCHAR(100) not NULL  ," + "InvoiceItems_id  INTEGER  ,"
					+ "FOREIGN KEY (InvoiceItems_id ) REFERENCES Items(item_ID) ON DELETE CASCADE ,"
					+ "phone_number  Text  ," + "no_of_items  int  ," + " invoice_date Text , "
					+ " total_amount float , " + " paid_amount float , " + " balance float , "
					+ " PRIMARY KEY ( Invoice_ID ))";
			String sql1 = "ALTER TABLE Invoice AUTO_INCREMENT=1";
			stmt.executeUpdate(sql);
			stmt.executeUpdate(sql1);

			System.out.println("=====Table Invoice Created Succeflly====");

		} catch (SQLException e) {
			System.out.println("Table Invoice Not Created ");
			System.out.println("=======================================");
		}
		return false;
	}

	public static void ADDInvoices() throws SQLException, ClassNotFoundException {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/shopSystem";
		String username = "root";
		String password = "root";
		Connection con = DriverManager.getConnection(url, username, password);
		if (con != null) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Plz enter Number of Invoices you want to Insert");
			int NumberOfInvoices = sc.nextInt();

			for (int i = 0; i < NumberOfInvoices; i++) {

				System.out.println("==============ADD Invoices================");
				System.out.println("Plz Enter fist name of customer ");
				String fist_name = sc.next();
				System.out.println("Plz Enter middle name of customer ");
				String middle_name = sc.next();
				System.out.println("Plz Enter last name of customer ");
				String last_name = sc.next();
				String Full_name = fist_name + " " + middle_name + " " + last_name;
				System.out.println(Full_name);
				System.out.println("Plz Enter phone number ");
				String phone_number = sc.next();
				System.out.println("Plz Enter no of items ");
				int no_of_items = sc.nextInt();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd ");
				LocalDateTime now = LocalDateTime.now();
				String Date_oF_invoices = dtf.format(now);
				System.out.println("Date Of Invoices" + Date_oF_invoices);
				System.out.println("How many you give the Counter  :");
				Integer balance = sc.nextInt();
				System.out.println("Plz Enter  name of items ");
				String itemName = sc.next();

				Class.forName("com.mysql.cj.jdbc.Driver");
				String url1111111 = "jdbc:mysql://localhost:3306/shopSystem";
				String username1 = "root";
				String password1 = "root";
				String Sql2 = "Select COUNT(*) from Items where item_name=?";
				String sqlTotaleAmount = "Select price*(quantity) from Items where item_Name=?";
				String sqlPaidAmount = "Select price From Items where item_Name=?";
				String sqlBalance = "Select price From Items where item_Name=?";
				String sqlItemId = "Select item_ID From Items where item_Name=?";
				Connection con1 = DriverManager.getConnection(url1111111, username1, password1);
				
				
				///Sql2
				PreparedStatement shopPreparedStatment = con1.prepareStatement(Sql2);
				shopPreparedStatment.setString(1, itemName);
				int shopDetails_id = 0;
				int item_ID = 0;
				ResultSet shopResultSet = shopPreparedStatment.executeQuery();
				if (shopResultSet.next()) {
					shopDetails_id = shopResultSet.getInt(1);
					System.out.println(shopDetails_id);
				}
				
				
				
				
				//prepeard statment for total amount
				 PreparedStatement totaleAmountPreparedStatment = con1.prepareStatement(sqlTotaleAmount);;
                 totaleAmountPreparedStatment.setString(1, itemName);
                
                 int totaleAmountcount = 0;
                
                 ResultSet totaleAmountResultSet = totaleAmountPreparedStatment.executeQuery();
                 if(totaleAmountResultSet.next())
                 {
                	
                	 totaleAmountcount = totaleAmountResultSet.getInt(1);
	                    System.out.println("totaleAmount is :"+totaleAmountcount);
                 }
                 
                 
                 ///prepeard statment for Paid Amount
                 PreparedStatement sqlPaidAmountPreparedStatment = con1.prepareStatement(sqlPaidAmount);
                 sqlPaidAmountPreparedStatment.setString(1, itemName);
                 
                 int paidAmountcount = 0;
                
                 ResultSet paidAmountResultSet = sqlPaidAmountPreparedStatment.executeQuery();
                 if(paidAmountResultSet.next())
                 {
                	
                	 paidAmountcount = paidAmountResultSet.getInt(1);
	                    System.out.println("paidAmount is :"+paidAmountcount);
                 }
                
                 //Create PreparedStatement For Balance
                 PreparedStatement sqlsqlBalancePreparedStatment = con1.prepareStatement(sqlBalance);
                 sqlsqlBalancePreparedStatment.setString(1, itemName);
                
                 int balancecount = 0;
                 Integer countBalance = 0;
                 ResultSet balanceResultSet = sqlsqlBalancePreparedStatment.executeQuery();
                 if(balanceResultSet.next())
                 {
                	
                	 balancecount = balanceResultSet.getInt(1);
	                    System.out.println("price is :"+balancecount);
	                    countBalance = balance - balancecount;
	                    System.out.println("countBalance is :"+countBalance);
	                   
                 }
                
               //Create PreparedStatement For itemId
                 PreparedStatement sqlItemIdPreparedStatment = con1.prepareStatement(sqlItemId);
                 sqlItemIdPreparedStatment.setString(1, itemName);
                
                 int itemIdcount = 0;
                
                 ResultSet itemIdResultSet = sqlItemIdPreparedStatment.executeQuery();
                 if(itemIdResultSet.next())
                 {
                	
                	 itemIdcount = itemIdResultSet.getInt("item_ID");
	                    System.out.println("itemId is :"+itemIdcount);
                 }
                
       
                 
     			
                String insertInvoicesTable = "insert into invoice(customer_name,InvoiceItems_id,phone_number,no_of_items,invoice_date,total_amount,paid_amount,balance)values("
                		+ "?,?,?,?,?,?,?,?)";
                PreparedStatement stmt=con1.prepareStatement(insertInvoicesTable);
                stmt.setString(1, Full_name);
                stmt.setInt(2, itemIdcount);
                stmt.setString(3, phone_number);
                stmt.setInt(4, no_of_items);
                stmt.setString(5, Date_oF_invoices);
                stmt.setDouble(6, totaleAmountcount);
                stmt.setDouble(7, paidAmountcount);
                stmt.setInt(8, countBalance);
                 stmt.executeUpdate();
                    System.out.println("Inserted Successfuly");
                
			}
		}
	}
}
