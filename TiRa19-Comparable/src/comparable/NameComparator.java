package comparable;

import java.util.Comparator;

public class NameComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		TrafficCard c1 = (TrafficCard) o1;
		TrafficCard c2 = (TrafficCard) o2;
		return c1.mOwnerName.compareTo(c2.mOwnerName);
	}

}
