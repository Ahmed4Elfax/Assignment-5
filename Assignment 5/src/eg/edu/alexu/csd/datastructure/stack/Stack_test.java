package eg.edu.alexu.csd.datastructure.stack;
/**
 * 
 * @author Ahmed Ashraf
 *
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Stack_test {

	@Test
	void test() {
		Stack a  = new Stack();
		a.push(7);
		a.push(4);
		a.push(3);
		a.push(10);
		assertEquals(10,a.peek());
		a.pop();
		assertEquals(3,a.peek());
		assertEquals(3,a.size());
		a.push("ahmed");
		assertEquals("ahmed",a.peek());
		assertEquals("ahmed",a.pop());
		a.pop();
		a.pop();
		a.pop();
		assertEquals(0,a.size());
		assertEquals(true,a.isEmpty());
		assertThrows(RuntimeException.class,()->{a.pop();});
		
	}

}
