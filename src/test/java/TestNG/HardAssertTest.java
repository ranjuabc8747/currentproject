package TestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class HardAssertTest {
	@Test
public void Hardasserttest1()
{
		System.out.println("****step1 *****");
		System.out.println("*****step2******");
	assertEquals("A", "B");
		System.out.println("----step 3-------");
}
	@Test
	public void Hardasserttest2()
	{
		System.out.println("--------------step 4-----------");
		System.out.println("--------step 5---------");
		assertNotEquals("A", "A");
		System.out.println("---------step 6");
	}
	@Test
	public void hardassert3()
	{
		int m=5;
		assertNotNull(m);
		
		System.out.println("------step9----------");
	}
}
