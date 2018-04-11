import java.util.*;
public interface StackADT {
	public void push(int x) throws Exception;
	public int pop() throws Exception;
	public int top() throws Exception;
}
class Stack implements StackADT {
	private static final int MAX_SIZE_DEFAULT = 50;
	int[] elements;
	int top;
	int capacity;

	public StackExample() {
		this(MAX_SIZE_DEFAULT);
	}

	public StackExample(int max_size){
		this.elements = new int[max_size];
		this.top = -1;
		this.capacity = max_size;
	}

	public void push(int x) throws Exception {
		if(this.top == this.capacity - 1)
			throw new Exception();
		else {
			this.elements[++this.top] = x;
		}
	}

	public int pop() throws Exception{
		if(this.top == -1)
			throw new Exception();
		else {
			return this.elements[this.top--];
		}
	}

	public int top() throws Exception{
		if(this.top == -1)
			throw new Exception();
		else {
			return this.elements[this.top];
		}
	}

	public static void main(String[] args) {
		StackExample s = new StackExample();
		try {
			s.push(5);
			s.push(103);
			s.push(8);
			s.push(6);

			System.out.println(s.pop());
			System.out.println(s.pop());
			System.out.println(s.pop());
			System.out.println(s.top());
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}