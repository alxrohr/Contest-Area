package de.alxrohr.area;

import junit.framework.*;

@Deprecated
public class AreaTestSuite3 extends TestCase {

	@Deprecated
	public AreaTestSuite3(String name) {
		super(name);
	}

	@Deprecated
	public static Test suite () {
		TestSuite suite = new TestSuite("AreaTestSuite");
		suite.addTestSuite(MoveTest3.class);
		suite.addTestSuite(ArrayEnumTest3.class);
		suite.addTestSuite(AreaMathTest3.class);
		suite.addTestSuite(PolygonTest3.class);
		suite.addTestSuite(CornerTest3.class);
		suite.addTestSuite(EdgePointTest3.class);
		suite.addTestSuite(EmptyTest3.class);
		suite.addTestSuite(CornerContainerTest3.class);
		suite.addTestSuite(SliceTest3.class);
		suite.addTestSuite(SliceContainerTest3.class);
		return suite;
	}

	@Deprecated
	public static void main(String args[]) {
		junit.swingui.TestRunner.run(AreaTestSuite3.class);
	}

}
