/**
 * 
 */
package de.alxrohr.area;

import static org.junit.Assert.*;

import java.util.Enumeration;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Alexander Rohr
 *
 */
public class CornerContainerTest {
	Vector<Move> moveVec;
	Enumeration<Move> moves;
	CornerContainer empty;
	CornerContainer notClosed;
	CornerContainer cc;

	@Before
	public void runBeforeEveryTest() {
		moveVec = new Vector<Move>(10);
		moveVec.addElement( new Move (  2,  0 ) );
		moveVec.addElement( new Move (  0,  2 ) );
		moveVec.addElement( new Move ( -1,  0 ) );
		moveVec.addElement( new Move ( -1, -1 ) );
		moveVec.addElement( new Move (  0, -1 ) );
		moves = moveVec.elements();
		cc = new CornerContainer( 5, moves );
		moves = moveVec.elements();
	}

	@Test
	public void testCornerContainerThrowsEmpty ()
			throws Exception {
		moveVec = new Vector<Move>(1);
		moves = moveVec.elements();
		try {
			@SuppressWarnings("unused")
			CornerContainer empty = new CornerContainer( 0, moves );
			fail( "Expected IllegalArgumentException" );
		} 
		catch ( IllegalArgumentException excep ) {
			assertEquals( "Empty enumeration of moves!", excep.getMessage() );
		}
	}

	@Test
	public void testCornerContainerThrowsSizeZero ()
			throws Exception {
		try {
			@SuppressWarnings("unused")
			CornerContainer empty = new CornerContainer ( 0, moves );
			fail( "Expected IllegalArgumentException" );
		} 
		catch ( IllegalArgumentException excep ) {
			assertEquals ("At least 2 moves expected!", excep.getMessage() );
		}
	}

	@Test
	public void testCornerContainerThrowsSizeOne ()
			throws Exception {
		moveVec = new Vector<Move>(10);
		moveVec.addElement ( new Move (  2,  0 ) );
		moves = moveVec.elements();
		try {
			@SuppressWarnings("unused")
			CornerContainer empty = new CornerContainer ( 1, moves );
			fail( "Expected IllegalArgumentException" );
		} catch ( IllegalArgumentException excep ) {
			assertEquals ("At least 2 moves expected!",
					excep.getMessage() );
		}
			}

	@Test
	public void testCornerContainerThrowsSizeTwo () {
		moveVec = new Vector<Move>(10);
		moveVec.addElement ( new Move (  2,  0 ) );
		moveVec.addElement ( new Move (  -2,  0 ) );
		moves = moveVec.elements();
		cc = new CornerContainer ( 2, moves );
	}

	@Test
	public void testCornerContainerThrowsWrongSizeFour () {
		try {
			cc = new CornerContainer ( 4, moves );
			fail( "Expected IllegalArgumentException" );
		} 
		catch ( IllegalArgumentException excep ) {
			assertEquals ("Expected size of polygon different " + 
					"from number of moves!",
					excep.getMessage() );
		}
	}

	@Test
	public void testCornerContainerThrowsWrongSizeSix () {
		try {
			cc = new CornerContainer ( 6, moves );
			fail( "Expected IllegalArgumentException" );
		} catch ( IllegalArgumentException excep ) {
			assertEquals ("Expected size of polygon different " + 
					"from number of moves!",
					excep.getMessage() );
		}
	}

	@Test
	public void testCornerContainerThrowsNotClosed () {
		moves.nextElement();
		try {
			@SuppressWarnings("unused")
			CornerContainer cc = new CornerContainer(4, moves);
			fail( "Expected IllegalArgumentException" );
		} catch ( IllegalArgumentException excep ) {
			assertEquals ("Polygon is not closed!",
					excep.getMessage() );
		}
	}

	@Test
	public void testGetGridPointsOnEdge () {
		int e = cc.getGridPointsOnEdge();
		assertEquals ( 7, e);
	}

	@Test
	public void testGetFirstCorner () {
		assertEquals ( new Corner ( 0, 0, Corner.LEAVE ), 
				cc.getFirstCorner() );
	}

	@Test
	public void testGetLastCorner () {
		assertEquals ( new Corner ( 0, 1, Corner.LEAVE ), 
				cc.getLastCorner() );
	}

	@Test
	public void testCorners () {
		Enumeration<Corner> corners = cc.corners();
		assertTrue ( corners.hasMoreElements() );
		assertEquals ( new Corner ( 0, 0, Corner.LEAVE ), 
				(Corner) corners.nextElement() );
		assertTrue ( corners.hasMoreElements() );
		assertEquals ( new Corner ( 2, 0, Corner.LEAVE ), 
				(Corner) corners.nextElement() );
		assertTrue ( corners.hasMoreElements() );
		assertEquals ( new Corner ( 2, 2, Corner.LEAVE ), 
				(Corner) corners.nextElement() );
		assertTrue ( corners.hasMoreElements() );
		assertEquals ( new Corner ( 1, 2, Corner.LEAVE ), 
				(Corner) corners.nextElement() );
		assertTrue ( corners.hasMoreElements() );
		assertEquals ( new Corner ( 0, 1, Corner.LEAVE ), 
				(Corner) corners.nextElement() );
		assertTrue ( ! corners.hasMoreElements() );
	}

}
