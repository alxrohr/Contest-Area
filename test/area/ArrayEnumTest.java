package area;

import junit.framework.*;
import java.util.NoSuchElementException;

public class ArrayEnumTest extends TestCase {
    private Object[] emptyArray = {};
    private Object[] singleArray = { new Integer (100) };
    private Object[] fullArray = { new Integer (100), 
				   new Integer (101),
				   new Integer (102), 
				   new Integer (103) };
    private ArrayEnum emptyEnum;
    private ArrayEnum singleEnum;
    private ArrayEnum fullEnum;

    public ArrayEnumTest(String name) {
	super(name);
    }
    
    public void testArrayEnumHasMoreElements () {
	emptyEnum = new ArrayEnum ( emptyArray );
	singleEnum = new ArrayEnum ( singleArray );
	fullEnum = new ArrayEnum ( fullArray );
	assertTrue( !emptyEnum.hasMoreElements() );
	assertTrue( singleEnum.hasMoreElements() );
	assertTrue( fullEnum.hasMoreElements() );
	}

    public void testArrayEnumNextElementEmpty () 
        throws Exception
    {
	emptyEnum = new ArrayEnum ( emptyArray );
	assertTrue( !emptyEnum.hasMoreElements() );
	try {
	    emptyEnum.nextElement();
	    fail( "Expected NoSuchElementException" );
	} 
	catch ( NoSuchElementException excep ) {
	    assertEquals (null, excep.getMessage() );
	}
    }

    public void testArrayEnumNextElementSingle () 
        throws Exception
    {
	singleEnum = new ArrayEnum ( singleArray );
	assertEquals( singleEnum.nextElement(), new Integer (100) );
	assertTrue( !singleEnum.hasMoreElements() );
	try {
	    singleEnum.nextElement();
	    fail( "Expected NoSuchElementException" );
	} 
	catch ( NoSuchElementException excep ) {
	    assertEquals (null, excep.getMessage() );
	}
    }

    public void testArrayEnumNextElementFull () 
        throws Exception
    {
	fullEnum = new ArrayEnum ( fullArray );
	assertEquals( fullEnum.nextElement(), new Integer (100) );
	assertTrue( fullEnum.hasMoreElements() );
	assertEquals( fullEnum.nextElement(), new Integer (101) );
	assertTrue( fullEnum.hasMoreElements() );
	assertEquals( fullEnum.nextElement(), new Integer (102) );
	assertTrue( fullEnum.hasMoreElements() );
	assertEquals( fullEnum.nextElement(), new Integer (103) );
	assertTrue( !fullEnum.hasMoreElements() );
	try {
	    fullEnum.nextElement();
	    fail( "Expected NoSuchElementException" );
	} 
	catch ( NoSuchElementException excep ) {
	    assertEquals (null, excep.getMessage() );
	}
    }

    public static void main(String args[]) {
	junit.swingui.TestRunner.run(MoveTest.class);
    }
    
}
