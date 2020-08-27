package tester;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import static utils.GenericUtils.*;
import static utils.CollectionUtils.*;
import com.app.core.Customer;

import exception.CustomerHandlingException;

public class Test1 {

	public static void main(String[] args) throws CustomerHandlingException, ParseException {

		ArrayList<Customer> list = populateSample();

		HashSet<Customer> hs = new HashSet<>(list);

		LinkedList<Customer> ll = new LinkedList<>(list);
		List<Integer> i = Arrays.asList(1, 2, 3, 4);

		List<Double> d = Arrays.asList(1.0, 2.0, 3.0, 4.0);

		List<String> s = Arrays.asList("ABC", "EFG");
		display(list);
		System.out.println("Integer");
		display(i);
		System.out.println("String");
		display(s);
		System.out.println("HashSet");
		display(hs);
		System.out.println("LinkedList");
		display(ll);

	}

}
