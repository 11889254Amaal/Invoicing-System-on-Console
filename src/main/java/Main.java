import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

public class Main {
	static Map<String, Integer> map = new HashMap();

	public static <K> void incrementValue(Map<K, Integer> map, K key) {
		// get the value of the specified key
		Integer count = map.get(key);

		// if the map contains no mapping for the key,
		// map the key with a value of 1
		if (count == null) {
			map.put(key, 1);
		}
		// else increment the found value by 1
		else {
			map.put(key, count + 1);
		}
	}

	public static List<String> getMenuArray() {
		return Arrays.asList("1.Shop Settings", "2.Manage Shop Items", "3.Create New Invoice",
				"4.Report: Statistics (No Of Items, No of Invoices, Total Sales) ",
				"5.Report: All Invoices ( Invoice No, Invoice Date, Customer Name, No of items, Total, Balance) ",
				"6.Search Invoice by Invoicke number",
				"7.Program Statistics (Print each Main Menu Item with how many number selected).", "8.Exit"

		);

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// this statment to load function (ApplicationMainMenuChoicesFunction())
		// ApplicationMainMenuChoicesFunction();
		System.out.println("******************************************************");
		System.out.println("   Invoicing system for a groceries shop Main Menu    ");
		System.out.println("******************************************************");
		System.out.println("Welcome...Please Select one of the following options:");
		for (String x : Main.getMenuArray()) {

			System.out.println(x);
		}

		do {

			int userInput = sc.nextInt();
			switch (userInput) {

			case 1:
				incrementValue(map, "CASE 1");
				// this case for ShopSetting class===> this class have Load Data (Items and
				// invoices)
				// Name of shoping
				// Set Invoice Header (Tel / Fax / Email / Website) (Data should be saved)
				// Go Back
				System.out.println("==========WELCOME TO SHOPPING SEETING===================");
				ShopSettings ShopSettingsClass = new ShopSettings();
				ShopSettingsClass.SettingsMenu();
				System.out.println("========================================================");
				for (String x : Main.getMenuArray()) {
					System.out.println(x);
				}

				break;
			case 2:
				incrementValue(map, "CASE 2");
				System.out.println("==========Manage Shop Items===================");
				ManageShopItems ManageShopItemsClass = new ManageShopItems();
				ManageShopItems.SettingsubMenuManageShopItems();
				System.out.println("==============================================");
				for (String x : Main.getMenuArray()) {
					System.out.println(x);
				}
			case 3:
				incrementValue(map, "CASE 3");
				System.out.println("==========Create New Invoice===================");
				CreateInvoice CreateInvoiceClass = new CreateInvoice();
				CreateInvoiceClass.CreateTableInvoiceFunction();
				CreateInvoiceClass.ADDInvoices();
				System.out.println("==============================================");
				for (String x : Main.getMenuArray()) {
					System.out.println(x);
				}
				break;
			case 4:
				incrementValue(map, "CASE 4");
				System.out.println("===Report of Invoice(NO ITEMS/NO INFOICE/TOTAL)==");
				CreateInvoice ReportClass = new CreateInvoice();
				ReportClass.REPORT();
				System.out.println("=================================================");
				for (String x : Main.getMenuArray()) {
					System.out.println(x);
				}
				break;
			case 5:
				incrementValue(map, "CASE 5");
				System.out.println("==========Report all Invoice===================");
				CreateInvoice ReportInvoiceClass = new CreateInvoice();
				ReportInvoiceClass.ReportAllInvoices();
				System.out.println("==============================================");
				for (String x : Main.getMenuArray()) {
					System.out.println(x);
				}
				break;
			case 6:
				incrementValue(map, "CASE 6");
				System.out.println("==========Search Invoice by id===================");
				CreateInvoice SearchInvoiceClass = new CreateInvoice();
				SearchInvoiceClass.SearchInvoicesById();
				System.out.println("==============================================");
				for (String x : Main.getMenuArray()) {
					System.out.println(x);
				}
				break;
			case 7:
				incrementValue(map, "CASE 7");
				System.out.println("==========view Input of user===================");
				System.out.println(map);
				System.out.println("===============================================");
				for (String x : Main.getMenuArray()) {
					System.out.println(x);
				}

				break;
			case 8:
				incrementValue(map, "CASE 8");
				System.out.println("Are You Want To existe from system if yes press 1 IF NOT press 0");
				int Existe_from_system = sc.nextInt();
				if (Existe_from_system == 1) {
					System.out.println("System is exsite");
					System.exit(0);
				} else if (Existe_from_system == 0) {
					for (String x : Main.getMenuArray()) {
						System.out.println(x);
					}
				}
				break;
			}
		} while (true);
	}

}
