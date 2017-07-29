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
 * Module: Mutator_PepperedMoth.java
 * Created on Feb 26, 2007
 * @version $Revision: 1.25 $
 */

package net.sf.darwin.pepperedmoth;

/**
 * This mutator is responsible for keeping the carbonaria allele in the
 * population (or, conceivably, the typica allele) Every now and then, the
 * copying of the gene goes wrong and the other allele is used instead. The
 * frequency of errors can be set dynamically.
 * 
 * Note that this mutator does not override the
 * {@link Mutator#mutate(net.sf.darwin.domain.helper.Genome)} method so
 * that the only type of mutation is switching alleles (no replication,
 * deletion, etc.)
 * 
 * @author Robin Hillyard
 */
public class Mutator_PepperedMoth extends Mutator_Random {

	/**
	 * 
	 * @param random
	 */
	public Mutator_PepperedMoth(final RandomGenerator random) {
		super(random);
	}

	/**
	 * @param random
	 * @param odds
	 */
	public Mutator_PepperedMoth(final RandomGenerator random, final int odds) {
		super(random, odds);
	}

	/**
	 * If we get index 1 from the randomizer, we flip the type of allele.
	 * 
	 * @see net.sf.darwin.domain.genetics.Mutator_#mutate(net.sf.darwin.core.Allele)
	 */
	@Override
	public Allele mutate(final Allele allele) {
		if (getRandom().nextIndex() == 1) {
			// TODO consider doing this via polymorphism
			if (allele instanceof Allele_Dominance) {
				final Allele result = Mutator_PepperedMoth.makeAllele(allele.getLocus(),
						!((Allele_Dominance) allele).isDominant());
				if (LOG.isDebugEnabled())
					LOG.debug("Mutator_PepperedMoth: allele has mutated to " + result); //$NON-NLS-1$
				return result;
			}
			return allele;
		}
		return allele;
	}

	/**
	 * TODO consider copying from the existing set of alleles rather than
	 * creating new instances.
	 * 
	 * @param locus
	 * @param which
	 *            the particular allele to make (either true for melanistic, or
	 *            false for non-melanistic)
	 * @return a newly constructed allele
	 */
	public static Allele makeAllele(final Locus locus, final boolean which) {
		final Allele result = AlleleFactory.makeDominanceAllele(Allele_PepperedMoth.MELANISM, which);
		result.setLocus(locus);
		return result;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6473940956762948178L;

}
