public class Solution {
    public boolean isValid(String s) {
        if(s.length() == 1) return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            } 
            if(!stack.isEmpty()) {
                char curr = stack.peek();
                if(c == ')') {
                    if(curr != '(') return false;
                    else stack.pop();
                }
                if(c == ']') {
                    if(curr != '[') return false;
                    else stack.pop();
                }
                if(c == '}') {
                    if(curr != '{') return false;
                    else stack.pop();
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
