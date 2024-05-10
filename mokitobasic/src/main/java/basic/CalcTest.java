package basic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalcTest {

	Calc c1;
	
	@Before
	public void before()
	{
		c1=new Calc();
	}
	
	@Test
	public void test() {
		
		int x=c1.div(6, 2);
		assertEquals(3, x);
	}
	
	@Test
	public void testzeroinput() {
		
		int x=c1.div(6, 0);
		assertEquals(0, x);
	}
	@Test
	public void testNegativeinput() {
		
		int x=c1.div(-6, 0);
		assertEquals(0, x);
	}

	@After
	public void after()
	{
		c1=null;
	}
	
}

