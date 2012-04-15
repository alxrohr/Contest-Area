/**
 * 
 */
package de.alxrohr.area;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * @author Alexander Rohr
 *
 */
public class ArrayEnumTest {
	private static Object[] emptyArray = {};
	private static Object[] singleArray = { new Integer (100) };
	private static Object[] fullArray = { 
		new Integer (100), 
		new Integer (101),
		new Integer (102), 
		new Integer (103) };
	private static ArrayEnum emptyEnum;
	private static ArrayEnum singleEnum;
	private static ArrayEnum fullEnum;

	@BeforeClass
	public static void runOnceBeforeClass() {
		emptyEnum = new ArrayEnum ( emptyArray );
		singleEnum = new ArrayEnum ( singleArray );
		fullEnum = new ArrayEnum ( fullArray );
	}

	@Test
	public void testArrayEnumHasMoreElements () {
		assertTrue( !emptyEnum.hasMoreElements() );
		assertTrue( singleEnum.hasMoreElements() );
		assertTrue( fullEnum.hasMoreElements() );
	}

	@Test
	public void testArrayEnumNextElementEmpty () 
			throws Exception {
		assertTrue( !emptyEnum.hasMoreElements() );
		try {
			emptyEnum.nextElement();
			fail( "Expected NoSuchElementException" );
		} 
		catch ( NoSuchElementException excep ) {
			assertEquals (null, excep.getMessage() );
		}
	}

	@Test
	public void testArrayEnumNextElementSingle () 
			throws Exception {
		assertEquals( singleEnum.nextElement(), new Integer (100) );
		assertTrue( !singleEnum.hasMoreElements() );
		try {
			singleEnum.nextElement();
			fail( "Expected NoSuchElementException" );
		} 
		catch ( NoSuchElementException excep ) {
			assertEquals (null, excep.getMessage() );
		}
	}

	@Test
	public void testArrayEnumNextElementFull () 
			throws Exception {
		assertEquals( fullEnum.nextElement(), new Integer (100) );
		assertTrue( fullEnum.hasMoreElements() );
		assertEquals( fullEnum.nextElement(), new Integer (101) );
		assertTrue( fullEnum.hasMoreElements() );
		assertEquals( fullEnum.nextElement(), new Integer (102) );
		assertTrue( fullEnum.hasMoreElements() );
		assertEquals( fullEnum.nextElement(), new Integer (103) );
		assertTrue( !fullEnum.hasMoreElements() );
		try {
			fullEnum.nextElement();
			fail( "Expected NoSuchElementException" );
		} 
		catch ( NoSuchElementException excep ) {
			assertEquals (null, excep.getMessage() );
		}
	}

}
