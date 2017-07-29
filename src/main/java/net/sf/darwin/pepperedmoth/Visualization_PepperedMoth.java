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
 * Module: Visualization_PepperedMoth.java
 * Created on Feb 19, 2007
 * @version $Revision: 1.13 $
 */

package net.sf.darwin.pepperedmoth;

import java.text.MessageFormat;

/**
 * <p>
 * Implementer of {@link VisualizableListener} which updates a visualization
 * model, and which is specific to the peppered moth application in that it
 * chooses to ignore the control population for display purposes.
 * </p>
 * 
 * @author Robin Hillyard
 */
@Lifecycle(permanent = true)
public final class Visualization_PepperedMoth extends Visualization_VisualizableListener {

	/**
	 * Constructor for a new {@link Visualization_PepperedMoth}
	 * 
	 * @param factory
	 * @param verbose
	 *            true if caller wants extra information printed on each
	 *            population change.
	 */
	public Visualization_PepperedMoth(final VisualizationFactory factory, final boolean verbose) {
		super(factory);
		this._verbose = verbose;
	}

	/**
	 * if verbose, then we write out the current number of moths.
	 * 
	 * @see net.sf.darwin.visualization.swing.Visualization_VisualizableListener#onChange(Visualizable,
	 *      Object)
	 */
	@SuppressWarnings("boxing")
	@Override
	public void onChange(final Visualizable source, final Object context) {
		super.onChange(source, context);
		if (this._verbose) {
			final String message = MessageFormat.format(LOG_MSG_1, source.getIdentifier(), ((Countable) source).getCount());
			Sink_.sinkOrLog(message, source.getSink(), LOG);
		}
	}

	/**
	 * 
	 */
	private static final String LOG_MSG_1 = "Number of moths in population {0}: {1}"; //$NON-NLS-1$

	private final boolean _verbose;
}