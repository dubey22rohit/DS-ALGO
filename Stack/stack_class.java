package Stack;
import java.util.Stack;
public class stack_class {
public int data[];
int top;
public stack_class() {
	data = new int[10];
	top = -1;
}
public stack_class(int capacity) {
	data = new int[capacity];
	top = -1;
}
public int size() {
	return (top + 1);
}
public boolean isEmpty() {
	return (top == -1);
}
public void doubleCapacity() {
	int temp[] = data;
	data = new int[temp.length*2];
	for(int i = 0;i<temp.length;i++) {
		data[i] = temp[i];
	}
}
public void push(int element) {//throws stackFullException
	if(size() == data.length) {
//		stackFullException e = new stackFullException();
//		throw e;
		doubleCapacity();
	}
	top++;
	data[top] = element;
	
}
public int pop() throws stackEmptyException{
	if(size() == 0) {
		stackEmptyException e = new stackEmptyException();
		throw e;
	}
	int temp = data[top];
	top--;
	return temp;
	
}
//Balanced Parenthesis
public boolean isMatching(char c1,char c2) {
	if(c1 == '{' && c2 == '}') { 
		return true;
	}else if(c1 == '[' && c2 == ']') {
		return true;
	}else if(c1 == '(' && c2 == ')') {
		return true;
	}else {
		return false;
	}

}
public boolean checkBalanced(String exp) {
	if(exp.length() == 0) {
		return true;
	}
	Stack<Character> s = new Stack<>();
	for(char c : exp.toCharArray()) {
		if(c == '{' || c == '[' || c == '(') {
			s.push(c);
	}
		if(c == '}' || c == ']' || c == ')') {
			if(!s.empty() && isMatching((char)s.peek(), c)) {	
				s.pop();
			}else {
				return false;
			}
		}
		
}
	return s.empty();
}
}
