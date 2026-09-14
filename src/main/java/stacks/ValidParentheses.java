
import java.util.Stack;

class ValidParentheses {
    public static void main(String[] args) {
        // Test cases
        System.out.println(isValid("()"));        // true
        System.out.println(isValid("()[]{}"));    // true
        System.out.println(isValid("(]"));        // false
        System.out.println(isValid("([)]"));      // false
        System.out.println(isValid("{[]}"));      // true
    }

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            else {
                if(stack.isEmpty()){
                    return false;
                } 
                char prev = stack.pop();
                if((c==')' && prev != '(') || (c==']' && prev !='[') || (c=='}' && prev!='{')){
                    return false;
                }
            }

        }
        return true;
    }

    
}