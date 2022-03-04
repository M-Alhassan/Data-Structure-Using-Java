import java.util.Scanner;

public class StacksTest {
	public static void main(String[] args) {
		LabStack<String> s = new LabStack<String>();
		s.push("3");
		s.push("5");
		s.push("hi");
		while(!s.isEmpty()) {
			System.out.print(s.pop() + " ");
		}
		
		s.clear(); //Empty the contents of the stack
		
		System.out.println("\nHere's how I reverse a string: ");
		Scanner k = new Scanner(System.in);
		System.out.print("Enter a string> ");
		String input = k.nextLine();
		
		for(int i = 0; i < input.length(); i++)
			s.push(input.charAt(i) + "");
			
		System.out.println("The reversed string is: ");
		while(!s.isEmpty()) {
			System.out.print(s.pop());
		}
		
		System.out.println();
		
	}
}