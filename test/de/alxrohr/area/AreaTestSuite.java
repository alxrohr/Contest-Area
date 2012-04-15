/**
 * 
 */
package de.alxrohr.area;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( {
	MoveTest.class,
	ArrayEnumTest.class,
	AreaMathTest.class,
	PolygonTest.class,
	CornerTest.class,
	EdgePointTest.class,
	EmptyTest.class,
	CornerContainerTest.class,
	SliceTest.class,
	SliceContainerTest.class
} )

/**
 * @author Alexander Rohr
 *
 */
public class AreaTestSuite {
}
