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
 * Module: SootColor.java
 * Created on Mar 24, 2009
 * @version $Revision: 1.10 $
 */

package net.sf.darwin.pepperedmoth;

import java.awt.Color;

/**
 * This class extends Color to model a soot color.
 * 
 * @author Robin Hillyard
 * 
 */
public class SootColor extends Color {

	/**
	 * @param sootValue
	 * @param maxSootDensity
	 */
	public SootColor(final Float sootValue, final Float maxSootDensity) {
		this(1 - sootValue.floatValue() / maxSootDensity.floatValue());
	}

	/**
	 * @param x
	 *            a float value between 0 and 1
	 */
	protected SootColor(final float x) {
		super(x, x, x);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1590022688320742734L;

}
