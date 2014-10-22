/*
 * Hamburg University of Applied Sciences
 *
 * Programming assignments
 *
 * ngochien.le@haw-hamburg.de
 */
package adt;

/**
 *
 *
 * @author Le
 * @author Nguyen
 */
public class Algebra {

	public static int algebraicExpression(String expression) {
		expression = expression.replaceAll("\\s", "");
		char[] a = expression.toCharArray();
		Stack<String> stack = new ArrayStack<>(a.length);
		int tmpResult = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] >= '0' && a[i] <= '9') {
				stack.push(0 + "");
			}
			while (a[i] >= '0' && a[i] <= '9') {
				tmpResult = 10 * Integer.parseInt(stack.top()) + a[i] - '0';
				stack.push(tmpResult + "");
				i++;
			}
			while (i < a.length && a[i] == ')') {
				int operand2 = Integer.parseInt(stack.top());
				String operator = stack.top();
				int operand1 = Integer.parseInt(stack.top());
				stack.pop();

				switch (operator) {
				case "+":
					tmpResult = operand1 + operand2;
					stack.push(tmpResult + "");
					break;
				case "-":
					tmpResult = operand1 - operand2;
					stack.push(tmpResult + "");
					break;
				case "*":
					tmpResult = operand1 * operand2;
					stack.push(tmpResult + "");
					break;
				case "/":
					tmpResult = operand1 / operand2;
					stack.push(tmpResult + "");
					break;
				}
				i++;
			}
			if (i < a.length) {
				stack.push(a[i] + "");
			}
		}
		return Integer.parseInt(stack.top());
	}
}
