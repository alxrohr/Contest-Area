package area;

/**
   Utility-Klasse mit statischen Methoden, die f&uuml;r Berechnungen gebraucht werden

   @since 0.1
   @version 0.1 
*/
public class AreaMath {

    /**
       berechnet den gr&ouml;&szlig;ten positiven gemeinsamen Teiler zweier ganzer Zahlen
     * @param x ganze Zahl 
     * @param y ganze Zahl, deren ggT mit x berechnet wird
     * @return ggT       
       @since 0.1
    */
    public static int gcd ( int x, int y ) {
	int r;
	int g;
	x = Math.abs (x);
	y = Math.abs (y);
	r = y;  // by default, y is first remainder

	if ( y > x ) {
	    r = x;  // now first remainder is min (x, y)
	    x = y;
	    y = r;  
	}  // now x >= y and r == y	

	g = r;

	/* Euklidischer Algorithmus */
	while ( r > 0 ) {
	    g = r;      // keep old remainder
	    r = x % y;
	    x = y;
	    y = r;
	}

	return g;
    }


    /**
       rundet eine Flie&szlig;kommazahl auf eine angegebene Anzahl von Stellen

       @param a die zu rundende Zahl
       @param d die Nachkommastelle, auf die gerundet werden soll, dabei 0 < d < 10

       @return Stringdarstellung der gerundeten Zahl

       @throws ArithmeticException wenn die Stelle, auf die gerundet
       werden soll, nicht echt zwischen 0 und 10 liegt.
       
       @since 0.1
    */
    public static String round ( final double a, final int d ) 
    throws ArithmeticException
    {
	if ( ( d < 0 ) || ( d > 10 ) ) 
	    throw new ArithmeticException("Illegal rounding digit");

	if ( d == 0 ) 
	    return String.valueOf( Math.round (a) );

	String shifted = 
	    String.valueOf( Math.round ( a * Math.pow ( 10, d ) ) );
	int l = shifted.length();
	String vk = shifted.substring( 0, l - d );
	String nk = shifted.substring ( l - d );
	return ( vk + "." + nk );
    }


    /**
       bestimmt, ob zwei Flie&szlig;kommazahlen nahezu gleich sind
     * @param y1 Flie&szlig;kommazahl
     * @param y2 Flie&szlig;kommazahl, die mit y1 verglichen wird
     * @return true, wenn y1 und y2 nahezu gleich sind

       @since 0.1
    */
    public static boolean approximates ( final float y1, 
					  final float y2 ) {
	return ( Math.abs ( y1 - y2 ) ) < 1e-5;
    }
}
