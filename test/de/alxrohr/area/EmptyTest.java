package de.alxrohr.area;

import de.alxrohr.area.Corner;
import junit.framework.*;

public class EmptyTest extends TestCase {
    private Corner anEmpty;
    private Corner otherEmpty;
    
    public EmptyTest(String name) {
	super(name);
    }
    
    protected void setUp() {
	anEmpty = new Corner ( 0, 0 );
	otherEmpty = new Corner ( 1, 1 );
    }

    public void testEmptyMethod() {
	Corner equal = new Corner( 0, 0 );
	assertEquals( anEmpty.hashCode() , equal.hashCode() );
	assertTrue( otherEmpty.hashCode() != equal.hashCode() );
	}

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

    public void testEmptytoString() {
	assertEquals( "( 0, 0 )", anEmpty.toString() );
	assertEquals( "( 1, 1 )", otherEmpty.toString() );
    }

    public static void main(String args[]) {
	junit.swingui.TestRunner.run(EmptyTest.class);
    }
    
}
