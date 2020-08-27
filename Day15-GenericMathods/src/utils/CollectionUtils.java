package utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

import static utils.ValidationUtils.*;
import com.app.core.Customer;
import com.app.core.CustomerType;
import com.app.core.ShippingAddress;

import exception.CustomerHandlingException;

public class CollectionUtils {
	public static ArrayList<Customer> populateSample() throws CustomerHandlingException, ParseException {
		ArrayList<Customer> customlist = new ArrayList<>();
		//Customer(String name, String email, String password, LocalDate dateOfBirth, CustomerType custType, double regAmount)
		Customer c1 = new Customer("Harsh","h@h.com","12345678",validateDateOfBirth("2000-01-01"),parseValidateCustType("SILVER"),2000);
		ShippingAddress sh = new ShippingAddress("Pune","Mah","India",457001);
		String[] ph = new String[2];
		ph[0] = "1234567891";
		ph[1] = "1234432112";
		c1.linkCustomerAddress(sh,ph);
		customlist.add(c1);
		
		Customer c2 = new Customer("Vijay","v@v.com","87654321",validateDateOfBirth("2010-01-01"),parseValidateCustType("GOLD"),4000);
		sh = new ShippingAddress("Mumbai","Mah","India",757001);
		
		ph[0] = "9877656456";
		ph[1] = "9767590945";
		
		c2.linkCustomerAddress(sh, ph);
		customlist.add(c2);
		
		Customer c3 = new Customer("oldman","old@man.com ","12345678",validateDateOfBirth("1950-01-01"),parseValidateCustType("PLATINUM"),2000);
		
		sh = new ShippingAddress("Pune","Mah","Ind",457001);
		
		ph[0] = "1234567891";
		
		c3.linkCustomerAddress(sh, ph);
		customlist.add(c3);
		
		Customer c4 = new Customer("Bob","old@mango.com ","12345678",validateDateOfBirth("1950-01-01"),parseValidateCustType("SILVER"),1999);
		
		
		c4.linkCustomerAddress(sh, ph);
		customlist.add(c4);
		
		Customer c5 = new Customer("oldmonk","old@monk.com ","12345678",validateDateOfBirth("1950-01-01"),parseValidateCustType("GOLD"),1999);
		c5.linkCustomerAddress(sh, ph);
		
		Customer c6 = new Customer("oldmonk","old@monk.com ","12345678",validateDateOfBirth("1950-01-01"),parseValidateCustType("GOLD"),1569);
		c6.linkCustomerAddress(sh, ph);
		
		customlist.add(c5);
		customlist.add(c6);
		
		
		
		return customlist;
		//c1.linkCustomerAddress(sh, ph);
				
	}
	
	public static LinkedHashSet<Customer> populateData(ArrayList<Customer> customlist){
		return new LinkedHashSet<>(customlist);
	}

}
