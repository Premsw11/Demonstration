package Basic;

public class RemoveMultipleSpaces {

	public static void main(String[] args) {
		String str = "Prem    is working   at     Wipro";
		str = str.replaceAll("\\s{2,}", " ");
		System.out.println("str is == "+str);
	}
}
