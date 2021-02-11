package Stack;

public class StackUse {

	public static void main(String[] args) {
		stack_class s = new stack_class();
		for(int i = 0;i<=5;i++) {
			s.push(i);
		}
		while(!s.isEmpty()) {
			try {
				System.out.println(s.pop());
			} catch (stackEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
