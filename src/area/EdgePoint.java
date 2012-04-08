package area;

/**
   repr&auml;sentiert einen Punkt auf dem Rand eines Polygons, welcher eine
   ganzzahlige x-Koordinate und beliebige y-Koordinate hat

   @since 0.1
   @version 0.1 
*/
public class EdgePoint {

    /** Typ UNKNOWN: Typ wurde noch nicht bestimmt; default 

	since 0.1 */
    public static final int UNKNOWN = 0;

    /** Typ ENTER: senkrecht &uuml;ber diesem Punkt beginnt die innere
        Fl&auml;che des Polygons 

	@since 0.1 */
    public static final int ENTER = 1;

    /** Typ LEAVE: senkrecht &uuml;ber diesem Punkt beginnt das Äu&szlig;ere des
	Polygons 

	@since 0.1 */
    public static final int LEAVE = -1;

    /** Typ des Punktes; m&ouml;gliche Werte UNKNOWN / ENTER / LEAVE 

	Was ist der Typ eines Punkts? Wir denken uns eine senkrechte
	Linie durch den gegebenen Punkt und wandern auf dieser Linie
	von unten her auf den Punkt zu. Dabei wandern wir au"serhalb
	und ggf. auch innerhalb des Polygons, auf dessen Rand der
	gegebene Punkt liegt. Wenn wir bei unserer Wanderung nach oben
	den gegebenen Punkt passieren, kann es sein, da"s wir dabei
	das Innere des Polygons verlassen oder betreten. Es kann aber
	auch sein, da"s wir im Inneren des Polygons oder au"serhalb
	desselben verbleiben.  Der Typ des Punkts gibt an, ob wir
	<em>nach</em> seinem Passieren im Inneren des Polygons sind
	(Typ ENTER) oder au"serhalb (Typ LEAVE). Um den Typ eines
	Punkts zu bestimmen, mu"s man die auf dem Polygonrand davor
	und dahinter liegenden Eckpunkte kennen. Die Reihenfolge der
	Punkte bezieht sich dabei immer auf einen Umlauf um den Rand
	des Polygons <em>gegen den Uhrzeigersinn</em>.

	@since 0.1 */
    protected int type = UNKNOWN;

    /** x-Koordinate des Punkts 

	@since 0.1 */
    protected int x;

    /** y-Koordinate des Punkts 

	@since 0.1 */
    private float y;


    /**
       erzeugt einen Punkt mit Typ UNKNOWN und gegebenen Koordinaten

       @since 0.1
    */
    public EdgePoint ( final int x, final float y ) {
	this.x = x;
	this.y = y;
    }

    /**
       erzeugt einen Punkt von definiertem Typ

       @since 0.1
    */
    public EdgePoint ( final int x, final float y, final boolean enter ) {
	this ( x, y );
	if ( enter ) 
	    type = ENTER;
	else
	    type = LEAVE;
    }

    public int getX () {
	return x;
    }

    public float getY () {
	return y;
    }

    public int getType () {
	return type;
    }

    /**
       determines the type of <code>this</code>.

       @param prev vorangehender Eckpunkt des Polygons bei Umlauf
       gegen den Uhrzeigersinn

       @param follow nachfolgender Eckpunkt

       @since 0.1 */
    public void updateType ( final Corner prev, final Corner follow ) 
	throws IllegalArgumentException 
    {
	if ( isRightOf ( prev ) && isLeftOf ( follow ) ) {
	    type = ENTER;
	    return;
	}
	if ( isLeftOf ( prev ) && isRightOf ( follow ) ) {
	    type = LEAVE;
	    return;
	}
	throw new IllegalArgumentException 
	    ("Illegal constellation of an EdgePoint"); 
    }

    public String toString () {
	return "( " + x + ", " + y + " )";
    }

    public int hashCode () {
	int inty = (int) Math.round ( y * 512 );
	return ( x << 16 ) + inty ;
    }

    /**
       bestimmt, ob Punkt <code>this</code> rechts von Punkt
       <code>corner</code> liegt; die y-Koordinaten werden ignoriert

       @since 0.1 
    */
    protected boolean isRightOf ( final Corner corner ) {
	return this.x > corner.x;
    }

    /**
       bestimmt, ob Punkt <code>this</code> links von Punkt
       <code>corner liegt; die y-Koordinaten werden ignoriert

       @since 0.1 
    */
    protected boolean isLeftOf ( final Corner corner ) {
	return this.x < corner.x;
    }

    public boolean equals ( final Object anObject ) {
	if ( anObject instanceof EdgePoint ) {
	    EdgePoint anEdgePoint = (EdgePoint) anObject;
	    return ( ( x == anEdgePoint.x ) && 
		     ( AreaMath.approximates ( y, anEdgePoint.y ) ) );
	}
	return false;
    }
}
