package de.alxrohr.area;

import de.alxrohr.area.Corner;
import junit.framework.*;

@Deprecated
public class EmptyTest3 extends TestCase {
	private Corner anEmpty;
	private Corner otherEmpty;

	@Deprecated
	public EmptyTest3(String name) {
		super(name);
	}

	@Deprecated
	protected void setUp() {
		anEmpty = new Corner ( 0, 0 );
		otherEmpty = new Corner ( 1, 1 );
	}

	@Deprecated
	public void testEmptyMethod() {
		Corner equal = new Corner( 0, 0 );
		assertEquals( anEmpty.hashCode() , equal.hashCode() );
		assertTrue( otherEmpty.hashCode() != equal.hashCode() );
	}

	@Deprecated
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

	@Deprecated
	public void testEmptytoString() {
		assertEquals( "( 0, 0 )", anEmpty.toString() );
		assertEquals( "( 1, 1 )", otherEmpty.toString() );
	}

	@Deprecated
	public static void main(String args[]) {
		junit.swingui.TestRunner.run(EmptyTest3.class);
	}

}
