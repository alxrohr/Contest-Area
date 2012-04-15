package de.alxrohr.area;

import java.util.Enumeration;

/**
    Contains the <code>Slice</code>s constituting a
    <code>Polygon</code>. Is generated from a sequence of
    <code>Move</code>s.

   @since 0.1
   @version 0.1 */
public class SliceContainer {

    private CornerContainer cornerCont;
    private Slice[] sliceArray;
    private final int offset;
    private final int height;
    
    /** Generates a <code>SliceContainer</code> from an
	<code>Enumeration</code> of <code>Move</code>s.

	@param size number of moves
       
       @since 0.1 */
    public SliceContainer ( int size, Enumeration moves ) {
	cornerCont = new CornerContainer ( size, moves);
	int from = cornerCont.minCorner.getX();
	int to   = cornerCont.maxCorner.getX();
	offset = -from;
	height = 
	    cornerCont.maxCorner.getIntY() 
	    - cornerCont.minCorner.getIntY();
	sliceArray = new Slice [ to - from + 1 ];

	Enumeration corners = cornerCont.corners();
	Corner startCorner = (Corner) corners.nextElement();
	Corner fromCorner = startCorner;
	Corner toCorner;
	while ( corners.hasMoreElements() ) {
	    toCorner = (Corner) corners.nextElement();
	    addEdge ( fromCorner, toCorner );
	    fromCorner = toCorner;
	}
	addEdge ( fromCorner, startCorner );
    }

    /** Determines the number of inner points of the
       <code>Polygon</code> represented by <code>this</code>.
       
       @since 0.1 */
    public int getInnerPoints () {
	Enumeration slices = slices();
	int result = 0;
	while ( slices.hasMoreElements() ) {
	    Slice slice = (Slice) slices.nextElement();
	    result += slice.getInnerPoints();
	}
	return result;
    }

    /** Returns an <code>Enumeration</code> of the <code>Slice</code>s
       contained in <code>this</code>.
       
       @since 0.1 */
    public Enumeration slices () {
	return new ArrayEnum ( sliceArray );
    }

    /** Returns the number of grid points on the edge of the polygon

	@since 0.1 */
    public int getGridPointsOnEdge () {
	return cornerCont.getGridPointsOnEdge();
    }

    private Slice getSlice ( int x ) {
	if ( sliceArray [ x + offset ] == null ) 
	    sliceArray [ x + offset ] = new Slice ( height );
	return sliceArray [ x + offset ];
    }

    private void addEdge ( Corner from, Corner to ) {
	getSlice( from.getX() ).add ( from );
	int dx = to.getX() - from.getX();
	if ( dx == 0 )
	    return;

	float m = 
	    ( to.getY() - from.getY() ) / dx;
	int step = ( from.getX() < to.getX()  ?  1  :  -1 );
	float y;
	for ( int x = from.getX() + step; 
	      x != to.getX(); x += step ) {
	    y = from.getY() + m * ( x - from.getX());
	    getSlice( x ).add 
		( new EdgePoint ( x, y, from.getX() < to.getX() ) );
	}
    }


    public static void main ( String[] args ) {
	java.util.Vector<Move> vec;
	SliceContainer sc;
	Enumeration moves;
	vec = new java.util.Vector<Move> (10);
	vec.addElement ( new Move (  4,  1 ) );
	vec.addElement ( new Move (  1,  3 ) );
	vec.addElement ( new Move ( -3, -2 ) );
	vec.addElement ( new Move ( -2,  2 ) );
	vec.addElement ( new Move (  1, -2 ) );
	vec.addElement ( new Move (  -1, -2 ) );
	moves = vec.elements();
	sc = new SliceContainer ( 6, moves );
	System.out.println ("E = " + sc.getGridPointsOnEdge());
	System.out.println ("I = " + sc.getInnerPoints());
    }
}
