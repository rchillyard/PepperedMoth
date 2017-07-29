/**
 * DARWIN Genetic Algorithms Framework Project.
 * Copyright (C) 2007, 2009  Rubecula Software, LLC.
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
 * Module: Allele_PepperedMoth.java
 * Created on Jan 31, 2007
 * @version $Revision: 1.20 $
 */

package net.sf.darwin.pepperedmoth;

import net.sf.darwin.api.util.StringUtilities;

/**
 * TODO quasi-obsolete. Only used to define the identifier "Melanism".
 * 
 * @author Robin Hillyard
 */
public final class Allele_PepperedMoth {

	/**
	 * normally "Melanism"
	 * 
	 * @see Messages#getString(String) using string "Allele.0"
	 */
	public static final String MELANISM = StringUtilities.capitalizeInitial(Messages.getString("Allele.0"), true); //$NON-NLS-1$

	/**
	 * Non-Melansim
	 */
	public static final String NON_MELANISM = MELANISM.toLowerCase();
}
