package tester;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;


import com.app.core.Customer;
import com.app.core.ShippingAddress;

import custom_comp.CustomerDateTypeComparator;
import exception.CustomerHandlingException;
import static utils.CollectionUtils.*;
import static utils.ValidationUtils.*;

public class TestCustomer {

	public static void main(String[] args) throws CustomerHandlingException, ParseException {
		ArrayList<Customer> customlist = populateSample();
		
		boolean quit = false;
		
		try(Scanner sc = new Scanner(System.in)){
		while(!quit) {
			
			System.out.println("1.Input Details 2.Remove Customer 3.Check Customer Exist 4.Display Customer "
					+ "5.Convert to HashSet 6.Sort(Through mail) 7.Sort(DOB n RegAmount) 8.Sort(DOB n Type");
			
			System.out.println("Enter your choice : ");
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:
				System.out.println("Enter name, email, password, dateOfBirth, custType, regAmount");
				Customer c1 = new Customer(sc.next(), sc.next(), validatePassword(sc.next()),
						validateDateOfBirth(sc.next()), parseValidateCustType(sc.next().toUpperCase()),
						sc.nextDouble());
				System.out.println("Enter city state country zipcode ");
				ShippingAddress sh = new ShippingAddress(sc.next(), sc.next(), sc.next(), sc.nextInt());
				// c1.linkCustomerAddress(sh, ph);
				System.out.println("Enter the no. of phone numbers");
				int n = sc.nextInt();
				String[] ph = new String[n];
				int count = 0;
				System.out.println("Enter phone numbers : ");
				while (n != 0) {
					ph[count++] = sc.next();
					n--;
				}
				
				c1.linkCustomerAddress(sh, ph);
				//customset.add(c1);
				System.out.println("Customer added : " +  customlist.add(c1));
				break;
			case 2: 
				System.out.println("Enter email of the customer : ");
				String email = sc.next();
				
				int n1 = customlist.size();
				customlist = checkEmailExists(email,customlist);
				if(n1 == customlist.size()) {
					System.out.println("Customer do not exist");
				}else {
					System.out.println("Customer deleted successfully");
				}
				
				break;
			case 4: 
				
				for(Customer c : customlist) {
					System.out.println(c);
				}
				break;
			case 5:
				
				HashSet<Customer> customSet = new HashSet<>(customlist);
				for(Customer c : customSet) {
					System.out.println(c);
				}
				
				break;
				
			case 6:
				TreeSet<Customer> customTree = new TreeSet<>(customlist);
				for(Customer c : customTree) {
					System.out.println("Sorted through email");
					System.out.println(c);
				}
				
				
				break;
			case 7: 
				//Anonymous Class 
				TreeSet<Customer> customerCompareTree = new TreeSet<>(new Comparator<Customer>() {
					
					public int compare(Customer c1, Customer c2) {
						System.out.println("Inside compare anonymous class Date and Reg Amount");
						
						int ret = c1.getDateOfBirth().compareTo(c2.getDateOfBirth());
						if(ret == 0) {
							int ret2Val = ((Double)c1.getRegAmount()).compareTo(c2.getRegAmount());
							
							return ret2Val;
						}
						return ret;
					}
				});
				customerCompareTree.addAll(customlist);
				
				for(Customer c : customerCompareTree) {
					System.out.println(c);
				}
				break;
			case 8:
				TreeSet<Customer> customtreedateReg = new TreeSet<Customer>(new CustomerDateTypeComparator());
				customtreedateReg.addAll(customlist);
				
				for(Customer c : customtreedateReg) {
					System.out.println(c);
				}
			}
		}
		}

	}

}
