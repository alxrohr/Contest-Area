package de.alxrohr.area;

import junit.framework.*;
import java.io.*;

import de.alxrohr.area.Polygon;
import de.alxrohr.area.Scenario;

@Deprecated
public class PolygonTest3 extends TestCase {

	Polygon poly;

	@Deprecated
	public PolygonTest3(String name) 
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

	@Deprecated
	protected void setUp() {
	}

	@Deprecated
	public void testToString () {
		assertEquals ( "6 7 8.5", poly.toString() );
	}

	@Deprecated
	public static void main(String args[]) {
		junit.swingui.TestRunner.run(PolygonTest3.class);
	}

}
