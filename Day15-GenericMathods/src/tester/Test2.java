package tester;

import static utils.GenericUtils.*;

import java.util.Arrays;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		List<Integer> i = Arrays.asList(1, 2, 3, 4);

		List<Double> d = Arrays.asList(1.0, 2.0, 3.0, 4.0);
		double d1 = squareRoot(d);
		System.out.println(d1);

		double i1 = squareRoot(i);
		System.out.println(i1);

	}

}
