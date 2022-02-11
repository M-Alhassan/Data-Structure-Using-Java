package Practaice1;

// class that contaims the main method (driver)
public class Test {
	public static void main(String[] args) {
		
		Book bk1 = new Book("Arabic", 5);
		Book bk2 = new TextBook("Data Structure", 300, "ICS-202");
		Book bk3 = new Book("English", 200);
		Book bk4 = new TextBook("Calculus I", 450, "MATH-101" );
		Book bk5 = new Book("Permanent record", 370);
		Book bk6 = new TextBook("Computer Architecture", 300, "ICS-233");
		Book bk7 = new Book("12 rules for life", 350);
		Book bk8 = new TextBook("Introduction to Java", 500, "ICS-102");
		Book bk9 = new Book("Pyton for dummies", 600);
		Book bk10 = new TextBook("Discrete Mathmatics", 750, "ICS-253");
		
		Book books[] = {bk1, bk2, bk3, bk4, bk5, bk6, bk7, bk8, bk9, bk10};
		
		for (int i=0; i < 10; i++) {
			System.out.println(books[i]);
		}
		
	}

}
