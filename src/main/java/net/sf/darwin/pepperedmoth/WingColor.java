/**
 * DARWIN Genetic Algorithms Framework Project.
 * Copyright (C) 2009  Rubecula Software, LLC.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * Module: WingColor.java
 * 
 * Created on Apr 1, 2009
 * 
 * @version $Revision: 1.6 $
 */

package net.sf.darwin.pepperedmoth;

/**
 * An enumerated type for the Peppered Moth wing color.
 * 
 * There are only two values: Typica (the light phase) and Carbonaria (the dark
 * phase). However, for completeness, and/or testing, we also define two other
 * colors: White and Black, in addition to the Undefined color.
 * 
 * Each has a soot density which it matches best (called
 * {@link #sootEquivalent()}).
 * 
 * @author Robin Hillyard
 * 
 */
public enum WingColor {

	/**
	 * soot: 0
	 */
	White(0.0),
	/**
	 * soot: 0.3
	 */
	Typica(0.3),
	/**
	 * soot: 0.7
	 */
	Carbonaria(0.7),
	/**
	 * soot: 1.0
	 */
	Black(1.0),
	/**
	 * 
	 */
	Undefined(-1.0);

	WingColor(final double sootEquivalent) {
		this._sootEquivalent = sootEquivalent;

	}

	/**
	 * @return a value between 0 (pure white) and 1 (pure black)
	 */
	double sootEquivalent() {
		return this._sootEquivalent;
	}

	private final double _sootEquivalent;

	/**
	 * TODO consider making this text language-specific
	 */
	public static final String ID = "Wing Color"; //$NON-NLS-1$
}
