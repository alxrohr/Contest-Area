package de.alxrohr.area;

import java.util.Enumeration;
import java.io.*;

/**
   liest ein einzelnes Szenario ein und erlaubt Zugriff darauf in
   Form einer Enumeration und durch Umwandlung in einen String

   @since 0.1
   @version 0.1
 */
public class Scenario {

    private Move[] moveArray;

    /**
       liest ein einzelnes Szenario von einem StreamTokenizer ein

       @param input erwartetes Format: in der ersten Zeile die Anzahl
       der Moves, anschlie&szlig;end entsprechend viele Zeile mit je einem
       Move gegeben durch genau zwei ganze Zahlen, keine Leerzeilen

       @throws java.io.IOException bei Zugriffsproblemen auf den
       Reader und bei Fehlern im Datenformat

       @since 0.1 
    */
    public Scenario ( StreamTokenizer input )
    throws IOException
    {
	if ( input.nextToken() == StreamTokenizer.TT_NUMBER ) 
	   moveArray = new Move[ (int) input.nval ]; 
	else
	    throw new IOException ("Erroneous file format");

	int dx;
	int dy;
	for ( int i = 0; i < moveArray.length; i++ ) {
	    if ( input.nextToken() == StreamTokenizer.TT_NUMBER ) 
		dx = (int) input.nval;
	    else
		throw new IOException ("Erroneous file format");
	    if ( input.nextToken() == StreamTokenizer.TT_NUMBER ) 
		dy = (int) input.nval;
	    else
		throw new IOException ("Erroneous file format");	    
	    moveArray[i] = new Move (dx, dy);
	}
    }

    /**
       @return eine Enumeration der enthaltenen Moves

       @since 0.1
     */
    public Enumeration moves() {
	return new ArrayEnum ( moveArray );
    }

    /**
       @return die Anzahl der Moves in diesem Szenario

       @since 0.1
     */
    public int getNumMoves() {
	return moveArray.length;
    }

    /**
       @return das Szenario in Form eines einzigen (ggf. sehr langen) Strings

       @since 0.1
     */
    public String toString() {
	Enumeration moves = moves();
	StringBuffer buffer = 
	    new StringBuffer ();
	int i = 0;
	while ( moves.hasMoreElements() ) {
	    buffer.append ( "\n" );
	    buffer.append ( "Move Nr. " + i++ + " is " 
			    + moves.nextElement() );
	}
	return "Number of moves is " + i + buffer.toString();
    }

}
