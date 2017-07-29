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
 * Module: OptionsController_PepperedMoth.java
 * Created on Mar 23, 2009
 * @version $Revision: 1.17 $
 */

package net.sf.darwin.pepperedmoth;

/**
 * @author Robin Hillyard
 * 
 *         TEST class by unit tests (it works for Applet)
 * 
 */
public final class OptionsController_PepperedMoth extends OptionsController_ {

	/**
	 * @param interacter
	 */
	public OptionsController_PepperedMoth(final Interacter interacter) {
		super(interacter);
	}

	/**
	 * @see net.sf.darwin.visualization.ControlAction#setProperty(String,
	 *      Object)
	 */
	@Override
	public void setProperty(final String name, final Object value) throws VisualizationException {
		// // TODO some (all?) of this is now unnecessary
		// try {
		// if (name.equals(MATE_CHOICE_FORMULA_0))
		// ((MateChoice_Evaluator)
		// BeanContainer.getBean(Beans.BEAN_MATE_CHOICE)).setExpression(0,
		// (String) value);
		// if (name.equals(MATE_CHOICE_FORMULA_1))
		// ((MateChoice_Evaluator)
		// BeanContainer.getBean(Beans.BEAN_MATE_CHOICE)).setExpression(1,
		// (String) value);
		LOG.warn("setProperty ignored: " + name + " = " + value); //$NON-NLS-1$ //$NON-NLS-2$
		// } catch (final FunctionException e) {
		// throw new VisualizationException(
		//					"OptionsController.setProperty(" + name + ")=" + value + " exception", e); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
		// }
	}

	/**
	 * @see net.sf.darwin.visualization.ControlAction#setState(String)
	 */
	@Override
	public void setState(final String state) throws VisualizationException {
		if (state.endsWith(Applet_PepperedMoth.LBL_SHOW_IDENTIFIERS)) {
			final String NOT = "!"; //$NON-NLS-1$
			getInteracter().getPainter().setIdentify(!state.startsWith(NOT));
		}
		LOG.info("setState: " + state); //$NON-NLS-1$
	}

	@SuppressWarnings("unused")
	private static final String MATE_CHOICE_FORMULA_1 = Messages.getString("Applet_PepperedMoth.10"); //$NON-NLS-1$

	@SuppressWarnings("unused")
	private static final String MATE_CHOICE_FORMULA_0 = Messages.getString("Applet_PepperedMoth.9"); //$NON-NLS-1$
}