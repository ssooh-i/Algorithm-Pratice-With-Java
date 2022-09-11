package workshop.ws0805_compare;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringCompareTest {

	public static void main(String[] args) {
		String[] word = { "boy", "Cat", "Lion", "dog", "elephant", "i", "dragon", "Any", "giraffe", "animal", "Dogcat",
				"girl" };
		List<String> list = Arrays.asList(word);
		System.out.println("1. " + list);
		Collections.sort(list);
		System.out.println("2. " + list);// String의 comparTo()는 사전순 정렬

		// [문제] 문자열 길이로 오름차순 정렬 후 사전 순 정렬하시오
		
		Comparator<String> comparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					//return o1.compareTo(o2);
					//return o1.toUpperCase().compareTo(o2.toUpperCase());//대소문자도 비교
					return o1.compareToIgnoreCase(o2);//대소문자도 비교
					}
				else
					return o2.length()-o1.length();
			}
			
		};
		Collections.sort(list, comparator);
		list.sort(comparator);
		System.out.println("3. " + list);
	}
}