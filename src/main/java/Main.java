import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {


	
	public static List<String> getMenuArray(){
		return Arrays.asList("1.Shop Settings",
				"2.Manage Shop Items",
				"3.Create New Invoice",
				"4.Report: Statistics (No Of Items, No of Invoices, Total Sales) ",
				"5.Report: All Invoices ( Invoice No, Invoice Date, Customer Name, No of items, Total, Balance) ",
				"6.Search Invoice by Invoicke number",
				"7.Program Statistics (Print each Main Menu Item with how many number selected).",
				"8.Exit"
				
				);
		
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// this statment to load function (ApplicationMainMenuChoicesFunction())
		//ApplicationMainMenuChoicesFunction();
		  System.out.println("******************************************************");
		  System.out.println("   Invoicing system for a groceries shop Main Menu    ");
		  System.out.println("******************************************************");
		  System.out.println("Welcome...Please Select one of the following options:");
		for(String x:Main.getMenuArray())
		{
			
		
			  System.out.println(x);
		}

		do {
			// user inter which case you want
			int userInput = sc.nextInt();
			switch (userInput) {
			case 1:
				// this case for ShopSetting class===> this class have Load Data (Items and
				// invoices)
				// Name of shoping
				// Set Invoice Header (Tel / Fax / Email / Website) (Data should be saved)
				// Go Back
				System.out.println("==========WELCOME TO SHOPPING SEETING===================");
				ShopSettings ShopSettingsClass = new ShopSettings();
				ShopSettingsClass.SettingsMenu();
				System.out.println("========================================================");
				for(String x:Main.getMenuArray())
				{
					System.out.println(x);
				}

				break;
			case 2:
				System.out.println("==========Manage Shop Items===================");
				ManageShopItems ManageShopItemsClass = new ManageShopItems();
				ManageShopItems.SettingsubMenuManageShopItems();
				System.out.println("==============================================");
				for(String x:Main.getMenuArray())
				{
					System.out.println(x);
				}
			case 3:
				System.out.println("==========Manage Shop Items===================");
				ManageShopItems ManageShopItemsClass1 = new ManageShopItems();
				ManageShopItems.SettingsubMenuManageShopItems();
				System.out.println("==============================================");
				for(String x:Main.getMenuArray())
				{
					System.out.println(x);
				}
			
			}
		} while (true);
	}

}
