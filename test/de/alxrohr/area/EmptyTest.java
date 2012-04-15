/**
 * 
 */
package de.alxrohr.area;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Alexander Rohr
 *
 */
public class EmptyTest {
	private Corner anEmpty;
	private Corner otherEmpty;

	@Before
	public void setUp() throws Exception {
		anEmpty = new Corner ( 0, 0 );
		otherEmpty = new Corner ( 1, 1 );
	}

	@Test
	public void testEmptyMethod() {
		Corner equal = new Corner( 0, 0 );
		assertEquals( anEmpty.hashCode() , equal.hashCode() );
		assertTrue( otherEmpty.hashCode() != equal.hashCode() );
	}

	@Test
	public void testEmptyEquals() {
		assertTrue( !anEmpty.equals (null) ); 
		assertTrue( !otherEmpty.equals (null) ); 
		Corner equal = new Corner( 0, 0 );
		Corner other = new Corner( 1, 1 );
		assertEquals( anEmpty, anEmpty );
		assertEquals( anEmpty, equal );
		assertEquals( otherEmpty, otherEmpty );
		assertEquals( otherEmpty, other );
		assertTrue( ! anEmpty.equals ( otherEmpty ) );
		assertTrue( ! anEmpty.equals ( other ) );
	}

	@Test
	public void testEmptytoString() {
		assertEquals( "( 0, 0 )", anEmpty.toString() );
		assertEquals( "( 1, 1 )", otherEmpty.toString() );
	}

}
