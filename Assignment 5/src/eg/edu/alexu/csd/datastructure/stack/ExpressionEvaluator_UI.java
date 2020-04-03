package eg.edu.alexu.csd.datastructure.stack;
/**
 * 
 * @author Ahmed Ashraf
 *
 */
import java.util.Scanner;

public class ExpressionEvaluator_UI {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
     Scanner s = new Scanner(System.in);
     String expression;
     ExpressionEvaluator e=new ExpressionEvaluator();
	 char choose;
	 System.out.println("Please choose one of the following Operations:\n"
				+ "1.Turn infixToPostfix.\n"
				+ "2.evaluate postfix.\n"
				+ "3.Turning and evaluation.(replacing sympols by integars)\n"
				+ "4.Exit.\n"
				+ "-----------------------------------"
				);
	 
	choose = s.next().charAt(0);
	switch (choose) {
	case '1':
		System.out.println("Enter the infix expression : ");
		s.nextLine();
		expression = s.nextLine();
		try {
		System.out.println("the postfix expression is : "+
		e.infixToPostfix(expression));}
		catch (Exception e2) {
			System.out.println("Wrong infix!!");
		}
		break;
	case '2':
		System.out.println("Enter the postfix expression : ");
		s.nextLine();
		expression = s.nextLine();
		try {
		System.out.println("the evalution  is : "+
		e.evaluate(expression));}
		catch (Exception e2) {
			System.out.println("Wrong postfix!!");
		}
		break;
	case '3':
		System.out.println("Enter the infix expression : ");
		s.nextLine();
		expression = s.nextLine();
		try {
		String update=e.infixToPostfix(expression);
		System.out.println("the postfix expression is : "+
		update);
		update=turn(update);
		System.out.println("the evalution  is : "+
				e.evaluate(update));}
		catch (Exception e2) {
			System.out.println("Wrong infix!!");
		}
		break;
	case '4':
		System.exit(0);
		break;
	default :
		System.out.println("Enter a correct number");
		break;
	}

}
public static String turn(String exp) {
	@SuppressWarnings("resource")
    Scanner s = new Scanner(System.in);
	int size=0;
	for(int i=0;i<exp.length();i++) {
		if (oprand(exp.charAt(i))) {
			size++;
			
		}
	}
	String a="";
	int array1[]=new int [size];
	char array2[]=new char[size];
	int j =0; 
	for(int i=0;i<exp.length();i++) {
		if (oprand(exp.charAt(i))) {
			array2[j]=exp.charAt(i);
			j++;
		}
		
	}
	for(int i=0;i<size;i++) {
		System.out.println("Enter the value of "+array2[i]+" :");
		array1[i]=s.nextInt();
	}
	for(int i = 0;i<exp.length();i++) {
		if (oprand(exp.charAt(i))) {
			for(int z=0;z<size;z++) {
				if (exp.charAt(i)==array2[z]) {
					a=a+array1[z];
					break;
				}
			}
		}else
			a=a+exp.charAt(i);
	}
	System.out.println("The new postfix expression :"+a);
	return a;
}
/**
 * check if it is oprand
 * @param c
 * @return
 * result of checking check if it is oprand
 */
public static boolean oprand(char c) {
	if (c >= 'a' && c <= 'z') {return true;}
	else if (c >= 'A' && c <= 'Z') {return true;}
	else
	   return false;
			
}
}
