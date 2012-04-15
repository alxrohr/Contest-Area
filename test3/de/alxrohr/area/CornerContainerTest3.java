package de.alxrohr.area;

import junit.framework.*;
import java.util.Enumeration;
import java.util.Vector;

import de.alxrohr.area.Corner;
import de.alxrohr.area.CornerContainer;
import de.alxrohr.area.Move;

public class CornerContainerTest3 extends TestCase {

	Vector moveVec;
	Enumeration moves;
	CornerContainer empty;
	CornerContainer notClosed;
	CornerContainer cc;

	@Deprecated
	public CornerContainerTest3(String name) {
		super(name);
		moveVec = new Vector (10);
		moveVec.addElement ( new Move (  2,  0 ) );
		moveVec.addElement ( new Move (  0,  2 ) );
		moveVec.addElement ( new Move ( -1,  0 ) );
		moveVec.addElement ( new Move ( -1, -1 ) );
		moveVec.addElement ( new Move (  0, -1 ) );
		moves = moveVec.elements();
		cc = new CornerContainer ( 5, moves );
	}

	@Deprecated
	protected void setUp() {
		moves = moveVec.elements();
	}

	@Deprecated
	public void testCornerContainerThrowsEmpty ()
			throws Exception {
		moveVec = new Vector (1);
		moves = moveVec.elements();
		try {
			CornerContainer empty = new CornerContainer ( 0, moves );
			fail( "Expected IllegalArgumentException" );
		} 
		catch ( IllegalArgumentException excep ) {
			assertEquals ("Empty enumeration of moves!",
					excep.getMessage() );
		}
	}

	@Deprecated
	public void testCornerContainerThrowsSizeZero ()
			throws Exception {
		try {
			CornerContainer empty = new CornerContainer ( 0, moves );
			fail( "Expected IllegalArgumentException" );
		} 
		catch ( IllegalArgumentException excep ) {
			assertEquals ("At least 2 moves expected!",
					excep.getMessage() );
		}
	}

	@Deprecated
	public void testCornerContainerThrowsSizeOne ()
			throws Exception {
		moveVec = new Vector (10);
		moveVec.addElement ( new Move (  2,  0 ) );
		moves = moveVec.elements();
		try {
			CornerContainer empty = new CornerContainer ( 1, moves );
			fail( "Expected IllegalArgumentException" );
		} 
		catch ( IllegalArgumentException excep ) {
			assertEquals ("At least 2 moves expected!",
					excep.getMessage() );
		}
	}

	@Deprecated
	public void testCornerContainerThrowsSizeTwo () {
		moveVec = new Vector (10);
		moveVec.addElement ( new Move (  2,  0 ) );
		moveVec.addElement ( new Move (  -2,  0 ) );
		moves = moveVec.elements();
		cc = new CornerContainer ( 2, moves );
	}

	@Deprecated
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

	@Deprecated
	public void testCornerContainerThrowsWrongSizeSix () {
		try {
			cc = new CornerContainer ( 6, moves );
			fail( "Expected IllegalArgumentException" );
		} 
		catch ( IllegalArgumentException excep ) {
			assertEquals ("Expected size of polygon different " + 
					"from number of moves!",
					excep.getMessage() );
		}
	}

	@Deprecated
	public void testCornerContainerThrowsNotClosed () {
		moves.nextElement();
		try {
			CornerContainer cc = new CornerContainer(4, moves);
			fail( "Expected IllegalArgumentException" );
		} 
		catch ( IllegalArgumentException excep ) {
			assertEquals ("Polygon is not closed!",
					excep.getMessage() );
		}
	}

	@Deprecated
	public void testGetGridPointsOnEdge () {
		int e = cc.getGridPointsOnEdge();
		assertEquals ( 7, e);
	}

	@Deprecated
	public void testGetFirstCorner () {
		assertEquals ( new Corner ( 0, 0, Corner.LEAVE ), 
				cc.getFirstCorner() );
	}

	@Deprecated
	public void testGetLastCorner () {
		assertEquals ( new Corner ( 0, 1, Corner.LEAVE ), 
				cc.getLastCorner() );
	}

	@Deprecated
	public void testCorners () {
		Enumeration corners = cc.corners();
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

	@Deprecated
	public static void main(String args[]) {
		junit.swingui.TestRunner.run(CornerContainerTest3.class);
	}

}
