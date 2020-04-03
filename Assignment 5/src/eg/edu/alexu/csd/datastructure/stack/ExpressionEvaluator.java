package eg.edu.alexu.csd.datastructure.stack;
/**
 * 
 * @author Ahmed Ashraf
 *
 */


public class ExpressionEvaluator implements IExpressionEvaluator {
	/**
	* Takes a symbolic/numeric infix expression as input and converts it to
	* postfix notation. There is no assumption on spaces between terms or the
	* length of the term (e.g., two digits symbolic or numeric term)
	* *
	@param expression
	* infix expression
	* @return postfix expression
	*/
	@Override
	public String infixToPostfix(String expression) {
		StringBuilder expp = new StringBuilder();
		StringBuilder exp = new StringBuilder();
		expp=turn(expression);
		while(true) {
			boolean well=true;
		for(int i=0;i<expp.length();i++) {
		if (i>0 && expp.charAt(i)=='-')	{
			if((!oprand(expp.charAt(i-1))) && (expp.charAt(i-1)!=' '
					&& ( expp.charAt(i-1) != ')'))) {
				well=false;
			}
			else if (i>1  && (expp.charAt(i-1)==' ')&& (!oprand(expp.charAt(i-2)))
					&& ( expp.charAt(i-2) != ')')) {well=false;}
		}
		}
		if(well) {break;}
		else {
			String word=expp.toString();
			expp=new StringBuilder();
			expp=turn(word);
		}
		}
		if(expp.charAt(0)==')' || expp.charAt(0)=='+' 
				|| expp.charAt(0)=='*' || expp.charAt(0)=='/') {
			throw new RuntimeException("stranger element");
		}
		char z=expp.charAt(expp.length()-1);
		if(z=='+' || z=='-' || z=='/' || z=='*' ){
			   throw new RuntimeException("wrong Expression");
		   }
		Stack MyStack = new Stack();
		int i=0;
		for(i=0;i<expp.length();i++) {
			char c=expp.charAt(i);
			if(!good(c)) {
				   throw new RuntimeException("stranger element");
			   }
			if (c==' ') {continue;}
			if (c == '(') {
				   MyStack.push(c);
			   }
			else if (c == ')') {
				boolean x = false;
				while (!MyStack.isEmpty()) { 
					if ((char) MyStack.peek() == '(') {
						MyStack.pop();
						x = true;
						break;
					}
					exp.append(" ");
					exp.append(Character.toString((char) MyStack.pop()));
				   }
				   if (!x) {
					throw new RuntimeException("Wrong expression");
				    }
			}else if (c !='+' && c != '-'  && c != '*' && c != '/' && c != '(' && c != ')') {
				if ((exp.length() != 0) && (i > 0)
						&&(!oprand(expp.charAt(i - 1)))) {
						exp.append(" ");
					}
				exp.append(Character.toString(c)); 
			}
			else if (c == '+' ||c == '-' ||c == '*' ||c == '/' ) {
				if(expp.charAt(i+1)==')') {
					throw new RuntimeException("Wrong expression");	
				}
				if (i< expp.length()- 1) {
				char n=expp.charAt(i + 1);
				   if(n=='+' || n=='-' || n=='/' || n=='*' ){
					   throw new RuntimeException("wrong Expression");
				   }}
				   if (MyStack.isEmpty()) {
					   MyStack.push(c);
				   }else {
					   while (!MyStack.isEmpty()) { 
						   char t=(char)MyStack.pop();
						   if (t=='(') {MyStack.push(t);
						   break;}
						   else if(t == '+' ||t == '-' ||t == '*' ||t == '/' ) {
							   if(HighPrec(c, t)) {
								   MyStack.push(t);
								   break;
							   }else {exp.append(" ");
								   exp.append(t);}
						   }
					   }
					   MyStack.push(c);
				   }
				   
			}
			
		
		}
		while (!MyStack.isEmpty()) { 
			if ((char)MyStack.peek()==')' || (char)MyStack.peek()=='(') {
				throw new RuntimeException("Wrong expression");
			}   exp.append(" ");
			   exp.append(Character.toString((char) MyStack.pop())) ;
		   }
		if(exp.length()==0) {throw new RuntimeException();}
		String output =exp.toString();
		return output;
	}
	/**
	* Evaluate a postfix numeric expression, with a single space separator
	* *
	@param expression
	* postfix expression
	* @return the expression evaluated value
	*/
	@Override
	public int evaluate(String expression) {
		float ans = 0;
	    Stack MyStack = new Stack();
	    String num = new String();
	    if (expression.length() == 0 || expression == null) {
	      throw new RuntimeException();
	    }	 
	    int i = 0;
	    if(expression.charAt(0)==' ') {
	    	i=1;
	    }
	    while (i < expression.length()) {
	      if ((expression.charAt(i) >= '0' && expression.charAt(i) <= '9')) {
	        while (expression.charAt(i) != ' ') {

	          num += expression.charAt(i);
	          i++;
	        }

	        MyStack.push((float) Integer.parseInt(num));
	        i--;

	      } else if (expression.charAt(i) == '*' || expression.charAt(i) == '/'
	          || expression.charAt(i) == '-' || expression.charAt(i) == '+') {
	        float x = (float) MyStack.pop();

	        switch (expression.charAt(i)) {
	        case '+':
	          ans = (float) MyStack.pop() + x;

	          break;

	        case '-':
	          ans = (float) MyStack.pop() - x;

	          break;
	        case '*':
	          ans = (float) MyStack.pop() * x;

	          break;
	        case '/':
	          ans = (float) MyStack.pop() / x;

	          break;
	        default:
	          break;

	        }
	        MyStack.push(ans);
	      }
	      i++;
	      num = "";
	    }
	    if (MyStack.size() > 1) {
	      return 0;
	    }
	    ans = Math.round(ans);
	    return (int) ans;
	}
	/**
	 * this method added dummy zero replacing negative
	 * and put the string in string builder 
	 * @param expression
	 * infix expression
	 * @return 
	 * StringBuilder containing dummy zero
	 */
	public StringBuilder turn(String expression) {
		StringBuilder expp = new StringBuilder();
		StringBuilder sb1 = new StringBuilder(expression);
		for (int i = 0; i < expression.length(); i++) {
			if (sb1.charAt(i) != '-') {
				expp.append(Character.toString(expression.charAt(i)));
			}else if (sb1.charAt(i) == '-') {
				if( (i==0)  || ((!oprand(sb1.charAt(i-1)))   && 
						( sb1.charAt(i-1) != ')') && (sb1.charAt(i-1)!=' '))
						|| ((sb1.charAt(i-1)==' ')  && (!oprand(sb1.charAt(i-2)))   && 
								( sb1.charAt(i-2) != ')'))) {
					expp.append('(');
					expp.append('0');
					expp.append(Character.toString(expression.charAt(i)));
					if(i<expression.length()-1 && oprand(sb1.charAt(i+1))) {
					while( i<expression.length()-1 && oprand(sb1.charAt(i+1)) ) {
						i++;
						expp.append(Character.toString(expression.charAt(i)));
					}
					expp.append(')');}
					else if (i<expression.length()-1 && sb1.charAt(i+1)=='(') {
						int j=check(i+1, expression);
						while (i<j-1) {
							i++;
							expp.append(Character.toString(expression.charAt(i)));	
						}
						expp.append(')');
					}
				}else
					expp.append(Character.toString(expression.charAt(i)));
			}
		}return expp;
	}
	/**
	 * checks if parenthesis completed 
	 * @param i
	 * index of first '('
	 * @param word
	 * the expression containing parenthesis
	 * @return
	 * index of last ')'
	 */
	public int check (int i,String word) {
		Stack parenthesis = new Stack();
		parenthesis.push('(');
		i++;
		while (i<word.length() && !parenthesis.isEmpty()) {
			if(word.charAt(i)=='(') {
				parenthesis.push('(');
			}else if (word.charAt(i)==')') {
				parenthesis.pop();
			}i++;
		}
		if(!parenthesis.isEmpty()) {
			 throw new RuntimeException("wrong Expression");
		}
		
		return i;
	}
	/**
	 * compare if operation has high periorty or no
	 * @param c1
	 * first operation
	 * @param c2
	 * second operation
	 * @return
	 * result of comparing if operation has high periorty or no
	 */
	public boolean HighPrec(char c1,char c2) {
		if((c1=='*' || c1 == '/')&&(c2=='+' || c2 == '-')) {
			return true;
		}else
			return false;
	}
	/**
	 * check if it is available symbol
	 * @param c
	 * @return
	 * result of checking check if it is available symbol
	 */
	public boolean good(char c) {
		if (c >= '0' && c <= '9') {return true;}
		else if (c >= 'a' && c <= 'z') {return true;}
		else if (c >= 'A' && c <= 'Z') {return true;}
		else if (c == '(' || c == ')') {return true;}
		else if (c =='+' || c == '-'  || c == '*' ||c == '/'){return true;}
		else if (c == ' ') {return true;}
		else
		   return false;
				
	}
	/**
	 * check if it is oprand
	 * @param c
	 * @return
	 * result of checking check if it is oprand
	 */
	public boolean oprand(char c) {
		if (c >= '0' && c <= '9') {return true;}
		else if (c >= 'a' && c <= 'z') {return true;}
		else if (c >= 'A' && c <= 'Z') {return true;}
		else
		   return false;
				
	}

}
