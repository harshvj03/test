package utils;

import java.util.Collection;
import java.util.Iterator;

public class GenericUtils {

	public static void display(Collection<?> anyColl) {
//		Iterator itr = c.iterator();
		for (Object o : anyColl) {
			System.out.println(o);
		}
	}

	public static Double squareRoot(Collection<? extends Number> collection) {
		// Iterator itr = collection.iterator();
		double sum = 0.0;
		for (Number n : collection) {
			sum += n.doubleValue();
		}
		return Math.sqrt(sum);
	}

	public static void removeAlternate(Collection<?> anyColl) {
		Iterator<?> itr = anyColl.iterator();
		boolean remove = false;
		while (itr.hasNext()) {
			itr.next();
			if (remove) {
				itr.remove();
			}
			remove = !remove;
		}

	}

}
