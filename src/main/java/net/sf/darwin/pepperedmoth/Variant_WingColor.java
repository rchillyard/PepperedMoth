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
 * Module: Variant_WingColor.java
 * 
 * Created on Apr 1, 2009 (replacing an earlier version)
 * 
 * @version $Revision: 1.8 $
 */

package net.sf.darwin.pepperedmoth;

/**
 * @author Robin Hillyard
 * 
 */
public class Variant_WingColor extends Variant_ {

	/**
	 * @param value
	 */
	public Variant_WingColor(final Enum<WingColor> value) {
		super(value.toString(), value);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2540165009478049260L;

	/**
	 * This is only for testing purposes (normally we declare variants in the
	 * XML file).
	 * 
	 * {@link Variant_WingColor} with parameter {@link WingColor#Typica}
	 */
	public static final Variant_WingColor TYPICA = new Variant_WingColor(WingColor.Typica);

	/**
	 * This is only for testing purposes (normally we declare variants in the
	 * XML file).
	 * 
	 * {@link Variant_WingColor} with parameter {@link WingColor#Carbonaria}
	 */
	public static final Variant_WingColor CARBONARIA = new Variant_WingColor(WingColor.Carbonaria);

}