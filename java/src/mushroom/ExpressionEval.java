package mushroom;

import java.util.Stack;
import java.util.StringTokenizer;

public class ExpressionEval {
	Stack<Long> numbers = new Stack<>();
	Stack<String> operators = new Stack<>();

	public ExpressionEval() {

	}

	public boolean isOperator(String str) {
		switch (str) {
		case "+":
		case "-":
		case "*":
		case "/":
		case "(":
		case ")":
			return true;
		}
		return false;
	}

	public int priority(String str) {
		if (str.equals("+") || str.equals("-")) {
			return 0;
		} else if (str.equals("*") || str.equals("/")) {
			return 1;
		} else if (str.equals("(")) {
			return 2;
		}
		return -1;
	}

	// Returns true if |str| is strictly higher priority than top of stack.
	private boolean higherPriority(String str) {
		if (operators.size() == 0) {
			return true;
		}
		var top = operators.peek();
		if (top.equals("(")) {
			return true;
		}
		if (priority(str) > priority(top)) {
			return true;
		}
		return false;
	}

	private void evaluateTopOfStack() {
		if (numbers.size() < 2 || operators.size() < 1) {
			return;
		}
		var val1 = numbers.pop();
		var val2 = numbers.pop();
		var op = operators.pop();
		long answer = 0;
		switch (op) {
		case "+":
			answer = val1 + val2;
			numbers.push(answer);
			break;
		case "-":
			answer = val2 - val1;
			numbers.push(answer);
			break;
		case "*":
			answer = val1 * val2;
			numbers.push(answer);
			break;
		case "/":
			answer = val1/val2;
			numbers.push(answer);
			break;
		case "(":
			operators.push(op);
			break;
		default:
			throw new IllegalStateException("Invalid operator " + op);
		}
		System.out.printf("Value is: %d %s %d = %d\n", val1, op, val2, answer);
	}

	public void eval(String expr) {
		numbers.clear();
		operators.clear();
		System.out.println("Expression is: " + expr);
		StringTokenizer st = new StringTokenizer(expr, "+-/*() \t", true);
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (token.trim().isEmpty()) {
				continue;
			}
			// System.out.printf("Token is : %s\n", token);
			if (isOperator(token)) {
				if (token.equals(")")) {
					while(!operators.peek().equals("(")) {
						evaluateTopOfStack();
					}
					operators.pop();
				} else if (higherPriority(token)) {
					// if top of stack is lower priority than current operator then push current
					// operator to top of stack
					operators.push(token);
				} else {
					evaluateTopOfStack();
					operators.push(token);
				}
			} else {
				long num = Long.parseLong(token);
				numbers.push(num);
			}
		}
		while (numbers.size() >= 2) {
			evaluateTopOfStack();
		}
		System.out.println(numbers.pop());
	}

	public static void main(String[] args) {
		ExpressionEval ee = new ExpressionEval();
		ee.eval("2*(3+4)");
		ee.eval("(2*(3-4) + 7)");
	}
}
