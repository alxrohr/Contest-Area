package area;

import java.util.Enumeration;

/**
   Contains all <code>Corner</code>s of a <code>Polygon</code> and is
   responsible to determine their types.

   @since 0.1
   @version 0.1 
*/
public class CornerContainer {

    private final Corner FIRSTCORNER = new Corner ( 0, 0 );

    /** 
	lower left corner of the smallest rectangle parallel to the
	axes and containing the polygon.
	
	@since 0.1 */
    public Corner minCorner = (Corner) FIRSTCORNER.clone();

    /** 
	upper right corner of the smallest rectangle parallel to the
	axes and containing the polygon.
	
	@since 0.1 */
    public Corner maxCorner = (Corner) FIRSTCORNER.clone();

    private Corner[] cornerArray;
    private int pos = 0;
    private int gridPointsOnEdge = 0;

    /** 
	Generates a <code>CornerContainer</code> of given
	<code>size</code> from a sequence of
	<code>Move</code>s and determines the types of its
	<code>Corner</code>s.
	
	@since 0.1 */
    public CornerContainer ( final int size, 
			     Enumeration moves ) 
	throws IllegalArgumentException
    {
	if ( ! moves.hasMoreElements() )
	    throw new IllegalArgumentException 
		("Empty enumeration of moves!");
	if ( size < 2 )
	    throw new IllegalArgumentException 
		("At least 2 moves expected!");

	cornerArray = new Corner [ size ];
	Corner corner = FIRSTCORNER;
	Move move;
	int i = 0;
	do {
	    if ( i < size ) 
		add ( corner );
	    move = (Move) moves.nextElement();
	    i++;
	    gridPointsOnEdge += move.numGridPoints;
	    corner = new Corner ( corner, move );
	}
	while ( moves.hasMoreElements() );

	if ( !corner.equals ( getFirstCorner() ) ) 
	    throw new IllegalArgumentException 
		("Polygon is not closed!");

	if ( i != size )
	    throw new IllegalArgumentException 
		("Expected size of polygon different from number of moves!");

	updateCornerType();
    }

    /** Returns the number of grid points on the edge of the polygon

	@since 0.1 */
    public int getGridPointsOnEdge () {
	return gridPointsOnEdge;
    }

    /** 
	Returns the first <code>Corner</code> in <code>this</code>.
	
	@since 0.1 
    */
    public Corner getFirstCorner () {
	return cornerArray [ 0 ];
    }

    /** 
	Returns the last <code>Corner</code> in <code>this</code>.
	
	@since 0.1 
    */
    public Corner getLastCorner () {
	return cornerArray [ cornerArray.length - 1 ];
    }

    /** 
	Returns an <code>Enumeration</code> of the
	<code>Corners</code> in <code>this</code>.
	
	@since 0.1 */
    public Enumeration corners () {
	return new ArrayEnum ( cornerArray );
    }

    /** 
	Returns a String representation of this.
	
	@since 0.1 */
    public String toString () {
	Enumeration corners = corners();
	StringBuffer buffer = 
	    new StringBuffer ();
	while ( corners.hasMoreElements() ) {
	    Corner corner;
	    if ( ( corner = (Corner) corners.nextElement() ) != null ) {
		buffer.append ( "\n" );
		buffer.append ( "Corner " 
				+ corner.toString() );
	    }
	}
	return buffer.toString();
    }

    private void add ( Corner corner ) {
	cornerArray [ pos++ ] = corner;
	maxCorner.max ( corner );
	minCorner.min ( corner );
    }

    private void updateCornerType () {
	Corner prev = getLastCorner();
	Corner follow = getLastCorner();
	Enumeration corners = corners();
	Corner actual = (Corner) corners.nextElement();
	    
	while ( corners.hasMoreElements() ) {
	    follow = (Corner) corners.nextElement();
	    actual.updateType ( prev, follow );
	    prev = actual;
	    actual = follow;
	}

	actual.updateType ( prev, getFirstCorner() );
    }
}
