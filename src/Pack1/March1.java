package Pack1;

public class March1 {

	public static void main(String[] args) {
		MyDate m1 = new MyDate(4,10,2015);
		MyDate m2 = new MyDate(2,10,2015);
		int m1a = m1.hashCode();
		int m2a = m2.hashCode();
		System.out.println("m1:"  +m1a +","+ "m2:" + m2a);
		System.out.println("m1:"  +m1 +","+ "m2:" + m2);
		System.out.println(m1==m2);
		System.out.println(m1.equals(m2));
		System.out.println(m1.day +  " ," + m1.month +  "," + m1.year +" ," + m2.day+ "," +m2.month+ "," +m2.year);
		m2 = m1;
		System.out.println("m1:"  +m1a +","+ "m2:" + m2a);
		System.out.println("m1:"  +m1 +","+ "m2:" + m2);
		System.out.println(m1==m2);
		System.out.println(m1.equals(m2));
		System.out.println(m1.day +  " ," + m1.month +  "," + m1.year +" ," + m2.day+ "," +m2.month+ "," +m2.year);
		System.out.println("String starts from here");
		String str1 = new String("I am Prem");
		String str2 = new String("I am Prem");
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		System.out.println(str1.hashCode()+ ","+str2.hashCode());
		str1 =str2;
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		System.out.println(str1.hashCode()+ ","+str2.hashCode());
	}

}
class MyDate {
	int day;
	int month;
	int year;  
	MyDate (int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
}