package eg.edu.alexu.csd.datastructure.stack;
/**
 * 
 * @author Ahmed Ashraf
 *
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExpressionEvalutor_test {
	ExpressionEvaluator e = new ExpressionEvaluator();
	@Test
	void infixtopostfix_test() {
		assertEquals("20 0 2 7 - 0 9 4 + 8 2 - - - + - /",
				e.infixToPostfix("20/-(2-7+-(9+4-(8-2)))"));
        assertEquals("a 0 b - +",e.infixToPostfix("a+-b"));
		
		assertEquals("0 2 7 - 0 5 - + -",e.infixToPostfix("0-(2-7+-5)"));
		
		assertEquals("2 3 4 * +",e.infixToPostfix("2 + 3 * 4"));
		
		assertEquals("a b * 5 +",e.infixToPostfix("a * b + 5"));
		
		assertEquals("a b c - d + / e a - * c *",
				e.infixToPostfix("(a / (b - c + d)) * (e - a) * c"));
		
		assertEquals("a b / c - d e * + a c * -",
				e.infixToPostfix("a / b - c + d * e - a * c"));
		
		assertEquals("3 2 + 2 * 4 + 5 - 10 +",e.infixToPostfix("(((3+2)*2+4)-5)+10"));
		//invalid expression
		assertThrows(RuntimeException.class,()-> {e.infixToPostfix( "7+(2+3+5" );});
		assertThrows(RuntimeException.class,()-> {e.infixToPostfix( "3+2&13*2" );});
		assertThrows(RuntimeException.class,()-> {e.infixToPostfix( "10+2$3" );});
		assertThrows(RuntimeException.class,()-> {e.infixToPostfix( "5+28!" );});
		assertThrows(RuntimeException.class,()-> {e.infixToPostfix( "7*7*" );});
		assertThrows(RuntimeException.class,()-> {e.infixToPostfix( "5-/3" );});
		assertThrows(RuntimeException.class,()-> {e.infixToPostfix( "22+2//3" );});
		
	}
	@Test
	void evaluate_test() {
		assertEquals(8,e.evaluate("6 2 / 3 - 4 2 * +"));
		assertEquals(14,e.evaluate("2 3 4 * +"));
		assertEquals(19,e.evaluate("3 2 + 2 * 4 + 5 - 10 +"));
		//throws
		assertThrows(RuntimeException.class,()-> {e.evaluate("a b c - d + / e a - * c *");});
		assertThrows(RuntimeException.class,()-> {e.evaluate("a 0 b - +");});
	}

}
