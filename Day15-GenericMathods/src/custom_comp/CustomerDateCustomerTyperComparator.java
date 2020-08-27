package custom_comp;

import java.util.Comparator;

import com.app.core.Customer;

public class CustomerDateCustomerTyperComparator implements Comparator<Customer> {
	
	@Override
	public int compare(Customer c1,Customer c2) {
		System.out.println("In customer date and type");
		
		int ret = c1.getDateOfBirth().compareTo(c2.getDateOfBirth());
		
		if(ret == 0) {
			return c1.getCustType().compareTo(c2.getCustType());
		}
		
		return ret;
	}
}
