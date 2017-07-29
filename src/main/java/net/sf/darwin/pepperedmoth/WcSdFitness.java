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
 * Module: WcSdFitness.java
 * Created on Apr 1, 2009
 * @version $Revision: 1.28 $
 */

package net.sf.darwin.pepperedmoth;

/**
 * Application-specific Fitness implementation. I'm a bit disappointed because I
 * thought I was going to be able to do this without any instanceof constructs.
 * Maybe I can, but for now I'm going to let it be.
 * 
 * @author Robin Hillyard
 * 
 */
public class WcSdFitness extends Fitness_ implements HasExpressions {

	/**
	 * 
	 */
	public WcSdFitness() {
		this((Evaluator) null, null);
	}

	/**
	 * @param evaluator
	 * @param functionListener
	 *            the function listener (may be null)
	 * 
	 */
	public WcSdFitness(final Evaluator evaluator, final FunctionListener functionListener) {
		super(new FitnessFunction_ScaledNormal(evaluator), functionListener);
	}

	/**
	 * @see net.sf.darwin.core.HasExpressions#getExpressions()
	 */
	@Override
	public ExpressionMap getExpressions() {
		final ExpressionMap result = new ExpressionMap();
		final FitnessFunction fitnessFunction = getFitnessFunction();
		if (fitnessFunction instanceof EvalExpressionMutable) {
			result.addExpression("Fitness: Wing color / soot density", (EvalExpressionMutable) fitnessFunction); //$NON-NLS-1$			
		}
		return result;
	}

	/**
	 * @throws FitnessException
	 * @see net.sf.darwin.core.Fitness#getFitness(net.sf.darwin.core.Trait,
	 *      net.sf.darwin.core.EcoFactor)
	 */
	@Override
	public double getFitness(final Trait trait, final EcoFactor factor) throws FitnessException {
		final Variant variant = trait.getVariant();
		// TODO consider doing this via polymorphism
		if (variant instanceof Variant_WingColor) {
			if (factor instanceof EcoFactor_SootDensity) {
				final double sootEquivalent = ((WingColor) ((Variant_WingColor) variant).getValue()).sootEquivalent();
				final double sootDensity = ((Quantifiable) factor).doubleValue();
				// XXX check that trait.getVariantKey() is correct (maybe
				// should be trait.getCharacterKey())
				return calculateFitness(sootEquivalent, sootDensity, trait.getVariantKey(), factor.getIdentifier());
			}
			return 0;
		}
		return 0;
	}

	/**
	 * @see net.sf.darwin.core.Fitness#getWeight(String,
	 *      net.sf.darwin.core.EcoFactor)
	 */
	@Override
	public int getWeight(final String character, final EcoFactor factor) {
		if (character.equals(WingColor.ID)) {
			// TODO consider doing this via polymorphism
			if (factor instanceof EcoFactor_SootDensity)
				return 1;
			return 0;
		}
		return 0;
	}

	/**
	 * @return 0.25.
	 * 
	 * @see net.sf.darwin.domain.fitness.Fitness_#bandwidth(String)
	 */
	@Override
	protected double bandwidth(final String key) {
		return 0.2;
	}

	/**
	 * Scale down the eco factor by a factor of 10 before comparing with the
	 * soot equivalent.
	 * 
	 * @see net.sf.darwin.domain.fitness.Fitness_#scaleFactor(String)
	 */
	@Override
	protected double scaleFactor(final String key) {
		return 0.1;
	}

}