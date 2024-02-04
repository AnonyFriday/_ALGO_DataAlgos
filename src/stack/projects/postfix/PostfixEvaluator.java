/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack.projects.postfix;

import java.util.StringTokenizer;
import stack.theories.StackByLinkedList;

/**
 * The function to
 *
 * @author duyvu
 */
public class PostfixEvaluator {

    /**
     * Support only +, -, *, /
     *
     * @param str: a passed operator
     * @return true if the operator is supported, otherwise return false
     */
    public static boolean isValidOperator(String ele) {
        return ele.equals("+") ||
               ele.equals("-") ||
               ele.equals("*") ||
               ele.equals("/");
    }

    public static double calculatePostFix(double a,
                                          double b,
                                          String operator) {
        if (operator.equals("+")) {
            return a + b;
        };
        if (operator.equals("-")) {
            return a - b;
        };
        if (operator.equals("*")) {
            return a * b;
        };
        if (operator.equals("/")) {
            if (b == 0) {
                throw new RuntimeException("Cannot divide by 0.");
            }
            return a / b;
        };
        throw new RuntimeException("Operator is not supported.");
    }

    // 231*+9- -> 23+9- -> 59- -> -4 -> pop and return -4;
    public static Double evaluate(String expr) {
        StackByLinkedList<Double> nums = new StackByLinkedList<>();
        Double result = 0.0;

        StringTokenizer stk = new StringTokenizer(expr, "() ");
        // (12.3 + 32)

//	for (int i = 0; i < expr.length(); i++) {
//	    String ele = expr.substring(i, i + 1);
        while (stk.hasMoreElements()) {
            String ele = stk.nextToken();

            // temporarily return void if not enough 2 operands on the stack
            if (isValidOperator(ele) && nums.size() < 2) {
                return null;
            }

            // If a valid operator, then
            if (isValidOperator(ele)) {
                double second = nums.pop(); // pop the second foremost since it at the head of stack
                double first = nums.pop();
                result = calculatePostFix(first, second, ele);
                nums.push(result);
            } else if (!isValidOperator(ele)) {

                // If not operator than a digit
                // Push to the stack
                nums.push(Double.parseDouble(ele));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(evaluate("(1) (2) (3) + * (8.2) - "));
    }
}
