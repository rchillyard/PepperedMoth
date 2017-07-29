/**
 * DARWIN Genetic Algorithms Framework Project.
 * Copyright (C) 2003,2007, 2009  Rubecula Software, LLC.
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
 * Module: Census_WingColor.java
 * Created on Jan 31, 2007
 * @version $Revision: 1.34 $
 */

package net.sf.darwin.pepperedmoth;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Implementation of {@link SinkCensus} specifically for the PepperedMoth
 * example and which concentrates on showing the mean wing color (and numbers of
 * organisms with each trait).
 * 
 * @author Robin Hillyard
 * 
 */
public final class Census_WingColor extends Census_Darwinian {

	/**
	 * @param printWriter
	 */
	public Census_WingColor(final PrintWriter printWriter) {
		super(printWriter);
	}

	/**
	 * 
	 * @see net.sf.darwin.api.base.domain.world.Census_Darwinian#census(Censusible,
	 *      int, Object)
	 */
	@Override
	public void census(final Censusible individual, final int depth, final Object context) {
		final boolean summaryOnly = false; // set to false if you want more
		// detail
		if (individual instanceof Colony) {
			final Colony colony = (Colony) individual;
			final String identifier = colony.getIdentifier();
			// if (identifier.equalsIgnoreCase("Experimental")) {
			final Environment environment = colony.getEnvironment();
			// TODO consider doing this via polymorphism
			if (environment instanceof Environment_PepperedMoth) {
				getPrintWriter()
						.println(
								"Census_WingColor for Colony: " + identifier + " with soot value: " + ((Environment_PepperedMoth) environment).getSootValue()); //$NON-NLS-1$ //$NON-NLS-2$
				getPrintWriter().println(
						"Generation: " + colony.getPopulation().getTaxon().getGeneration() + " in context: " + context); //$NON-NLS-1$ //$NON-NLS-2$
			}
			Census_WingColor.outputWingColorFrequencies(getPrintWriter(), colony, summaryOnly);
			getPrintWriter().println(""); //$NON-NLS-1$
			// }
		} else
			super.census(individual, depth, context);
	}

	/**
	 * Private static method to output the wing color frequencies for census
	 * purposes.
	 * 
	 * XXX consider moving this elsewhere.
	 * 
	 * @param out
	 *            the output print stream.
	 * @param colony
	 *            the population to be censused.
	 * @param summaryOnly
	 *            if true then the total and average color are shown only.
	 */
	private static void outputWingColorFrequencies(final PrintWriter out, final Colony colony, final boolean summaryOnly) {

		final Map<Object, Integer> frequenciesTrait = new HashMap<Object, Integer>();
		final Map<Object, Integer> frequenciesAllele = new HashMap<Object, Integer>();
		final Map<Object, Integer> frequenciesAge = new HashMap<Object, Integer>();

		double totalFrequenciesTrait = 0;
		int totalFrequenciesAllele = 0;
		int totalFrequenciesAge = 0;

		int totalOrganisms = 0;

		synchronized (colony) {
			for (final Organism organism : colony.getOrganisms()) {
				if (organism.isViable() || organism.getAge() == 0) {
					final double traitValue = Census_WingColor.updateTraitFrequencies(frequenciesTrait, organism);
					totalFrequenciesTrait += traitValue;
					final double alleleValueSum = Census_WingColor.updateAlleleFrequencies(frequenciesAllele, organism);
					totalFrequenciesAllele += alleleValueSum;
					final double ageValueSum = Census_WingColor.updateAgeFrequencies(frequenciesAge, organism);
					totalFrequenciesAge += ageValueSum;
					totalOrganisms++;
				}
			}
		}

		if (!summaryOnly)
			out.print(Messages.getString("PepperedMoth.10")); //$NON-NLS-1$

		for (final Object key : new TreeSet<Object>(frequenciesTrait.keySet())) {
			final Integer frequency = frequenciesTrait.get(key);
			final int colorFrequency = frequency.intValue();
			if (!summaryOnly)
				out.print(key + Messages.getString("PepperedMoth.11") + colorFrequency); //$NON-NLS-1$
			if (!summaryOnly)
				out.print(Messages.getString("PepperedMoth.12")); //$NON-NLS-1$			
		}
		if (!summaryOnly)
			out.println(Messages.getString("PepperedMoth.13")); //$NON-NLS-1$

		final double meanColor = totalFrequenciesTrait / totalOrganisms;
		final double meanAlleleVal = (double) totalFrequenciesAllele / totalOrganisms / 2;
		final double meanAgeVal = (double) totalFrequenciesAge / totalOrganisms;

		out.println(totalOrganisms
				+ Messages.getString("PepperedMoth.14") + meanColor + Messages.getString("PepperedMoth.15") + meanAlleleVal + " and mean age: " + meanAgeVal); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

	}

	private static double updateAgeFrequencies(final Map<Object, Integer> frequencies, final Organism organism) {
		final int age = organism.getAge();
		Census_WingColor.updateFrequencyMap(frequencies, Integer.valueOf(age));
		return age;
	}

	/**
	 * Update the frequencies of the alleles of the non-sex genes
	 * 
	 * @param frequencies
	 * @param organism
	 * @return
	 */
	private static double updateAlleleFrequencies(final Map<Object, Integer> frequencies, final Organism organism) {
		double result = 0;
		final Genes genome = organism.getGenome();
		for (int i = 0; i < genome.size(); i++) {
			final Gene gene = genome.getGene(i);
			final Locus locus = gene.getLocus();
			final String identifier = locus.getIdentifier();

			if (!identifier.equals(Locus.ID_SEX)) {
				final int index0 = 0;
				final Boolean value0 = (Boolean) gene.getAllele(index0).getValue();
				final int index1 = 1;
				final Boolean value1 = (Boolean) gene.getAllele(index1).getValue();
				Census_WingColor.updateFrequencyMap(frequencies, value0);
				Census_WingColor.updateFrequencyMap(frequencies, value1);
				result += ((value0.booleanValue() ? 1 : 0) + (value1.booleanValue() ? 1 : 0));
			}
		}
		return result;
	}

	private static void updateFrequencyMap(final Map<Object, Integer> frequencies, final Object value) {
		Integer frequency = frequencies.get(value);
		if (frequency == null)
			frequency = Integer.valueOf(0);
		frequency = Integer.valueOf(frequency.intValue() + 1);
		frequencies.put(value, frequency);
	}

	private static double updateTraitFrequencies(final Map<Object, Integer> frequencies, final Organism organism) {
		final WingColor wingColor = VisualizationFactory_PepperedMoth.getWingColor(organism);
		final double sootEquivalent = wingColor.sootEquivalent();
		updateFrequencyMap(frequencies, wingColor);
		return sootEquivalent;
	}

}