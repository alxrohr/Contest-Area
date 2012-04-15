package de.alxrohr.area;

/**
 repr&auml;sentiert einen Gitterpunkt auf dem Rand eines Polygons
 @since 0.1
 @version 0.1 
 */
public class Corner extends EdgePoint implements Cloneable {

	/** y-Koordinate des Punkts 
	 @since 0.1 */
	private int y;

	/**
	 erzeugt einen Punkt mit Typ UNKNOWN und gegebenen Koordinaten
	 * @param x x-Koordinate, ganzzahlig
	 * @param y y-Koordinate, ganzzahlig
	 @since 0.1
	 */
	public Corner(final int x, final int y) {
		super(x, -999);
		this.y = y;
	}

	/**
	 erzeugt einen Punkt gegebenen Koordinaten und gegebenem Typ
	 * @param x x-Koordinate, ganzzahlig
	 * @param y y-Koordinate, ganzzahlig
	 * @param type ENTER oder LEAVE, sonst UNKNOWN
	 @since 0.1
	 */
	public Corner(final int x, final int y, final int type) {
		this(x, y);
		if (type == LEAVE)
			this.type = LEAVE;
		if (type == ENTER)
			this.type = ENTER;
	}

	/**
	 erzeugt einen Punkt mit Typ UNKNOWN aus Move relativ zu einem
	 Basispunkt
	 * @param base Basispunkt
	 * @param offset Move
	 @since 0.1
	 */
	public Corner(final Corner base, final Move offset) {
		this(base.getX() + offset.dx, base.getIntY() + offset.dy);
	}

	/**
	liefert die y-Koordinate dieser <code>Corner</corner> als Flie&szlig;kommazahl, 
	auch wenn deren Wert immer ganzzahlig ist
	 * @see de.alxrohr.area.EdgePoint#getY()
	 */
	public float getY() {
		return y;
	}

	/**
	 liefert die y-Koordinate dieser <code>Corner</corner> als Ganzzahl; 
	 hat immer den gleichen Zahlenwert wie die Flie&szlig;kommazahl <code>this.getY()</code>.
	 * @return y-Koordinate
	 @since 0.1 */
	public int getIntY() {
		return y;
	}

	/**
	 aktualisiert den Typ eines Punkts
	 @param prev vorangehender Eckpunkt des Polygons bei Umlauf
	 gegen den Uhrzeigersinn
	 @param follow nachfolgender Eckpunkt
	 @since 0.1 */
	@SuppressWarnings("finally")
	public void updateType(final Corner prev, final Corner follow) {
		try {
			super.updateType(prev, follow);
		} catch (IllegalArgumentException excep) {
			type = LEAVE;
		} finally {
			if (isAbove(prev) && isLeftOf(follow)) {
				type = ENTER;
				return;
			}
			if (isRightOf(prev) && isAbove(follow)) {
				type = ENTER;
				return;
			}
			if (isRightOf(prev) && isRightOf(follow)
					&& prev.getIntY() > follow.getIntY()) {
				type = ENTER;
				return;
			}
			if (isLeftOf(prev) && isLeftOf(follow)
					&& prev.getIntY() < follow.getIntY()) {
				type = ENTER;
			}
			return;
		}
	}

	/**
	 bestimmt den rechten oberen Eckpunkt des kleinsten
	 achsenparallelen Rechtecks, welches <code>this</code> und
	 <code>corner</code> enth&auml;lt.
	 * @param corner zweiter Punkt im Rechteck
	 @since 0.1 
	 */
	public void max(final Corner corner) {
		if (x < corner.getX())
			x = corner.getX();
		if (y < corner.getIntY())
			y = corner.getIntY();
	}

	/**
	 bestimmt den linken unteren Eckpunkt des kleinsten
	 achsenparallelen Rechtecks, welches <code>this</code> und
	 <code>corner</code> enth&auml;lt.
	 * @param corner zweiter Punkt im Rechteck
	 @since 0.1 
	 */
	public void min(final Corner corner) {
		if (x > corner.getX())
			x = corner.getX();
		if (y > corner.getIntY())
			y = corner.getIntY();
	}

	/**
	 * @see de.alxrohr.area.EdgePoint#equals(java.lang.Object)
	 */
	public boolean equals(final Object anObject) {
		if (anObject instanceof Corner) {
			final Corner aCorner = (Corner) anObject;
			return (x == aCorner.getX()) && (y == aCorner.getIntY())
			&& (type == aCorner.getType());
		}
		return false;
	}

	/**
	 * @see de.alxrohr.area.EdgePoint#toString()
	 */
	public String toString() {
		return "( " + x + ", " + y + " )";
	}

	/**
	 * @see de.alxrohr.area.EdgePoint#hashCode()
	 */
	public int hashCode() {
		return (x << 16) + y;
	}

	/**
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		final Corner corner = new Corner(x, y);
		corner.type = type;
		return corner;
	}

	private boolean isAbove(final Corner corner) {
		return (x == corner.getX()) && (y > corner.getIntY());
	}
}
