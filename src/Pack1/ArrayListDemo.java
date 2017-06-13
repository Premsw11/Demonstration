package Pack1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class Book implements Comparable<Book>{  
int id;  
String name,author,publisher;  
int quantity;  
public Book(int id, String name, String author, String publisher, int quantity) {  
    this.id = id;  
    this.name = name;  
    this.author = author;  
    this.publisher = publisher;  
    this.quantity = quantity;  
}  
public int compareTo(Book b) {  
    if(id>b.id){  
        return 1;  
    }else if(id<b.id) {  
        return -1;  
    }else{  
    return 0;  
    }  
}  
}  

public class ArrayListDemo {
public static void main(String[] args) {
	/*ArrayList <String> al = new ArrayList<String> ();
	al.add("Rina");
	al.add("Tina");
	al.add("Shyam");
	for(String str:al)
		System.out.println(str); 
	TreeSet<String> tr = new TreeSet<String>();
	tr.add("Sachin");
	tr.add("Sehwag");
	tr.add("Saurav");
	tr.add("PP");
	System.out.println(tr.add("Sacaahin"));
	System.out.println(tr);
	Iterator itr = tr.iterator();
	while(itr.hasNext())
		System.out.println(itr.next()); */
	
	Set<Book> set=new TreeSet<Book>();  
    //Creating Books  
    Book b1=new Book(121,"Let us C","Yashwant Kanetkar","BPB",8);  
    Book b2=new Book(233,"operating System","Galvin","Wiley",6);  
    Book b3=new Book(1,"zata Communications & Networking","Forouzan","Mc Graw Hill",4);  
    //Adding Books to TreeSet  
    set.add(b1);  
    set.add(b2);  
    set.add(b3);  
    //Traversing TreeSet  
    for(Book b:set){  
    System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
    } 
	
}
}
