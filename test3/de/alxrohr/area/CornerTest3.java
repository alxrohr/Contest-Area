package de.alxrohr.area;

import de.alxrohr.area.Corner;
import junit.framework.*;

@Deprecated
public class CornerTest3 extends TestCase {
	private Corner f_0_0_Corner   = new Corner(  0,  0 );
	private Corner f_0_1_Corner   = new Corner(  0,  1 );
	private Corner f_1_0_Corner   = new Corner(  1,  0 );
	private Corner f_1_1_Corner   = new Corner(  1,  1 );
	private Corner f_0_m1_Corner  = new Corner(  0, -1 );
	private Corner f_m1_0_Corner  = new Corner( -1,  0 );
	private Corner f_m1_m1_Corner = new Corner( -1, -1 );
	private Corner f_1_m1_Corner  = new Corner(  1, -1 );
	private Corner f_m1_1_Corner  = new Corner( -1,  1 );
	private Corner corner;
	private final Corner keep = new Corner ( 3, 5 );
	private Corner nw = new Corner ( 1, 17 );
	private Corner ne = new Corner ( 9, 17 );
	private Corner sw = new Corner ( 2, 0 );
	private Corner se = new Corner ( 10, 0 );
	private Corner  n = new Corner ( 3, 12 );
	private Corner  s = new Corner ( 3, 2 );
	private Corner  w = new Corner ( 1, 5 );
	private Corner  e = new Corner ( 8, 5 );

	@Deprecated
	public CornerTest3(String name) {
		super(name);
	}

	@Deprecated
	protected void setUp() {
		corner = new Corner ( 3, 5 );
	}

	@Deprecated
	public void testUpdateTypeDefault () {
		assertEquals ( Corner.UNKNOWN, new Corner ( 3, 5 ).getType() );
	}

	@Deprecated
	public void testUpdateTypeENTER () {
		assertEquals ( Corner.ENTER, 
				new Corner ( 3, 5, Corner.ENTER ).getType() );
	}

	@Deprecated
	public void testUpdateTypeLEAVE () {
		assertEquals ( Corner.LEAVE, 
				new Corner ( 3, 5, Corner.LEAVE ).getType() );
	}

	@Deprecated
	public void testUpdateTypeW2E () {
		corner.updateType ( w, e );
		assertEquals ( Corner.ENTER, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeSW2NE () {
		corner.updateType ( sw, ne );
		assertEquals ( Corner.ENTER, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeNW2SE () {
		corner.updateType ( nw, se );
		assertEquals ( Corner.ENTER, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeE2W () {
		corner.updateType ( e, w );
		assertEquals ( Corner.LEAVE, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeNE2SW () {
		corner.updateType ( ne, sw );
		assertEquals ( Corner.LEAVE, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeSE2NW () {
		corner.updateType ( se, nw );
		assertEquals ( Corner.LEAVE, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeNW2SW () {
		corner.updateType ( nw, sw );
		assertEquals ( Corner.ENTER, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeSW2NW () {
		corner.updateType ( sw, nw );
		assertEquals ( Corner.LEAVE, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeSE2NE () {
		corner.updateType ( nw, sw );
		assertEquals ( Corner.ENTER, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeNE2SE () {
		corner.updateType ( ne, se );
		assertEquals ( Corner.LEAVE, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeS2W () {
		corner.updateType ( s, w );
		assertEquals ( Corner.LEAVE, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeS2E () {
		corner.updateType ( s, e );
		assertEquals ( Corner.ENTER, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeN2E () {
		corner.updateType ( n, e );
		assertEquals ( Corner.LEAVE, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeN2W () {
		corner.updateType ( n, w );
		assertEquals ( Corner.LEAVE, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeN2S () {
		corner.updateType ( n, s );
		assertEquals ( Corner.LEAVE, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeS2N () {
		corner.updateType ( s, n );
		assertEquals ( Corner.LEAVE, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeW2N () {
		corner.updateType ( w, n );
		assertEquals ( Corner.LEAVE, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeE2N () {
		corner.updateType ( e, n );
		assertEquals ( Corner.LEAVE, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeW2S () {
		corner.updateType ( w, s );
		assertEquals ( Corner.ENTER, corner.getType() );
	}

	@Deprecated
	public void testUpdateTypeE2S () {
		corner.updateType ( e, s );
		assertEquals ( Corner.LEAVE, corner.getType() );
	}

	@Deprecated
	public void testMaxSW () {
		corner.max ( sw );
		assertEquals ( keep, corner );
	}

	@Deprecated
	public void testMaxNE () {
		corner.max ( ne );
		assertEquals ( ne, corner );
	}

	@Deprecated
	public void testMaxNW () {
		Corner max = new Corner ( corner.getX(), nw.getIntY() );
		corner.max ( nw );
		assertEquals ( max, corner );
	}

	@Deprecated
	public void testMaxSE () {
		Corner max = new Corner ( se.getX(), corner.getIntY() );
		corner.max ( se );
		assertEquals ( max, corner );
	}

	@Deprecated
	public void testMinSW () {
		corner.min ( sw );
		assertEquals ( sw, corner );
	}

	@Deprecated
	public void testMinNE () {
		corner.min ( ne );
		assertEquals ( keep, corner );
	}

	@Deprecated
	public void testMinNW () {
		Corner min = new Corner ( nw.getX(), corner.getIntY() );
		corner.min ( nw );
		assertEquals ( min, corner );
	}

	@Deprecated
	public void testMinSE () {
		Corner min = new Corner ( corner.getX(), se.getIntY() );
		corner.min ( se );
		assertEquals ( min, corner );
	}

	@Deprecated
	public void testClone () {
		Corner corner = new Corner ( 3, 2 );
		Corner clone = (Corner) corner.clone();
		assertEquals ( corner, clone );
		assertTrue ( corner != clone );
	}

	@Deprecated
	public void testHashCode() {
		Corner equal = new Corner( 1, -1 );
		assertEquals( f_1_m1_Corner.hashCode() , equal.hashCode() );
		assertTrue( f_0_0_Corner.hashCode() != equal.hashCode() );
		assertTrue( f_0_1_Corner.hashCode() != equal.hashCode() );
		assertTrue( f_1_0_Corner.hashCode() != equal.hashCode() );
		assertTrue( f_1_1_Corner.hashCode() != equal.hashCode() );
		assertTrue( f_0_m1_Corner.hashCode() != equal.hashCode() );
		assertTrue( f_m1_0_Corner.hashCode() != equal.hashCode() );
		assertTrue( f_m1_m1_Corner.hashCode() != equal.hashCode() );
		assertTrue( f_m1_1_Corner.hashCode() != equal.hashCode() );
	}

	@Deprecated
	public void testEquals() {
		assertTrue( !f_0_0_Corner.equals (null) ); 
		assertTrue( !f_1_m1_Corner.equals (null) ); 
		Corner e_0_0_Corner = new Corner( 0, 0 );
		Corner e_1_m1_Corner = new Corner( 1, -1 );
		assertEquals( f_0_0_Corner, f_0_0_Corner );
		assertEquals( f_0_0_Corner, e_0_0_Corner );
		assertEquals( f_1_m1_Corner, f_1_m1_Corner );
		assertEquals( f_1_m1_Corner, e_1_m1_Corner );
		assertTrue( ! f_0_0_Corner.equals ( f_1_m1_Corner ) );
		assertTrue( ! f_0_0_Corner.equals ( e_1_m1_Corner ) );
	}

	@Deprecated
	public void testtoString() {
		assertEquals( "( 0, 0 )", f_0_0_Corner.toString() );
		assertEquals( "( 1, -1 )", f_1_m1_Corner.toString() );
	}

	@Deprecated
	public static void main(String args[]) {
		junit.swingui.TestRunner.run(CornerTest3.class);
	}

}
