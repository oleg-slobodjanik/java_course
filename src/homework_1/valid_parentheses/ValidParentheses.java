package homework_1.valid_parentheses;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        HashMap<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (bracketMap.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();

                if (topElement != bracketMap.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();

        System.out.println(validParentheses.isValid("()"));      // true
        System.out.println(validParentheses.isValid("()[]{}"));  // true
        System.out.println(validParentheses.isValid("(]"));      // false
        System.out.println(validParentheses.isValid("([])"));    // true
    }
}
