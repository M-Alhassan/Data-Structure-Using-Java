
public class Test {
	//recursion
	public static void main(String[] args) {
		// findSmallest
		String[] fruits = { "Apple", "Mango", "Banana", "Orange", "Peach", "Lime", "Watermelon" };
		System.out.print("The array is: ");
		for (int i = 0; i < fruits.length; i++) {
			System.out.print(fruits[i] + " ");
		}
		System.out.println("");
		System.out.println("Samllest string: " + findSmallest(fruits, 0));
		System.out.println("Longest string: " + findLongest(fruits, 0));
		System.out.println("Find the GCD of 40 and 20: " + GCD(40, 20));
		System.out.println("Insert commas for 123456789: " + putCommas(123456789));
		System.out.println("Is ABCD a palindrome? " + isPalindrome("ABCD"));
		System.out.println("Is LEVEL a palindrome? " + isPalindrome("LEVEL"));
		System.out.println("Reverse the word HELLO: " + reverseString("HELLO"));
		System.out.println("The Fibonacci number of 10: " + fib(10));

	}

	// Find the shortest word of an array:
	public static String findSmallest(String[] array, int i) {
		if (i == array.length - 1) {
			// base case: if the index reached the last element
			// it will return that element
			return array[i];
		} else {
			// it will create a new string that calls the function recursively while
			// incrementing the index by 1 each time
			String currentSmall = findSmallest(array, i + 1);

			if (currentSmall.length() > array[i].length()) {
				// checks if the currentSmall (the recursive call) is greater than element
				currentSmall = array[i];
			}
			return currentSmall;
		}
	}

	// Find the longest word of an array:
	public static String findLongest(String[] array, int i) {
		if (i == array.length - 1) {
			return array[i];
		} else {
			String currentLong = findLongest(array, i + 1);
			if (array[i].length() > currentLong.length())
				currentLong = array[i];
			return currentLong;
		}
	}

	// Find the greatest common divisor:
	public static int GCD(int n1, int n2) {
		if (n2 == 0) {
			return n1;
		} else {
			return GCD(n2, n1 % n2);
		}
	}

	// Add commas to format a number
	public static String putCommas(int x) {
		if (x < 1000) {
			return String.valueOf(x);
		} else if (x >= 1000 && x <= 9999) {
			String num = String.valueOf(x);
			return num.charAt(0) + "," + num.substring(1, 4);
		}
		int rem = x % 1000;
		String str = putCommas(x / 1000) + "," + String.valueOf(rem);
		return str;
	}

	// Checks if a string is palindrome (a word same the as it's reverse)
	public static Boolean isPalindrome(String str) {
		if (str.length() == 0 || str.length() == 1) {
			// base case: if the word reached the middle
			return true;
		} else {
			if (str.charAt(0) == str.charAt(str.length() - 1)) {
				// if the first and last characters are the same
				// recursive call will check the same but removing the fist and last characters
				return isPalindrome(str.substring(1, str.length() - 1));
			}
			// else
			return false;
		}
	}

	// Reverse a string
	public static String reverseString(String str) {
		if (str.length() == 0) {
			// base case: if the string is equal to zero
			return str;
		}
		// it will call the function recursively without the first letter each time
		// and it will add the first letter to the end each time
		return reverseString(str.substring(1)) + str.charAt(0);
	}

	public static int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);

	}

}
