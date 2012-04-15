package de.alxrohr.area;

import java.util.Enumeration;
import java.io.*;

/**
   liest eine Menge von Szenarien ein und erlaubt Zugriff darauf in
   Form einer Enumeration und durch Umwandlung in einen String

   @since 0.1
   @version 0.1
 */
public class ScenarioContainer {

    private Scenario[] scenArray;

    /**
       liest Szenarien von einem Reader ein

       @param inputReader erwartetes Format: in der ersten Zeile die
       Anzahl der Szenarien, anschlie&szlig;end entsprechend viele
       Szenarien ohne Leerzeilen

       @throws java.io.IOException bei Zugriffsproblemen auf den
       Reader und bei Fehlern im Datenformat

       @since 0.1
     */
    public ScenarioContainer ( Reader inputReader ) 
    throws IOException
    {
	StreamTokenizer input = new StreamTokenizer ( inputReader );
	if ( input.nextToken() == StreamTokenizer.TT_NUMBER ) 
	   scenArray = new Scenario[ (int) input.nval ]; 
	else
	    throw new IOException ("Erroneous file format");

	for ( int i = 0; i < scenArray.length; i++ )
	    scenArray[i] = new Scenario ( input );
    }


    /**
       @return eine Enumeration der enthaltenen Szenarios 

       @since 0.1
     */
    public Enumeration scenarios () {
	return new ArrayEnum ( scenArray );
    }

    /**
       @return alle Szenarien in Form eines einzigen (ggf. sehr langen) Strings

       @since 0.1
     */
    public String toString() {
	Enumeration scenarios = scenarios();
	StringBuffer buffer = 
	    new StringBuffer ();
	int i = 0;
	while ( scenarios.hasMoreElements() ) {
	    buffer.append ( "\n" );
	    buffer.append ( "Scenario Nr. " + ( i++ ) + "\n" 
			    + scenarios.nextElement().toString() );
	}
	return "Number of scenarios is " + i + buffer.toString();
    }

}
