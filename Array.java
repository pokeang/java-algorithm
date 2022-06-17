import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {
	public static void main(String args[]) {
		reverseString();
	}

	static void reverseString() {
		String str = "hello world";
		char[] arr = str.toCharArray();
		String result = "";
		int totalLength = arr.length;
		for(int i = 0; i<totalLength; i++) {
			result = result + String.valueOf(arr[totalLength - (i + 1)]);
		}
		System.out.println(result);
	}

	static void getCountLoveWordsFromStringList() {
		String wordList[] = new String[] {"velo", "low", "vovee", "lover", "volvell", "lowly", "lower", "levo", "loved", "love", "lovee", "lowe", "lowes", "lovey", "lowan"};
		int result = 0;
		for (int i = 0; i<wordList.length;i++) {
			int count = 0;
			String love = "love";
			char[] words = wordList[i].toCharArray();
			String tempStr = "";
			for (int j =0; j < words.length; j++) {
				String charStr = String.valueOf(words[j]);
				if (!tempStr.contains(charStr)) {
					tempStr = tempStr + charStr;
				}
			}
			char[] noDuplicate = tempStr.toCharArray();
			for(int k = 0; k<noDuplicate.length;k++) {
				if (love.contains(String.valueOf(noDuplicate[k]))) {
					if (count == 4)
						break;
					count++;
				}
			}

			if (count == 4) {
				result++;
			}
		}

		System.out.print("done: " + result);
	}
	
	static void getSmallestNumberFromString() {
		String num = "25551044350305";
		char[] arr = num.toCharArray();

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i<arr.length; i++) {
			int numVal = Character.getNumericValue(arr[i]);
			result.add(numVal);
		}
		result.stream().sorted().forEach(System.out::print);
		// System.out.print(result.stream().sorted().collect(Collectors.toList()));
	}
	
	static void usingArray() {
		List<String> arr = Arrays.asList("bopa", "tida");
		arr.stream().forEach(System.out::println);

		for(String a: arr) {
			System.out.println(a);
		}
	}

	static void findTheSmallestInArray() {
		List<Integer> arr = Arrays.asList(1, -1, 2, -3, 4);
		int num =0;
		for (int i = 0; i<arr.size(); i++) {
			if (arr.get(i) < num) {
				num = arr.get(i);
			}
		}

		System.out.println(num);
	}
	
	static void findTheBiggestNumInArray () {
		List<Integer> arr = Arrays.asList(2,34,5);
		int num = 0;
		for(int i = 0; i<arr.size();i++) {
			if (arr.get(i) > num) {
				num = arr.get(i);
			}
		}
		System.out.println(num);
	}
}
