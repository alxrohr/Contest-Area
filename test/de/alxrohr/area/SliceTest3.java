package de.alxrohr.area;

import junit.framework.*;
import java.util.Enumeration;
import java.util.Vector;

import de.alxrohr.area.Corner;
import de.alxrohr.area.EdgePoint;
import de.alxrohr.area.Slice;

public class SliceTest3 extends TestCase {
    
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
    Slice os1 = new Slice ( 5 );
    int i;

    public SliceTest3 ( String name ) {
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
	os1.add ( e1a );
	os1.add ( e4a );
	os1.add ( c6 );
    }
    
    protected void setUp() {
    }

    public void testGetInnerPointsZero () {
	i = s0.getInnerPoints();
	assertEquals ( 0, i );
    }

    public void testGetInnerPointsOne () {
	i = s1.getInnerPoints();
	assertEquals ( 1, i );
    }

    public void testGetInnerPointsTwo () {
	i = s2.getInnerPoints();
	assertEquals ( 1, i );
    }

    public void testGetInnerPointsThree () {
	i = s3.getInnerPoints();
	assertEquals ( 2, i );
    }

    public void testGetInnerPointsFour () {
	i = s4.getInnerPoints();
	assertEquals ( 2, i );
    }

    public void testGetInnerPointsFive () {
	i = s5.getInnerPoints();
	assertEquals ( 0, i );
    }

    public void testGetInnerPointsSix () {
	i = s6.getInnerPoints();
	assertEquals ( 0, i );
    }

    public void testAddThrowsEqualY () {
	try {
	    s1.add ( c6 );
	    fail( "Expected IllegalArgumentException" );
	} catch ( IllegalArgumentException excep ) {
	    assertEquals ("Points with equal y-coordinates in slice!",
			  excep.getMessage() );
	}
    }

    public void testAddThrowsDiffX () {
	try {
	    s1.add ( c2 );
	    fail( "Expected IllegalArgumentException" );
	} catch ( IllegalArgumentException excep ) {
	    assertEquals ("Points with different x-coordinates in slice!",
			  excep.getMessage() );
	}
    }

    public void testEqualsEmpty() {
	assertTrue( !s6.equals (null) ); 
	assertEquals( s6, s6 );
	assertEquals( s6, new Slice ( 6 ) );
	assertTrue( ! s6.equals ( s1 ) );
	}

    public void testEqualsThree() {
	assertTrue( !s1.equals (null) ); 
	assertEquals( s1, s1 );
	assertEquals( s1, os1 );
	assertTrue( ! s1.equals ( s6 ) );
	}

    public static void main(String args[]) {
	junit.swingui.TestRunner.run ( SliceTest3.class );
    }
    
}
