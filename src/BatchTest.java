import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class BatchTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void objTest() {
		Object a = 5;
		Object b = 1;
		batcher myBatch = new batcher(a, 2);

		ArrayList<Object> testList = myBatch.submit(b);
		
		//Test that objBatch returns upon reaching limit condition
		assertNotNull(testList);
	}
		
	@Test
	public void strTest() {
		String c = "hello";
		String d = "world";
		
		batcher myBatch = new batcher(c, 10);
		ArrayList<String> testList2 = myBatch.submit(d);
		
		//Test that strBatch returns upon reaching limit condition
		assertNotNull(testList2);
		
	}

}
