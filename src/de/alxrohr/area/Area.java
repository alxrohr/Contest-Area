package de.alxrohr.area;

import java.util.Enumeration;
import java.io.*;

/**
   zentrale Steuerungsklasse f&uuml;r die Area-Anwendung<br><br>

   Diese Anwendung ist eine L&ouml;sung der Aufgabe 1 "Area" des ACM
   International Collegiate Programming Contest 2001 - 2002,
   Northwestern Europe Regional Contest vom 4. November 2001

   @author Alexander Rohr
   @version 0.1 alpha
 */
public class Area {

	/**
       Liest die Daten der zu verarbeitenden Szenarien von stdin oder
       aus der angegebenen Datei args[0], verarbeitet diese und gibt
       die Resultate aus.

       @param args [FILE]<br>

       Soweit angegeben bezeichnet FILE die
       Eingabedatei mit den zu verarbeitenden Szenarien. Wird kein
       Argument angegeben, so erwartet Area die Eingabedaten von
       stdin.

       @throws java.lang.IllegalArgumentException Area wurde mit
       zwei oder mehr Argumenten aufgerufen.

       @throws java.io.IOException Fehler beim Zugriff auf FILE,
       die Eingabedatei mit den Szenariodaten.

       @throws java.lang.Exception Laufzeitfehler in einer der
       nachgeordneten Klassen; Fehlerursache siehe .toString()

       @since 0.1 
	 */
	public static void main( String[] args )
			throws Exception {
		if ( args.length > 1 )
			throw new IllegalArgumentException("Too many arguments");

		Reader in;
		if ( args.length == 0 )
			in = new InputStreamReader( System.in );
		else
			in = new FileReader( args[0] );

		ScenarioContainer scenCont = new ScenarioContainer( in );

		Enumeration<Scenario> scenEnum = scenCont.scenarios();
		int i = 1;
		loop: while ( scenEnum.hasMoreElements() ) {
			System.out.println( "Scenario #" + ( i++ ) + ":" );
			Polygon polygon = null; 
			try {
				polygon = 
						new Polygon( scenEnum.nextElement() );
			}
			catch ( Exception excep ) {
				System.out.println ( excep );
				continue loop;
			}
			System.out.println ( polygon + "\n" );
		}
	}
}
