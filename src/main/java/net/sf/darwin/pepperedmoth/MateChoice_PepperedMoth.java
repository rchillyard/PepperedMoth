/**
 * DARWIN Genetic Algorithms Framework Project.
 * Copyright (C) 2003,2009  Rubecula Software, LLC.
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
 * Created on Dec 7, 2003
 *
 */

package net.sf.darwin.pepperedmoth;

/**
 * Default implementation of MateChoice. In this default implementation, females
 * are not at all choosy - all males appear as bad as all others! Sound
 * familiar?
 * 
 * @author Robin Hillyard
 * @version $Revision: 1.20 $
 */
public final class MateChoice_PepperedMoth extends MateChoice_Evaluator {

	/**
	 * Public secondary constructor -- with no evaluator.
	 * 
	 * @param random
	 *            a random number generator
	 */
	public MateChoice_PepperedMoth(final RandomGenerator random) {
		this(random, (Evaluator) null, null);
	}

	/**
	 * Public constructor.
	 * 
	 * @param random
	 *            a random number generator
	 * @param evaluatorDesirable
	 *            the expression evaluator to be used for the desirability
	 *            formula (or null)
	 * @param evaluatorChoosy
	 *            the expression evaluator to be used for the
	 *            minimum-desirability formula (or null)
	 */
	public MateChoice_PepperedMoth(final RandomGenerator random, final Evaluator evaluatorDesirable,
			final Evaluator evaluatorChoosy) {
		this(random, new Function_Desirable(evaluatorDesirable), new Function_Choosy(evaluatorChoosy));
	}

	/**
	 * Public constructor with uniform attraction.
	 * 
	 * @param random
	 *            a random number generator
	 * @param functionDesirable
	 *            the expression evaluator to be used for the desirability
	 *            formula (or null)
	 * @param functionChoosy
	 *            the expression evaluator to be used for the
	 *            minimum-desirability formula (or null)
	 */
	public MateChoice_PepperedMoth(final RandomGenerator random, final Function_Desirable functionDesirable,
			final Function_Choosy functionChoosy) {
		this(random, functionDesirable, functionChoosy, new Attraction_Uniform());
	}

	/**
	 * Public constructor.
	 * 
	 * @param random
	 *            a random number generator
	 * @param functionDesirable
	 *            the expression evaluator to be used for the desirability
	 *            formula (or null)
	 * @param functionChoosy
	 *            the expression evaluator to be used for the
	 *            minimum-desirability formula (or null)
	 * @param attraction
	 *            the sexual attraction.
	 */
	public MateChoice_PepperedMoth(final RandomGenerator random, final Function_Desirable functionDesirable,
			final Function_Choosy functionChoosy, final Attraction attraction) {
		super(random, functionDesirable, functionChoosy, attraction);
	}

}
