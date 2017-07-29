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
 * Module: VisualizationFactory_PepperedMoth.java
 * Created on Feb 19, 2007
 * @version $Revision: 1.34 $
 */

package net.sf.darwin.pepperedmoth;

import java.awt.Color;
import java.awt.Point;
import java.util.Map;


/**
 * TODO add property angle for peppered moth to lean (once symbol is no longer
 * circle)
 * 
 * Class responsible for creating visualization objects for the PepperedMoth
 * application.
 * 
 * TODO consider extending AToString
 * 
 * @author Robin Hillyard
 */
public class VisualizationFactory_PepperedMoth implements VisualizationFactory {

	/**
	 * Public primary constructor.
	 * 
	 * @param random
	 */
	public VisualizationFactory_PepperedMoth(final RandomGenerator random) {
		super();
		this._random = random;
		this.width = 80;
		this.height = 80;
	}

	/**
	 * 
	 * @see net.sf.darwin.visualization.VisualizationFactory#getHeight()
	 */
	@Override
	public int getHeight() {
		return this.height;
	}

	/**
	 * 
	 * @see net.sf.darwin.visualization.VisualizationFactory#getWidth()
	 */
	@Override
	public int getWidth() {
		return this.width;
	}

	/**
	 * 
	 * XXX properties is unused.
	 * 
	 * @return the result of invoking
	 *         {@link AvatarFactory#makeAvatar(Individual, Point, Color)}
	 * @see net.sf.darwin.visualization.VisualizationFactory#makeAvatar(Individual,
	 *      Map)
	 */
	@Override
	public Avatar makeAvatar(final Individual individual, final Map<String, Object> properties) {
		final Point location = makeLocation(individual);
		final Color color = makeColor(individual);
		return AvatarFactory.makeAvatar(individual, location, color);
	}

	/**
	 * 
	 * @see net.sf.darwin.visualization.VisualizationFactory#makeColor(Individual)
	 */
	@Override
	public Color makeColor(final Individual individual) {
		final Visualizable visualizable = individual.getVisualizable();
		// TODO consider doing this via polymorphism
		if (visualizable instanceof Colony) { // will be true
			// get the color (0: white, 3: black)
			if (individual instanceof Organism) { // will be true
				final WingColor wingColor = VisualizationFactory_PepperedMoth.getWingColor((Organism) individual);
				final int ordinal = wingColor.ordinal();
				final int colors = WingColor.values().length - 1;
				// final double sootEquivalent = wingColor.sootEquivalent();
				return VisualizationFactory_PepperedMoth.convertToGrayLevel(ordinal, colors);
			}
			return Color.red;
		}
		return Color.red;
	}

	/**
	 * 
	 * @see net.sf.darwin.visualization.VisualizationFactory#makeLocation(Individual)
	 */
	@Override
	public Point makeLocation(final Individual individual) {
		final int x = (int) (getWidth() * this._random.nextFloat());
		final int y = (int) (getHeight() * this._random.nextFloat());
		return new Point(x, y);
	}

	/**
	 * 
	 * @see net.sf.darwin.visualization.VisualizationFactory#setHeight(int)
	 */
	@Override
	public void setHeight(@SuppressWarnings("hiding") final int height) {
		this.height = height;
	}

	/**
	 * 
	 * @see net.sf.darwin.visualization.VisualizationFactory#setWidth(int)
	 */
	@Override
	public void setWidth(@SuppressWarnings("hiding") final int width) {
		this.width = width;
	}

	/**
	 * @param greyValue
	 *            the color in range 0=white ... <code>max</code>=black
	 * @param max
	 *            the maximum color value
	 * @return a shade of grey corresponding to the <code>geryValue</code>
	 *         given.
	 * 
	 *         XXX consider moving this method
	 */
	public static Color convertToGrayLevel(final float greyValue, final float max) {
		final float whiteness = 1 - greyValue / (max - 1);
		return new Color(whiteness, whiteness, whiteness);
	}

	/**
	 * TODO Consider moving this somewhere else.
	 * 
	 * @param organism
	 * @return the wing color as a string.
	 */
	public static WingColor getWingColor(final Organism organism) {
		final Phenotype phenotype = organism.getPhenotype();
		if (phenotype != null) {
			final Variant variant = phenotype.getTrait(WingColor.ID).getVariant();
			return (WingColor) variant.getValue();
		}
		throw new DarwinException("getWingColor(): organism already dead: " + organism); //$NON-NLS-1$
	}

	private int width;

	private int height;

	final private RandomGenerator _random;

}
