// a program to check if a string is palidrome using stacks 
// (a palindrome is  a word that is the same as it's reverse)
import java.util.Scanner;
import java.util.Stack;

public class StacksTest {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		Stack stack = new Stack();
		Stack stackDuplicate = new Stack();
		Stack stack2 = new Stack();
		System.out.print("Enter a string: ");
		String str = kb.nextLine();
		for(int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			stackDuplicate.push(str.charAt(i));
		}
		for(int i = 0; i < str.length(); i++) {
			stack2.push(stack.pop());
		}
		System.out.println(stack2);
		System.out.println(stackDuplicate);
		System.out.println(stackDuplicate.toString().equals(stack2.toString()));
	}
}