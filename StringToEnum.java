
public class StringToEnum {

	public static void main(String[] args) {
		String hello = "HELLO";
		Word convert = Word.valueOf(hello);
		System.out.print(convert);
	}

	static enum Word {
		HELLO
	}

}
