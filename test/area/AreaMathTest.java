package area;

import junit.framework.*;

public class AreaMathTest extends TestCase {
    
    public AreaMathTest(String name) {
	super(name);
    }
    
//      protected void setUp() {
//      }

    public void testGCD() {
	int p1 = 641;
	int p2 = 23;
	int p3 = 17;
	int p4 = 7;
	int p5 = 13;
	int x1 = p1 * p1 * p2;
	int x2 = p3 * p5;
	int x3 = 1;
	int y1 = p1 * p1 * p2 * p3 * p4;
	int y2 = p1 * p1 * p2 * p3 * p5;
	int y3 = p1 * p1 * p2 * p3;
	int z1 = p1 * p1 * p3;
	int z2 = p1 * p1 * p3;
	int z3 = p1 * p1 * p3;
	assertEquals( x3, AreaMath.gcd( x1, x2 ) );
	assertEquals( x3, AreaMath.gcd( -x1, x2 ) );
	assertEquals( x3, AreaMath.gcd( x1, -x2 ) );
	assertEquals( x3, AreaMath.gcd( -x1, -x2 ) );

	assertEquals( y3, AreaMath.gcd( y1, y2 ) );
	assertEquals( y3, AreaMath.gcd( -y1, y2 ) );
	assertEquals( y3, AreaMath.gcd( y1, -y2 ) );
	assertEquals( y3, AreaMath.gcd( -y1, -y2 ) );

  	assertEquals( z3, AreaMath.gcd( z1, z2 ) );
  	assertEquals( z3, AreaMath.gcd( -z1, z2 ) );
  	assertEquals( z3, AreaMath.gcd( z1, -z2 ) );
  	assertEquals( z3, AreaMath.gcd( -z1, -z2 ) );

  	assertEquals( 0, AreaMath.gcd( z1, 0 ) );
  	assertEquals( 0, AreaMath.gcd( -z1, 0 ) );
  	assertEquals( 0, AreaMath.gcd( 0, z2 ) );
  	assertEquals( 0, AreaMath.gcd( 0, -z2 ) );
	}

    public void testRound() {
	assertEquals( "3", AreaMath.round( Math.PI, 0 ) );
	assertEquals( "3.1", AreaMath.round( Math.PI, 1 ) );
	assertEquals( "3.14", AreaMath.round( Math.PI, 2 ) );
	assertEquals( "3.142", AreaMath.round( Math.PI, 3 ) );
	assertEquals( "3.1416", AreaMath.round( Math.PI, 4 ) );
	assertEquals( "-3", AreaMath.round( -1 * Math.PI, 0 ) );
	assertEquals( "-3.1", AreaMath.round( -1 * Math.PI, 1 ) );
	assertEquals( "-3.14", AreaMath.round( -1 * Math.PI, 2 ) );
	assertEquals( "-3.142", AreaMath.round( -1 * Math.PI, 3 ) );
	assertEquals( "-3.1416", AreaMath.round( -1 * Math.PI, 4 ) );
	}

    public static void main(String args[]) {
	junit.swingui.TestRunner.run(AreaMathTest.class);
    }
    
}
