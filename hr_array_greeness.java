import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
// add input & output
public class hr_array_greeness {

	public static void main(String[] args) {
		String[] lines = getStdin();
	    for (int i = 0, l = lines.length; i < l; i++) {
	      String n[] = lines[i].split(" ");
	      List<Integer> result = greeness(n.length, lines[i]);
	      result.stream().forEach(System.out::println);
	      System.out.println("---------------- ");
	   }
	}
	
	private static String[] getStdin() {

		String result[] = new String[] {
				"1 3", 
				"-10 2 100000", 
				"2 1 -4 -1 -10 -8 4 -8 -8 5", 
				"10 8 -7 9 10 10 4 -7 -7 3",
				"1 4 4 2 3",
				"-973386436 -380051506 796664322 911460198 -642438891 128872515 -439199919 399164859 890638987 240799847",
				"1000000000 1000000000 1000000000 1000000000 1000000000",
				"-1000000000 -1000000000 -1000000000 -1000000000 -1000000000"
			};
		// String result[] = new String[] {"-973386436 -380051506 796664322 911460198 -642438891 128872515 -439199919 399164859 890638987 240799847"};
		return result;
	}
	
	public static List<Integer> greeness (int n, String str) {
		int biggest = 1000000000;
		List<Integer> result = new ArrayList<>();
		if (n >= 2 && n <=100000) {
			int biggerNum = 0;
			for (int i = 0; i< n; i++) {
				String arr[] = str.split(" ");
				int num = Integer.parseInt(arr[i]);
				if (num >= -biggest && num <= biggest) {
					int value = Integer.parseInt(arr[(n-(i+1))]);
					biggerNum = findTheBiggestNumInArray(result);
					if (biggerNum == value) {
						return updateAllValueInList(value, n);
					} else if((value < 0 && biggerNum > 0)) {
						value = biggerNum;
					}
					result.add(value);
				}
			}
			result = arrOrderDes(result);
			needUpdateValueAfterHaveTwoDifferenctNum(result);
		}
		return result;
	}
	
	static List<Integer> needUpdateValueAfterHaveTwoDifferenctNum(List<Integer> arr) {
		List<Integer> tempArr = new ArrayList<>(arr);
		int biggestNum = findTheBiggestNumInArray(arr);
		tempArr = tempArr.stream().filter(t -> t != biggestNum).collect(Collectors.toList());
		int secondBiggestNum = findTheBiggestNumInArray(tempArr);
		boolean isSecondbigger = false;
		for(int i = 0; i<arr.size();i++) {
			if (isSecondbigger) {
				arr.set(i, biggestNum);
			}
			if (arr.get(i) == secondBiggestNum) {
				isSecondbigger = true;
			}
			
		}
		return arr;
	}
	
	static List<Integer> updateAllValueInList(int value, int totalArr) {
		List<Integer> result = new ArrayList<>();
		for (int i=0;i<totalArr; i++) {
			result.add(value);
		}
		return result;
	}
	
	static List<Integer> arrOrderDes(List<Integer> arr) {
		List<Integer> needSorts = arr.stream().sorted().collect(Collectors.toList());
		List<Integer> result = new ArrayList<>();
		for (int i=0; i<needSorts.size(); i++) {
			result.add(needSorts.get(arr.size() - (i+1)));
		}
		return result;
	}
	
	static int findTheBiggestNumInArray (List<Integer> arr) {
		int num = 0;
		for(int i = 0; i<arr.size();i++) {
			if (arr.get(i) > num) {
				num = arr.get(i);
			}
		}
		return num;
	}
}
