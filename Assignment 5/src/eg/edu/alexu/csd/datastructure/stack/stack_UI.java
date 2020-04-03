package eg.edu.alexu.csd.datastructure.stack;
/**
 * 
 * @author Ahmed Ashraf
 *
 */
import java.util.Scanner;

public class stack_UI {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		Stack MyStack = new Stack();
		
		boolean q=true;
		while(q) {
			System.out.println("Please choose one of the following Operations:\n"
					+ "1.Push a new element.\n"
					+ "2.Pop an element from the stack.\n"
					+ "3.Return the top element of "
					+ "the stack without removing it.\n"
					+ "4.Get the size of the stack.\n"
					+ "5.Check if the Stack is empty or not.\n"
					+ "6.Exit.\n"
					+ "-----------------------------------"
					);
	    
		char choose = s.next().charAt(0);
		switch (choose) {
		case '1' : 
			System.out.println("Please Enter the value of the element");
			Object o = s.next();
			MyStack.push(o);
			System.out.println("The element is pushed successfully.");
			break;
		case '2' : 
			if (MyStack.isEmpty()) {
				System.out.println("The stack is Empty"
						+ " please start pushing some elements first!");
			}else {
			o = MyStack.pop();
			System.out.println("The Object at the top was");
			System.out.print(o);
			System.out.println();}
			break;
		case '3' :
			if (MyStack.isEmpty()) {
				System.out.println("The stack is Empty"
						+ " please start pushing some elements first!");
			}else {
			o = MyStack.peek();
			System.out.println("The Object at the top is");
			System.out.print(o);
			System.out.println();}
			break;
		case '4' : 
			int size = MyStack.size();
			System.out.printf("The Stack's size = %d", size);
			System.out.println();
			break;
		case '5' : 
			boolean check = MyStack.isEmpty();
			if (check) {
				System.out.println("The Stack is empty.");
			} else {
				System.out.println("The Stack is not empty.");
			}
			break;
		case '6' : 
			q=false;
			break;
		default: System.out.println("Invalid");
				 
	}if(q) {
		System.out.println("Please Choose Again");}
	}
	
	}}

	
