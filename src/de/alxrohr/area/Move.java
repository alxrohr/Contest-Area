package de.alxrohr.area;

/**
   repr&auml;sentiert einen Bewegungsschritt von einem Gitterpunkt zu einem
   anderen innerhalb eines Szenarios und besitzt Information &uuml;ber die
   Anzahl der dabei getroffenen Gitterpunkte

   @since 0.1
   @version 0.1 
*/
public class Move {

    /** Anteil der Bewegung in Richtung der x-Achse */
    public final int dx;

    /** Anteil der Bewegung in Richtung der y-Achse */
    public final int dy;

    /** 
	Anzahl der getroffenen Gitterpunkte, genauer Eins weniger als
	die Anzahl aller auf dem Weg getroffenen Gitterpunkte,
	einschlie&szlig;lich Anfangs- und Endpunkt
    */
    public final int numGridPoints;

    /**
       Erzeugt einen Move und berechnet die getroffenen Gitterpunkte

       @throws IllegalArgumentException ung&uuml;ltiger Bewegungsschritt mit dx == dy == 0

       @since 0.1
    */
    public Move ( final int dx, final int dy )
    throws IllegalArgumentException
    {
	this.dx = dx;
	this.dy = dy;
	if ( dx == 0 && dy == 0 )
	    throw new IllegalArgumentException ("Illegal move (0, 0)!");
	if ( dx == 0 || dy == 0 ) 
	    numGridPoints = Math.abs ( dx ) + Math.abs ( dy );
	else
	    numGridPoints = AreaMath.gcd ( dx, dy );
    }
    
    public String toString () {
	return "( " + dx + ", " + dy + " )";
    }

    public boolean equals ( final Object anObject ) {
	if ( anObject instanceof Move ) {
	    Move aMove = (Move) anObject;
	    return ( dx == aMove.dx ) && ( dy == aMove.dy );
	}
	return false;
    }

    public int hashCode () {
	return ( dx << 16 ) + dy;
    }
}
