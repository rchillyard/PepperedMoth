/**
 * DARWIN Genetic Algorithms Framework Project.
 * Copyright (C) 2003, 2009  Rubecula Software, LLC.
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
 * Created on Oct 7, 2003
 *
 */

package net.sf.darwin.pepperedmoth;

import java.awt.Color;

/**
 * <p>
 * This class provides an implementation of the {@link Environment} interface
 * for the peppered moth example. It expects one eco factor, of type:
 * {@link EcoFactor_SootDensity}.
 * </p>
 * 
 * @author Robin Hillyard
 * @version $Revision: 1.23 $
 */
public final class Environment_PepperedMoth extends Environment_ {

	/**
	 * @param identifier
	 *            the identifier for this environment.
	 * @param realm
	 *            the environment factory
	 */
	public Environment_PepperedMoth(final String identifier, final Realm realm) {
		super(identifier, realm);
	}

	/**
	 * Log the soot value.
	 * 
	 * @see net.sf.darwin.core.Environment#init()
	 */
	@Override
	public void init() {
		final String msg = ("environment " + getIdentifier() + ": " + "value for soot: ") + getSootValue(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		LOG.info(msg);
	}

	/**
	 * Method to get a color representation of the soot value.
	 * 
	 * TEST
	 * 
	 * @return the soot color (white...black with all shades of grey in
	 *         between).
	 * 
	 *         TODO consider moving this.
	 */
	Color getSootColor() {
		// XXX may need to fix this
		return VisualizationFactory_PepperedMoth.convertToGrayLevel((float) getSootValue(),
				(float) Environment_PepperedMoth.$MaxSootDensity + 1);
	}

	/**
	 * @return the current soot value in this environment.
	 */
	double getSootValue() {
		return getEcoFactorValue(EcoFactor_SootDensity.KEY_SOOT_DENSITY);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8365199085011159615L;

	/**
	 * This defines the range of soot density values: 0 through 10.
	 */
	public static final int $MaxSootDensity = 10;
}
