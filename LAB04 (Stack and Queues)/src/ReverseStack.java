import java.util.Scanner;

public class ReverseStack {

	public static void main(String[] args) {
		LabStack<String> stack = new LabStack<String>();
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter your input> ");
		String elements[] = kb.nextLine().split(" ");
		for (String str : elements) {
			stack.push(str);
		}
		System.out.println("Now the stack is>> " + stack);

		LabQueue<String> queue = new LabQueue<String>();
		while (!stack.isEmpty()) {
			queue.enqueue(stack.pop());
		}
		while (!queue.isEmpty()) {
			stack.push(queue.dequeue());
		}
		System.out.println("After Reverse the stack is>> " + stack);
	}
}
