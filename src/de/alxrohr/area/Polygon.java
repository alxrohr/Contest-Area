package de.alxrohr.area;

import java.util.Enumeration;

/**
   central type of the application Area<br> 

   represents and analyses a polygon

   @since 0.1
   @version 0.1 
*/
public class Polygon {
    
    private SliceContainer sliceCont;

    /**
       erzeugt aus einem Szenario eine Repr&auml;sentation des zugeh&ouml;rigen
       Polygons
       
       @since 0.1
    */
    public Polygon ( final Scenario scen ) {
	Enumeration moves = scen.moves();
	sliceCont = new SliceContainer ( scen.getNumMoves(), moves );
    }

    /**
       Gibt die ausgew&auml;hlte Attribute des Polygons als String zur&uuml;ck
       
       @since 0.1
    */
    public String toString() {
	int inside = countGridPointsInside();
	int onEdge = countGridPointsOnEdge();
	return ( inside + " " +
		 onEdge + " " +
		 AreaMath.round( calcArea(inside, onEdge), 1 ) );
    }

    private int countGridPointsOnEdge () {
	return sliceCont.getGridPointsOnEdge();
    }

    private int countGridPointsInside () {
	int innerPoints = 0;
	Enumeration slices = sliceCont.slices();

	while ( slices.hasMoreElements() ) {
	    Slice slice = (Slice) slices.nextElement();
	    innerPoints += slice.getInnerPoints();	    
	}
	return innerPoints;
    }

    private static float calcArea ( final int i, final int e ) {
	return i + ( (float) e - 2 ) / 2;
    }

}
