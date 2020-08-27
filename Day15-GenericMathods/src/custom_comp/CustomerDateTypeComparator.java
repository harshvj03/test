package custom_comp;

import java.util.Comparator;

import com.app.core.Customer;

public class CustomerDateTypeComparator implements Comparator<Customer>{

	@Override
	public int compare(Customer c1, Customer c2) {
		System.out.println("Inside Date type Comparator");
		int ret = c1.getDateOfBirth().compareTo(c2.getDateOfBirth());
		
		if(ret == 0) {
			int ret2 = c1.getCustType().compareTo(c2.getCustType());
			return ret2;
		}
		return ret;
	}

}
