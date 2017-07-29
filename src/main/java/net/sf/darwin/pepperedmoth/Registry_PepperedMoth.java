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
 * Module: Registry_PepperedMoth.java
 * Created on Apr 11, 2009
 * @version $Revision: 1.16 $
 */

package net.sf.darwin.pepperedmoth;

import java.io.PrintWriter;
import java.util.Collection;

/**
 * @author Robin Hillyard
 * 
 */
public class Registry_PepperedMoth extends Registry_ {

	/**
	 * @param writer
	 *            the writer to which output will be sent.
	 * 
	 */
	public Registry_PepperedMoth(final PrintWriter writer) {
		super();
		this._writer = writer;
	}

	/**
	 * Note the births
	 * 
	 * @see net.sf.darwin.domain.world.Registry_#registerBirths(Colony,
	 *      Collection)
	 */
	@Override
	public void registerBirths(final Colony colony, final Collection<Organism> neonates) {
		int carbonaria = 0;
		int typica = 0;

		for (final Organism organism : neonates) {
			final Phenotype phenotype = organism.getPhenotype();
			final Variant variant = phenotype.getTrait(WingColor.ID).getVariant();
			final Object value = variant.getValue();
			if (value.equals(WingColor.Carbonaria))
				carbonaria++;
			else if (value.equals(WingColor.Typica))
				typica++;
		}

		this._writer
				.println("Births for population: " + colony.getIdentifier() + ": " + neonates.size() + ", typica: " + typica + ", carbonaria: " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
						+ carbonaria);
	}

	private final PrintWriter _writer;

}
