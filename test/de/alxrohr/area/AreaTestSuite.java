package de.alxrohr.area;

import junit.framework.*;

public class AreaTestSuite extends TestCase {

    public AreaTestSuite(String name) {
	super(name);
    }
    
    public static Test suite () {
	TestSuite suite = new TestSuite("AreaTestSuite");
  	suite.addTestSuite(MoveTest.class);
	suite.addTestSuite(ArrayEnumTest.class);
	suite.addTestSuite(AreaMathTest.class);
	suite.addTestSuite(PolygonTest.class);
	suite.addTestSuite(CornerTest.class);
	suite.addTestSuite(EdgePointTest.class);
	suite.addTestSuite(CornerContainerTest.class);
	suite.addTestSuite(SliceTest.class);
	suite.addTestSuite(SliceContainerTest.class);
	return suite;
    }

    public static void main(String args[]) {
	junit.swingui.TestRunner.run(AreaTestSuite.class);
    }

}
