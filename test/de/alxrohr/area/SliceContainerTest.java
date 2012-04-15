package de.alxrohr.area;

import junit.framework.*;
import java.util.Enumeration;
import java.util.Vector;

import de.alxrohr.area.Corner;
import de.alxrohr.area.EdgePoint;
import de.alxrohr.area.Move;
import de.alxrohr.area.Slice;
import de.alxrohr.area.SliceContainer;

public class SliceContainerTest extends TestCase {

    Vector vec;
    SliceContainer sc;
    Enumeration moves;
    Corner c1 = new Corner ( 0, 0 );
    Corner c2 = new Corner ( 4, 1 );
    Corner c3 = new Corner ( 5, 4 );
    Corner c4 = new Corner ( 2, 2 );
    Corner c5 = new Corner ( 0, 4 );
    Corner c6 = new Corner ( 1, 2 );
    EdgePoint e1a = new EdgePoint ( 1, .25f );
    EdgePoint e1b = new EdgePoint ( 2, .5f );
    EdgePoint e1c = new EdgePoint ( 3, .75f );
    EdgePoint e3a = new EdgePoint ( 4, 3.3333333f );
    EdgePoint e3b = new EdgePoint ( 3, 2.6666666f );
    EdgePoint e4a = new EdgePoint ( 1, 3 );
    Slice s0 = new Slice ( 2 );
    Slice s1 = new Slice ( 3 );
    Slice s2 = new Slice ( 2 );
    Slice s3 = new Slice ( 2 );
    Slice s4 = new Slice ( 2 );
    Slice s5 = new Slice ( 2 );
    Slice s6 = new Slice ( 2 );

    public SliceContainerTest ( String name ) {
	super(name);
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
	vec = new Vector (10);
	vec.addElement ( new Move (  4,  1 ) );
	vec.addElement ( new Move (  1,  3 ) );
	vec.addElement ( new Move ( -3, -2 ) );
	vec.addElement ( new Move ( -2,  2 ) );
	vec.addElement ( new Move (  1, -2 ) );
	vec.addElement ( new Move (  -1, -2 ) );
	moves = vec.elements();
	sc = new SliceContainer ( 6, moves );
    }
    
    protected void setUp() {
	moves = vec.elements();
    }

    public void testGetInnerPoints () {
	assertEquals( 6, sc.getInnerPoints () );
    }

    public void testGetGridPointsOnEdge () {
	assertEquals ( 7, sc.getGridPointsOnEdge () );
    }

    public void testSlices () {
	Enumeration slices = sc.slices();
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
    
    public static void main(String args[]) {
	junit.swingui.TestRunner.run ( SliceContainerTest.class );
    }
    
}
