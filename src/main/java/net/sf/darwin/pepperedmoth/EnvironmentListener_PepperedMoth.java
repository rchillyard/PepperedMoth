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
 * Module: EnvironmentListener_PepperedMoth.java
 * Created on March 20, 2009
 * @version $Revision: 1.10 $
 */

package net.sf.darwin.pepperedmoth;

/**
 * @author Robin Hillyard
 * 
 */
public final class EnvironmentListener_PepperedMoth extends EnvironmentListener_Visualization {

	/**
	 * @param visualModel
	 */
	public EnvironmentListener_PepperedMoth(final VisualizationModel visualModel) {
		super(visualModel);
	}

	/**
	 * TEST
	 * 
	 * Method which reacts to changes in the environment and which updates the
	 * visualization model. In this case, we update the background color of the
	 * visualization according to the sootiness in the environment.
	 * 
	 * @see net.sf.darwin.core.EnvironmentListener#onEnvironmentChange
	 *      (net.sf.com.phasmid.darwin.core.Environment)
	 */
	@Override
	public void onEnvironmentChange(final Environment env) {
		// TODO need to do this via polymorphism
		// Actually, all we need to do is see if there's a sootColor ecoFactor.
		if (env instanceof Environment_PepperedMoth) {
			final Environment_PepperedMoth envPm = (Environment_PepperedMoth) env;
			getVisualModel().getAttributes().put(Painter.BACKGROUND_COLOR, envPm.getSootColor());
		}
	}

}