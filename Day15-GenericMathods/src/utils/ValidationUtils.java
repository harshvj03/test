package utils;

import static java.time.LocalDate.parse;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;

import com.app.core.Customer;
//import com.app.core.CustomerType;
import com.app.core.CustomerType;

import exception.CustomerHandlingException;

public class ValidationUtils {
	
	public static LocalDate beginDate,today;
	//public static SimpleDateFormat sdf;
	static {
		//sdf = new SimpleDateFormat("dd-MM-yyyy");
		beginDate = parse("1950-01-01");
		today = LocalDate.now();
		
		Period p = Period.between(beginDate,today);
		
	}
	
	public static String validateEmail(String email) throws CustomerHandlingException {
		if(email.contains("@") && email.endsWith(".com")) {
			return email;
		}else {
			throw new CustomerHandlingException("Invalid Email id");
		}
	}
	

	public static String validatePassword(String password) throws CustomerHandlingException {
		if(password.length() >=  8) {
			return password;
		}else {
			throw new CustomerHandlingException("Password less than 8 characters");
		}
	}
	
	public static LocalDate validateDateOfBirth(String date) throws CustomerHandlingException, ParseException {
		LocalDate  d1 = parse(date);
		if(d1.isBefore(beginDate)) {
			throw new CustomerHandlingException("Invalid date ");
		}else {
			return d1;
		}
		
	}
	
	public static boolean compareEmail(Customer c1,String email) throws CustomerHandlingException {
		String cemail = c1.getEmail();
		if(cemail.equals(email)) {
			return true;
		}
		throw new CustomerHandlingException("Email id is incorrect");
	}
	
	public static boolean comparePassword(Customer c,String password) throws CustomerHandlingException {
		String cpassword = c.getPassword();
		if(cpassword.equals(password)) {
			return true;
		}
		throw new CustomerHandlingException("Password is incorrect");
	}
	
	public static  CustomerType parseValidateCustType(String custType) throws CustomerHandlingException {
		
		try {
			return CustomerType.valueOf(custType);
		}catch(Exception e) {
			throw new CustomerHandlingException("Type should be GOLD or PLATINUM or SILVER");
		}
		}
	
	//public static Customer checkEmailExists(String email, ArrayList<Customer> cust) throws CustomerHandlingException {
		public static ArrayList<Customer> checkEmailExists(String email,ArrayList<Customer> cust) throws CustomerHandlingException{
//		for(Customer c : cust) {
//			if(c!=null) {
//				if(c.getEmail().equals(email)) {
//					return c;
//				}
//			}
//		}
		Customer ref = new Customer(email);
		if(cust.contains(ref)) {
			cust.remove(ref);
			return cust;
		}
		return cust;
		//throw new CustomerHandlingException("Email id do not exist");
		
	}
	
//	public static boolean authenticateUser(String email, ArrayList<Customer> cust, String password) throws CustomerHandlingException {
//		
//			Customer c = checkEmailExists(email,cust);
//			if(c.getPassword().equals(password)) {
//				return true;
//			}
//			return false;
//		
//	}
	
//	public static ArrayList<Customer> unsubscribeCustomer(String email,ArrayList<Customer> cust) throws CustomerHandlingException{
//		
//		Customer c = checkEmailExists(email,cust);
//		
//		System.out.println("Customer " + c + " will be removed" );
//		int i = cust.indexOf(c);
//		cust.remove(i);
//		return cust;
//	
//	}
	
	public static ArrayList<Customer> getAge(ArrayList<Customer> cust){
		ArrayList<Customer> newList = new ArrayList<>();
		for(Customer c : cust) {
			Period p = Period.between(c.getDateOfBirth(),today);
			int age = p.getYears();
			if(age > 55) {
				newList.add(c);
			}
		}
		return newList;
		
	}

	}
