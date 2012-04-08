package area;

import java.util.Vector;
import java.util.Enumeration;

/**
   A <code>Slice</code> is a container of <code>EdgePoint</code>s with
   equal x-coordinates. A <code>Slice</code> usually is an element of
   a <code>SliceContainer</code> representing a
   <code>Polygon</code>. Such a <code>Slice</code> is able to count
   the number of inner points with this fixed x-coordinate in the
   corresponding <code>Polygon</code>.

   @since 0.1
   @version 0.1 
 */
public class Slice {

    private Vector<EdgePoint> pointVector;

    /** Generates a new empty <code>Slice</code> of a given initial
	size

       @since 0.1 */
    public Slice ( int size ) {
	pointVector = new Vector<EdgePoint>( size, 1 );    
    }

    /** Inserts a new <code>EdgePoint</code> into this
       <code>Slice</code> in such a way that the
       <code>EdgePoints</code> remain sorted with respect to 
       ascending y-coordinates.

       @throws IllegalArgumentException at the attempt of adding a
       point with different x-coordinate or with already existing
       y-coordinate.

       @since 0.1 */
    public void add ( EdgePoint newPoint ) 
    throws IllegalArgumentException 
    {
	if ( ! pointVector.isEmpty() ) {
	    EdgePoint oldPoint = 
		(EdgePoint) pointVector.firstElement();
	    int x = oldPoint.getX();
	    if ( newPoint.getX() != x ) 
		throw new IllegalArgumentException 
		    ("Points with different x-coordinates in slice!");
	    for ( int i = 0 ; i < pointVector.size(); i++ ) {
		oldPoint = (EdgePoint) pointVector.elementAt ( i );
		float y = oldPoint.getY();
		if ( AreaMath.approximates ( newPoint.getY(), y ) ) 
		    throw new IllegalArgumentException 
			("Points with equal y-coordinates in slice!");
		if ( newPoint.getY() < y ) {
		    pointVector.insertElementAt ( newPoint, i );
		    return;
		}
	    }
	}
	pointVector.addElement ( newPoint );
    }

    /** Calculates the number of inner points for a
	<code>Polygon</code> which has this <code>Slice</code> at the
	corresponding x-coordinate

	@since 0.1 */
    public int getInnerPoints () {
        int i = 0;
        int result = 0;

        i = getNextEnterPoint ( i );
	EdgePoint prev;
	EdgePoint next;
        while ( i < pointVector.size() ) {
	    prev = (EdgePoint) pointVector.elementAt ( i );
	    next = (EdgePoint) pointVector.elementAt ( ++i );
            result += innerPointsBetween ( prev.getY(), next.getY() );
            i = getNextEnterPoint ( i );
        }
        return result;
    }

    /** Returns an <code>Enumeration</code> of the
       <code>EdgePoint</code>s contained in <code>this</code>.
       
       @since 0.1 */
    public Enumeration points () {
	return pointVector.elements();
    }

    public boolean equals ( final Object anObject ) {
	if ( ! ( anObject instanceof Slice ) )
	    return false;
	Slice oSlice = (Slice) anObject;
	Enumeration points = points();
	Enumeration other = oSlice.points();
	while ( points.hasMoreElements () ) {
	    if ( ! other.hasMoreElements () ) 
		return false;
	    EdgePoint p = (EdgePoint) points.nextElement();
	    EdgePoint op = (EdgePoint) other.nextElement();
	    if ( ! p.equals ( op ) )
		return false;
	}
	return ( ! other.hasMoreElements () );
    }

    private int getNextEnterPoint ( int i ) 
    throws IllegalStateException
    { 
	EdgePoint point;
	while ( i < pointVector.size() ) {
	    point = (EdgePoint) pointVector.elementAt ( i );
	    int type = point.getType();
	    if ( type == EdgePoint.UNKNOWN )
		throw new IllegalStateException 
		    ("Type of edgepoint unknown!");
	    if ( type == EdgePoint.ENTER )
		break;
	    i++;
	}
	return i;
    }

    private static int innerPointsBetween ( float lo, float hi ) {
	if ( lo >= hi ) 
	    return 0;
	int intlo = (int) Math.floor ( lo );
	int inthi = (int) Math.ceil ( hi );
	return inthi - intlo - 1 ;
    }

    public static void main ( String[] args ) {
	Corner c1 = new Corner ( 0, 0 );
	Corner c5 = new Corner ( 0, 4 );
	Slice s0 = new Slice ( 2 );
	Slice s1 = new Slice ( 2 );
	s0.add ( c1 );
	s0.add ( c5 );
	s1.add ( c1 );
	s1.add ( c5 );
	System.out.println ( s0.equals(s1) );
    }

}
