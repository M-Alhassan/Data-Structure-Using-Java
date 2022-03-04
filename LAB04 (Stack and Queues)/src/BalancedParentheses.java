
import java.util.*;

public class BalancedParentheses {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter your expression: ");
		String input = kb.nextLine();
		kb.close();
		System.out.println(checkBalance(input));
	}

	public static String checkBalance(String str) {
		if (str.isEmpty()) {
			return "Expression is not balanced";
		} else {
			LabStack<Character> stack = new LabStack<Character>();
			for (int i = 0; i < str.length(); i++) {
				char par = str.charAt(i);
				if (par == '{' || par == '(' || par == '[') {
					stack.push(par);
				}
				if (par == '}' || par == ')' || par == ']') {
					if (stack.isEmpty())
						return "Expression is not balanced";
					char last = stack.topEl();
					if (par == '}' && last == '{' || par == ')' && last == '(' || par == ']' && last == '[')
						stack.pop();
					else
						return "Expression is not balanced";
				}
			}
			return "Expression is balanced";
		}
	}
}
