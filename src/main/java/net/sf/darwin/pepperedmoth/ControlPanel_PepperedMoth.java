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
 * Module: ControlPanel_Default.java
 * Created on Feb 12, 2007
 * @version $Revision: 1.13 $
 */

package net.sf.darwin.pepperedmoth;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BoxLayout;

/**
 * A control panel (the lower part of the applet) useful for the peppered moth
 * example.
 * 
 * @author Robin Hillyard
 */
public class ControlPanel_PepperedMoth extends ControlPanel_ {

	/**
	 * Constructor which sets up a pair of flip/flop buttons for start/stop.
	 * 
	 * @param controlAction
	 *            the implementer of {@link ControlAction} which is to be called
	 *            whenever one of the buttons is pushed.
	 * @param startRunning
	 *            if true then the application will start running immediately.
	 */
	public ControlPanel_PepperedMoth(final ControlAction controlAction, final Boolean startRunning) {
		super(controlAction, startRunning);

		final Collection<Component> list = new ArrayList<Component>();
		list.add(new LabeledComponent(
				Messages.getString("pepperedMoth.2"), new PropertySlider_Normal(controlAction, 3, "", 5, ControlPanel_PepperedMoth.SOOT, ControlPanel_PepperedMoth.$InitSootDensity), BoxLayout.Y_AXIS)); //$NON-NLS-1$ //$NON-NLS-2$
		list.add(new LabeledComponent(
				Messages.getString("pepperedMoth.0"), new PropertySlider_Exponential(controlAction, 3, Messages.getString("pepperedMoth.1"), 6, ControlAction.TIME_DELAY), BoxLayout.Y_AXIS)); //$NON-NLS-1$ //$NON-NLS-2$
		addComponents(list);

		// TODO figure out why the following line does not appear to create a
		// visible slider
		// (instead, for now, we put it in the super-constructor which a
		// hard-coded value for initValSliderSoot).
		// add(new PropertySlider_Normal(controlAction, 3, "", 5,
		// ControlAction.SOOT, initValSliderSoot));

		// my guess is that it's because we were instantiating two separate
		// control
		// panels previously. This might work now.
	}

	private static final long serialVersionUID = 7232522528491834919L;

	/**
	 * This defines the initial soot density (3).
	 */
	public static final int $InitSootDensity = 3;

	/**
	 * sootValue
	 * 
	 */
	public static final String SOOT = EcoFactor_SootDensity.KEY_SOOT_DENSITY;

}
