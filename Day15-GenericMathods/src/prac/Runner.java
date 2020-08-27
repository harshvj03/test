package prac;

import java.text.ParseException;

//import static utils.CollectionUtils.*;

import java.util.LinkedHashSet;

import com.app.core.Customer;

import exception.CustomerHandlingException;
import utils.CollectionUtils;
public class Runner {

	public static void main(String[] args) throws CustomerHandlingException, ParseException {
		// TODO Auto-generated method stub
		LinkedHashSet<Customer> cust = CollectionUtils.populateData(CollectionUtils.populateSample());
		
		cust.add(null);
		//cust.add(null);
		
		for(Customer c : cust) {
			System.out.println(c);
		}

	}

}
