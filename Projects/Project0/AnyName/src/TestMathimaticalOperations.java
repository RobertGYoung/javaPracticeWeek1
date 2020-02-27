import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class TestMathimaticalOperations {
	@BeforeClass
	int x,y;
	@Before
	void setup() {
		x=1;
		y=3;	
	}

	
	@Test
	void testAdd() {
		assertTrue(MathimaticalOperations.add(1, 3)==4);
		
	}
	@Test 
	void testSubtract() {
		assertTrue(MathimaticalOperations.sub(1, 3)==-2);
	}
}
