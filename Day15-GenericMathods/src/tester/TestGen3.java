package tester;

import static utils.GenericUtils.*;

import java.util.ArrayList;
import java.util.Arrays;

public class TestGen3 {

	public static void main(String[] args) {
		ArrayList<Double> doubles = new ArrayList<>(Arrays.asList(1.0, 2.6, 3.7, 4.7, 6.3));
		System.out.println(doubles);
		removeAlternate(doubles);
		System.out.println(doubles);
	}

}
