import java.util.Scanner;

public class Main {
	static void ApplicationMainMenuChoicesFunction() {

		System.out.println("******************************************************");
		System.out.println("   Invoicing system for a groceries shop Main Menu    ");
		System.out.println("******************************************************");
		System.out.println("Welcome...Please Select one of the following options:");
		System.out.println("1.Shop Settings");
		System.out.println("2.Manage Shop Items");
		System.out.println("3.Create New Invoice");
		System.out.println("4.Report: Statistics (No Of Items, No of Invoices, Total Sales) " );
		System.out.println("5.Report: All Invoices ( Invoice No, Invoice Date, Customer Name, No of items, Total, Balance) ");
		System.out.println("6.Search Invoice by Invoicke number");
		System.out.println("7.Program Statistics (Print each Main Menu Item with how many number selected).");
		System.out.println("8.Exit");
		System.out.println("******************************************************");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// this statment to load function (ApplicationMainMenuChoicesFunction())
		ApplicationMainMenuChoicesFunction();

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
				ShopSettingsClass.ShopSettingsMenu();
				System.out.println("========================================================");
				ApplicationMainMenuChoicesFunction();
				break;
			}
		} while (true);
	}

}
