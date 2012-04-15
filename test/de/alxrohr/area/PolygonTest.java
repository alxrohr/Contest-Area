/**
 * 
 */
package de.alxrohr.area;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.io.StringWriter;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Alexander Rohr
 *
 */
public class PolygonTest {
    static Polygon poly;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
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

	@Test
    public void testToString () {
	assertEquals ( "6 7 8.5", poly.toString() );
    }

}
