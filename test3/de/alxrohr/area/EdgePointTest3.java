package de.alxrohr.area;

import de.alxrohr.area.Corner;
import de.alxrohr.area.EdgePoint;
import junit.framework.*;

public class EdgePointTest3 extends TestCase {
	private EdgePoint f_0_0_EdgePoint   = new EdgePoint(  0,  0 );
	private EdgePoint f_0_1_EdgePoint   = new EdgePoint(  0,  1 );
	private EdgePoint f_1_0_EdgePoint   = new EdgePoint(  1,  0 );
	private EdgePoint f_1_1_EdgePoint   = new EdgePoint(  1,  1 );
	private EdgePoint f_0_m1_EdgePoint  = new EdgePoint(  0, -1 );
	private EdgePoint f_m1_0_EdgePoint  = new EdgePoint( -1,  0 );
	private EdgePoint f_m1_m1_EdgePoint = new EdgePoint( -1, -1 );
	private EdgePoint f_1_m1_EdgePoint  = new EdgePoint(  1, -1 );
	private EdgePoint f_m1_1_EdgePoint  = new EdgePoint( -1,  1 );
	private EdgePoint point = new EdgePoint ( 3, 5.23f );
	private Corner left = new Corner ( 1, 17 );
	private Corner right = new Corner ( 10, 0 );
	private Corner above = new Corner ( 3, 12 );
	private Corner below = new Corner ( 3, 2 );

	public EdgePointTest3(String name) {
		super(name);
	}

	public void testUpdateTypeDefault () {
		assertEquals ( EdgePoint.UNKNOWN, point.type );
	}

	public void testUpdateTypeLeft2Right () {
		point.updateType ( left, right );
		assertEquals ( EdgePoint.ENTER, point.type );
	}

	public void testUpdateTypeRight2Left () {
		point.updateType ( right, left );
		assertEquals ( EdgePoint.LEAVE, point.type );
	}

	public void testUpdateTypeThrows () 
			throws Exception
			{
		try {
			point.updateType ( left, above );
			fail( "Expected IllegalArgumentException" );
		} catch ( IllegalArgumentException excep ) {
			assertEquals ("Illegal constellation of an EdgePoint", 
					excep.getMessage() );
		}
			}

	public void testUpdateTypeThrowsLeftBelow () 
			throws Exception
			{
		try {
			point.updateType ( left, below );
			fail( "Expected IllegalArgumentException" );
		} catch ( IllegalArgumentException e ) {
			return; // Test is successful
		}
			}

	public void testUpdateTypeThrowsAboveRight () 
			throws Exception
			{
		try {
			point.updateType ( above, right );
			fail( "Expected IllegalArgumentException" );
		} catch ( IllegalArgumentException e ) {
			return; // Test is successful
		}
			}

	public void testUpdateTypeThrowsAboveLeft () 
			throws Exception
			{
		try {
			point.updateType ( above, left );
			fail( "Expected IllegalArgumentException" );
		} catch ( IllegalArgumentException e ) {
			return; // Test is successful
		}
			}	

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

	public void testtoString() {
		assertEquals( "( 0, 0.0 )", f_0_0_EdgePoint.toString() );
		assertEquals( "( 1, -1.0 )", f_1_m1_EdgePoint.toString() );
	}

	public static void main(String args[]) {
		junit.swingui.TestRunner.run(EdgePointTest3.class);
	}

}
