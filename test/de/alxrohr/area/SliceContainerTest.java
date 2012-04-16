/**
 * 
 */
package de.alxrohr.area;

import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.Vector;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Alexander Rohr
 *
 */
public class SliceContainerTest {
	static Vector<Move> vec;
	static SliceContainer sc;
	static Enumeration<Move> moves;
	final static Corner c1 = new Corner ( 0, 0 );
	final static Corner c2 = new Corner ( 4, 1 );
	final static Corner c3 = new Corner ( 5, 4 );
	final static Corner c4 = new Corner ( 2, 2 );
	final static Corner c5 = new Corner ( 0, 4 );
	final static Corner c6 = new Corner ( 1, 2 );
	final static EdgePoint e1a = new EdgePoint ( 1, .25f );
	final static EdgePoint e1b = new EdgePoint ( 2, .5f );
	final static EdgePoint e1c = new EdgePoint ( 3, .75f );
	final static EdgePoint e3a = new EdgePoint ( 4, 3.3333333f );
	final static EdgePoint e3b = new EdgePoint ( 3, 2.6666666f );
	final static EdgePoint e4a = new EdgePoint ( 1, 3 );
	final static Slice s0 = new Slice ( 2 );
	final static Slice s1 = new Slice ( 3 );
	final static Slice s2 = new Slice ( 2 );
	final static Slice s3 = new Slice ( 2 );
	final static Slice s4 = new Slice ( 2 );
	final static Slice s5 = new Slice ( 2 );
	final static Slice s6 = new Slice ( 2 );

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void runBeforeClass() throws Exception {
		c1.updateType ( c6, c2 );
		c2.updateType ( c1, c3 );
		c3.updateType ( c2, c4 );
		c4.updateType ( c3, c5 );
		c5.updateType ( c4, c6 );
		c6.updateType ( c5, c1 );
		e1a.updateType ( c1, c2 );
		e1b.updateType ( c1, c2 );
		e1c.updateType ( c1, c2 );
		e3a.updateType ( c3, c4 );
		e3b.updateType ( c3, c4 );
		e4a.updateType ( c4, c5 );
		s0.add ( c1 );
		s0.add ( c5 );
		s1.add ( c6 );
		s1.add ( e1a );
		s1.add ( e4a );
		s2.add ( c4 );
		s2.add ( e1b );
		s3.add ( e1c );
		s3.add ( e3b );
		s4.add ( e3a );
		s4.add ( c2 );
		s5.add ( c3 );
		vec = new Vector<Move> (10);
		vec.addElement ( new Move (  4,  1 ) );
		vec.addElement ( new Move (  1,  3 ) );
		vec.addElement ( new Move ( -3, -2 ) );
		vec.addElement ( new Move ( -2,  2 ) );
		vec.addElement ( new Move (  1, -2 ) );
		vec.addElement ( new Move (  -1, -2 ) );
		moves = vec.elements();
		sc = new SliceContainer ( 6, moves );
	}
	
	@Before
	public void runBeforeEveryTest() throws Exception {
	moves = vec.elements();
}

	@Test
	public void testGetInnerPoints () {
		assertEquals( 6, sc.getInnerPoints () );
	}

	@Test
	public void testGetGridPointsOnEdge () {
		assertEquals ( 7, sc.getGridPointsOnEdge () );
	}

	@Test
	public void testSlices () {
		Enumeration<Slice> slices = sc.slices();
		assertTrue ( slices.hasMoreElements() );
		assertEquals ( s0, (Slice) slices.nextElement() );
		assertTrue ( slices.hasMoreElements() );
		assertEquals ( s1, (Slice) slices.nextElement() );
		assertTrue ( slices.hasMoreElements() );
		assertEquals ( s2, (Slice) slices.nextElement() );
		assertTrue ( slices.hasMoreElements() );
		assertEquals ( s3, (Slice) slices.nextElement() );
		assertTrue ( slices.hasMoreElements() );
		assertEquals ( s4, (Slice) slices.nextElement() );
		assertTrue ( slices.hasMoreElements() );
		assertEquals ( s5, (Slice) slices.nextElement() );
		assertTrue ( ! slices.hasMoreElements() );
	}

}
