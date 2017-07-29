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
 * Module: MockApplet.java
 * Created on Feb 9, 2007
 * @version $Revision: 1.61 $
 */

package net.sf.darwin.pepperedmoth;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

/**
 * The class which implements the PepperedMoth example applet.
 * 
 * The minimum workable size for width for this applet is 625. The height should
 * be around 400.
 * 
 * @author Robin Hillyard
 */
public class Applet_PepperedMoth extends VisualizingEvolutionaryApplet {

	/**
	 * Public primary constructor.
	 */
	public Applet_PepperedMoth() {
		// FIXME figure out where bean container is coming from
		super(null);
	}

	// /**
	// * @see
	// net.sf.com.phasmid.darwin.visualization.swing.EvolutionaryApplet#createControlPanel(net.sf.com.phasmid.darwin.visualization.ControlAction)
	// */
	// @Override
	// protected JPanel createControlPanel(final ControlAction controlAction) {
	// final ControlPanel_ result = (ControlPanel_)
	// BeanContainer.getBean(Beans.BEAN_CONTROL_PANEL);
	// if (result != null) {
	// result
	// .enableComponent(
	//							Messages.getString("pepperedMoth.0"), getBooleanParameter(APPLET_PARAM_ENABLE_SLIDER, settable(TIME_DELAY))); //$NON-NLS-1$
	// } else
	//			LOG.warn("createControlPanel(): unable to find bean " + Beans.BEAN_CONTROL_PANEL); //$NON-NLS-1$
	// return result;
	// }

	@Override
	protected Map<String, Component> createOptionsComponentMap() {
		final Map<String, Component> map = new HashMap<String, Component>();
		map.put(LBL_VERSION, new JLabel(Version.DARWIN_VERSION));
		map.put(LBL_SHOW_IDENTIFIERS, new JCheckBox());
		return map;
	}

	/**
	 * Show Identifiers
	 */
	public static final String LBL_SHOW_IDENTIFIERS = "Show Identifiers"; //$NON-NLS-1$

	private static final long serialVersionUID = -4923938664135452853L;

}
