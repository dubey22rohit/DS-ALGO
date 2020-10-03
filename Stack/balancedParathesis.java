import java.util.Stack;
public class Solution {
	public static boolean checkBalanced(String exp) {
      int i = 0;
      Stack<Character> e =new Stack<Character>();
     
      for(char c : exp.toCharArray()){
        if(c=='[' || c=='{' || c=='('){
          e.push(c);
        }
        if(c==']' || c=='}' || c==')'){
          if(!e.empty() && helper((char)e.peek(),c)){
            e.pop();
          }else{
            return false;
          }
      }
    }
      return e.empty();
 }
      
      private static boolean helper(char o, char c){
        if(o == '[' || c==']'){
          return true;
        }else if(o == '(' || c==')'){
          return true;
        }else if(o == '{' || c=='}'){
          return true;
        }else{
          return false;
        }
      }
}
