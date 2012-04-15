/**
 * 
 */
package de.alxrohr.area;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Alexander Rohr
 *
 */
public class EdgePointTest {
	final private static EdgePoint f_0_0_EdgePoint   = new EdgePoint(  0,  0 );
	final private static EdgePoint f_0_1_EdgePoint   = new EdgePoint(  0,  1 );
	final private static EdgePoint f_1_0_EdgePoint   = new EdgePoint(  1,  0 );
	final private static EdgePoint f_1_1_EdgePoint   = new EdgePoint(  1,  1 );
	final private static EdgePoint f_0_m1_EdgePoint  = new EdgePoint(  0, -1 );
	final private static EdgePoint f_m1_0_EdgePoint  = new EdgePoint( -1,  0 );
	final private static EdgePoint f_m1_m1_EdgePoint = new EdgePoint( -1, -1 );
	final private static EdgePoint f_1_m1_EdgePoint  = new EdgePoint(  1, -1 );
	final private static EdgePoint f_m1_1_EdgePoint  = new EdgePoint( -1,  1 );
	final private static EdgePoint point = new EdgePoint ( 3, 5.23f );
	final private static Corner left = new Corner ( 1, 17 );
	final private static Corner right = new Corner ( 10, 0 );
	final private static Corner above = new Corner ( 3, 12 );
	final private static Corner below = new Corner ( 3, 2 );

	@Test
	public void testUpdateTypeDefault () {
		assertEquals ( EdgePoint.UNKNOWN, point.type );
	}

	@Test
	public void testUpdateTypeLeft2Right () {
		point.updateType ( left, right );
		assertEquals ( EdgePoint.ENTER, point.type );
	}

	@Test
	public void testUpdateTypeRight2Left () {
		point.updateType ( right, left );
		assertEquals ( EdgePoint.LEAVE, point.type );
	}

	@Test
	public void testUpdateTypeThrows () 
			throws Exception {
		try {
			point.updateType ( left, above );
			fail( "Expected IllegalArgumentException" );
		} 
		catch ( IllegalArgumentException excep ) {
			assertEquals ("Illegal constellation of an EdgePoint", 
					excep.getMessage() );
		}
	}

	@Test
	public void testUpdateTypeThrowsLeftBelow () 
			throws Exception {
		try {
			point.updateType ( left, below );
			fail( "Expected IllegalArgumentException" );
		} 
		catch ( IllegalArgumentException e ) {
			return; // Test is successful
		}
	}

	@Test
	public void testUpdateTypeThrowsAboveRight () 
			throws Exception {
		try {
			point.updateType ( above, right );
			fail( "Expected IllegalArgumentException" );
		} 
		catch ( IllegalArgumentException e ) {
			return; // Test is successful
		}
	}

	@Test
	public void testUpdateTypeThrowsAboveLeft () 
			throws Exception {
		try {
			point.updateType ( above, left );
			fail( "Expected IllegalArgumentException" );
		} 
		catch ( IllegalArgumentException e ) {
			return; // Test is successful
		}
	}	

	@Test
	public void testHashCode() {
		EdgePoint equal = new EdgePoint( 1, -1 );
		assertEquals( f_1_m1_EdgePoint.hashCode() , equal.hashCode() );
		assertTrue( f_0_0_EdgePoint.hashCode() != equal.hashCode() );
		assertTrue( f_0_1_EdgePoint.hashCode() != equal.hashCode() );
		assertTrue( f_1_0_EdgePoint.hashCode() != equal.hashCode() );
		assertTrue( f_1_1_EdgePoint.hashCode() != equal.hashCode() );
		assertTrue( f_0_m1_EdgePoint.hashCode() != equal.hashCode() );
		assertTrue( f_m1_0_EdgePoint.hashCode() != equal.hashCode() );
		assertTrue( f_m1_m1_EdgePoint.hashCode() != equal.hashCode() );
		assertTrue( f_m1_1_EdgePoint.hashCode() != equal.hashCode() );
	}

	@Test
	public void testEquals() {
		assertTrue( !f_0_0_EdgePoint.equals (null) ); 
		assertTrue( !f_1_m1_EdgePoint.equals (null) ); 
		EdgePoint e_0_0_EdgePoint = new EdgePoint( 0, 0 );
		EdgePoint eps_0_0_EdgePoint = new EdgePoint( 0, 1e-6f );
		EdgePoint del_0_0_EdgePoint = new EdgePoint( 0, 1e-3f );
		EdgePoint e_1_m1_EdgePoint = new EdgePoint( 1, -1 );
		EdgePoint eps_1_m1_EdgePoint = new EdgePoint( 1, -1.000003f );
		EdgePoint del_1_m1_EdgePoint = new EdgePoint( 1, -1.0003f );
		assertEquals( f_0_0_EdgePoint, f_0_0_EdgePoint );
		assertEquals( f_0_0_EdgePoint, e_0_0_EdgePoint );
		assertEquals( f_0_0_EdgePoint, eps_0_0_EdgePoint );
		assertTrue( ! f_0_0_EdgePoint.equals ( del_0_0_EdgePoint ) );
		assertEquals( f_1_m1_EdgePoint, f_1_m1_EdgePoint );
		assertEquals( f_1_m1_EdgePoint, e_1_m1_EdgePoint );
		assertEquals( f_1_m1_EdgePoint, eps_1_m1_EdgePoint );
		assertTrue( ! f_1_m1_EdgePoint.equals ( del_1_m1_EdgePoint ) );
		assertTrue( ! f_0_0_EdgePoint.equals ( f_1_m1_EdgePoint ) );
		assertTrue( ! f_0_0_EdgePoint.equals ( e_1_m1_EdgePoint ) );
	}

	@Test
	public void testtoString() {
		assertEquals( "( 0, 0.0 )", f_0_0_EdgePoint.toString() );
		assertEquals( "( 1, -1.0 )", f_1_m1_EdgePoint.toString() );
	}

}
