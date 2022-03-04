import java.util.*;

public class Postfix {
	public static void main(String[] args) {
		try {
			Scanner kb = new Scanner(System.in);
			System.out.print("Enter your <postfix> expression: ");
			String expression = kb.nextLine();
			LabStack<Integer> postFix = new LabStack<Integer>();
			int length = expression.length();
			for (int i = 0; i < length; i++) {
				if (expression.charAt(i) == ' ') {
					continue;
				} else if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'
						|| expression.charAt(i) == '/') {
					int op1, op2;
					try {
						op1 = postFix.pop();
					} catch (Exception e) {
						System.out.println("Your postfix expression is not valid");
						return;
					}
					op2 = postFix.pop();
					if (expression.charAt(i) == '+') {
						postFix.push(op2 + op1);
						System.out.println("Currently, the stack is>> " + postFix.toString());
					} else if (expression.charAt(i) == '-') {
						postFix.push(op2 - op1);
						System.out.println("Currently, the stack is>> " + postFix.toString());
					} else if (expression.charAt(i) == '*') {
						postFix.push(op2 * op1);
						System.out.println("Currently, the stack is>> " + postFix.toString());
					} else if (expression.charAt(i) == '/') {
						postFix.push(op2 / op1);
						System.out.println("Currently, the stack is>> " + postFix.toString());
					}
				} else {
					int num = expression.charAt(i) - '0';
					postFix.push(num);
				}
			}
			System.out.println(expression + " = " + postFix.pop());
			kb.close();
		} catch (Exception e) {
			System.out.println("Your postfix is invalid");
		}
	}
}
