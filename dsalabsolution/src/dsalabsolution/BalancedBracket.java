package dsalabsolution;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBracket {

	// function to check if brackets are balanced
	static boolean checkBracketsBalanced(String expr) {
		// Using Java collection Stack
		Stack<Character> stack = new Stack<Character>();

		// Traversing the Expression
		for (int i = 0; i < expr.length(); i++) {

			char localChar = expr.charAt(i);
			if (localChar == '(' || localChar == '[' || localChar == '{') {
				// Push the element in the stack
				stack.push(localChar);
				continue;
			}

			// If current character is not opening bracket, then it must be closing.
			// If stack is empty at this point then brackets are not balanced.
			if (stack.isEmpty())
				return false;

			char check = stack.pop();
			switch (localChar) {
			case ')':
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		// At this time the stack should be empty else the expression is not balanced
		return (stack.isEmpty());
	}

	// Driver code
	public static void main(String[] args) {
		System.out.println("Please enter expression with brackets");
		Scanner scannerObj = new Scanner(System.in);
		String expression = scannerObj.next();

		if (checkBracketsBalanced(expression))
			System.out.println("The expression is Balanced ");
		else
			System.out.println("The expression is Not Balanced ");
		scannerObj.close();
	}

}
