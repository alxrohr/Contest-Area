/**
 * 
 */
package de.alxrohr.area;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Alexander Rohr
 *
 */
public class MoveTest {
	private Move f_0_1_Move;
	private Move f_1_0_Move;
	private Move f_1_1_Move;
	private Move f_0_m1_Move;
	private Move f_m1_0_Move;
	private Move f_m1_m1_Move;
	private Move f_1_m1_Move;
	private Move f_m1_1_Move;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		f_0_1_Move   = new Move(  0,  1 );
		f_1_0_Move   = new Move(  1,  0 );
		f_1_1_Move   = new Move(  1,  1 );
		f_0_m1_Move  = new Move(  0, -1 );
		f_m1_0_Move  = new Move( -1,  0 );
		f_m1_m1_Move = new Move( -1, -1 );
		f_1_m1_Move  = new Move(  1, -1 );
		f_m1_1_Move  = new Move( -1,  1 );
	}

	@Test
	public void testMoveThrows () 
			throws Exception
			{
		try {
			@SuppressWarnings("unused")
			Move test = new Move ( 0, 0 );
			fail( "Expected IllegalArgumentException" );
		} catch ( IllegalArgumentException e ) {
			return; // Test is successful
		}
			}

	@Test
	public void testMoveNumGridPoints () {
		assertEquals ( 1, f_0_1_Move.numGridPoints );
		assertEquals ( 1, f_m1_1_Move.numGridPoints );
		assertEquals ( 3, new Move ( 15, -18 ).numGridPoints );
		assertEquals ( 4, new Move ( -12, 8 ).numGridPoints );
	}

	@Test
	public void testMoveHash() {
		Move equal = new Move( 1, -1 );
		assertEquals( f_1_m1_Move.hashCode() , equal.hashCode() );
		assertTrue( f_0_1_Move.hashCode() != equal.hashCode() );
		assertTrue( f_1_0_Move.hashCode() != equal.hashCode() );
		assertTrue( f_1_1_Move.hashCode() != equal.hashCode() );
		assertTrue( f_0_m1_Move.hashCode() != equal.hashCode() );
		assertTrue( f_m1_0_Move.hashCode() != equal.hashCode() );
		assertTrue( f_m1_m1_Move.hashCode() != equal.hashCode() );
		assertTrue( f_m1_1_Move.hashCode() != equal.hashCode() );
	}

	@Test
	public void testMoveEquals() {
		assertTrue( !f_1_1_Move.equals (null) ); 
		assertTrue( !f_1_m1_Move.equals (null) ); 
		Move e_1_1_Move = new Move( 1, 1 );
		Move e_1_m1_Move = new Move( 1, -1 );
		assertEquals( f_1_1_Move, f_1_1_Move );
		assertEquals( f_1_1_Move, e_1_1_Move );
		assertEquals( f_1_m1_Move, f_1_m1_Move );
		assertEquals( f_1_m1_Move, e_1_m1_Move );
		assertTrue( ! f_1_1_Move.equals ( f_1_m1_Move ) );
		assertTrue( ! f_1_1_Move.equals ( e_1_m1_Move ) );
	}

	@Test
	public void testMovetoString() {
		assertEquals( "( 1, 1 )", f_1_1_Move.toString() );
		assertEquals( "( 1, -1 )", f_1_m1_Move.toString() );
	}

}
