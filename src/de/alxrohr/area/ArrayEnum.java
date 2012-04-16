package de.alxrohr.area;

import java.util.Enumeration;
import java.util.NoSuchElementException;
/**
   erlaubt Iteration &uuml;ber die Elemente eines Arrays 
   in Form einer Enumeration<br>
   erzeugt keine Kopie des Arrays

   @since 0.1
   @version 0.1
 */
public class ArrayEnum<Element> implements Enumeration<Element> {

    private Element[] array;
    private int maxPos = -1;
    private int pos = -1;

    /**
     * @param array Array, &uuml;ber das iteriert werden soll
     */
    public ArrayEnum ( final Element[] array ) {
	this.array = array;
	maxPos = array.length - 1;
    }

    /**
     * @see java.util.Enumeration#hasMoreElements()
     */
    public boolean hasMoreElements () {
	return ( pos < maxPos );
    }

    /**
     * @see java.util.Enumeration#nextElement()
     */
    public Element nextElement()
    throws NoSuchElementException
    {
	if ( hasMoreElements() )
	    return array [ ++pos ];
	throw new NoSuchElementException ();
    }
}


