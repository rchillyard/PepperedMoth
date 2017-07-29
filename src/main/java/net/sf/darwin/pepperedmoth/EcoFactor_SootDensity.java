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
 * Module: EcoFactor_SootDensity.java
 * Created on Apr 1, 2009
 * @version $Revision: 1.8 $
 */

package net.sf.darwin.pepperedmoth;

/**
 * Class which extends {@link EcoFactor_Number} and which is specific to the
 * soot density of the peppered moth example.
 * 
 * @author Robin Hillyard
 * 
 */
final public class EcoFactor_SootDensity extends EcoFactor_Number {

	/**
	 * @param value
	 */
	public EcoFactor_SootDensity(final double value) {
		super(KEY_SOOT_DENSITY, Double.valueOf(value));
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5399132326839771733L;

	/**
	 * 
	 */
	public static final String KEY_SOOT_DENSITY = "SootDensity"; //$NON-NLS-1$

}