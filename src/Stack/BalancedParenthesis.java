package Stack;

public class BalancedParenthesis {

    public static void main(String[] args) {
        final String paranthesis = ")()(";
        System.out.println(isParanthesisBalanced(paranthesis));
    }

    private static boolean isParanthesisBalanced(String paranthesis) {
        Stack stack = new Stack(paranthesis.length());
        for (int i = 0; i < paranthesis.length(); i++) {
            char character = paranthesis.charAt(i);
            if(character == '{' || character == '[' || character == '(')
                stack.push(character);
            else{
                if(stack.empty())
                    return false;
                else if(character == '}' && stack.peek() == '{')
                    stack.pop();
                else if(character == ']' && stack.peek() == '[')
                    stack.pop();
                else if(character == ')' && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.empty();
    }
}
