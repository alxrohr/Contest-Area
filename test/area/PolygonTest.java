package area;

import junit.framework.*;
import java.io.*;

public class PolygonTest extends TestCase {

    Polygon poly;

    public PolygonTest(String name) 
	throws IOException
    {
	super(name);
	StringWriter strOut = new StringWriter ();
	PrintWriter out = new PrintWriter ( strOut );
	out.println ( "6" );
	out.println (  "4  1" );
	out.println ( " 1  3" );
	out.println ( "-3 -2" );
	out.println ( "-2  2" );
	out.println ( " 1 -2" );
	out.println ( "-1 -2" );
	out.flush();
	StringReader strIn = new StringReader ( strOut.toString() );
	StreamTokenizer in = new StreamTokenizer ( strIn );
	Scenario scen = new Scenario ( in );
	poly = new Polygon ( scen );
    }
    
    protected void setUp() {
      }

    public void testToString () {
	assertEquals ( "6 7 8.5", poly.toString() );
    }

    public static void main(String args[]) {
	junit.swingui.TestRunner.run(PolygonTest.class);
    }
    
}
