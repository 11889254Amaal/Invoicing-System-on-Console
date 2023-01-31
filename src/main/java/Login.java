import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url1111111 = "jdbc:mysql://localhost:3306/shopSystem";
		String username1 = "root";
		String password1 = "root";
		    Scanner input = new Scanner(System.in);
	        System.out.print("Plz Enter Url: ");
	        String URL= input.nextLine();
	        System.out.print("Plz Enter User Name: ");
	        String UserName= input.nextLine();
	        System.out.print("Plz Enter Password: ");
	        String Password= input.nextLine();
	        if (URL.equals(url1111111)){
	            if (UserName.equals(username1)){
	                if(Password.equals(password1)) {
	                	System.out.print("Login Succeffly");
	                }
	                else
	                {
	                	System.out.print("Login not Succeffly");
	                }
	                
	            }
	           
	        }
	    }
	
}
