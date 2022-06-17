import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class splitURL {
	public static void main(String args[]) {
		String[] url = {"10.20.31.12 200 http://example.com/index1", "10.20.31.12 200 http://example.com/index2", "10.20.31.12 200 http://example.com/index"};
		String[] result = solution(10, url);
		System.out.println(Arrays.toString(result));
	}
	
	static String[] solution(int input, String[] logs) {
		List<String> list = new ArrayList<String>();
		for(int i=0;i<logs.length;i++) {
			String log = logs[i];
			String[] data = log.split(" ");
			for (int j=0; j<data.length; j++) {
				if (data[j].contains("http") && !list.contains(data[j])) {
					list.add(data[j]);
				}
			}
		}
		String[] result = list.toArray(new String[0]);
		return result;
		
	}
}
