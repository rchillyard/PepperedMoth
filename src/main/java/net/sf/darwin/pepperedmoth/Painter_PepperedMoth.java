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
 * Module: Painter_PepperedMoth.java
 * Created on Feb 9, 2007
 * @version $Revision: 1.15 $
 */

package net.sf.darwin.pepperedmoth;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * TODO fix the architectural issues.
 * 
 * Implementation of Painter for the PepperedMoth example. In this
 * implementation, there is only ever one visualization model. The method
 * paintPopulation() resets the given graphics context to the background, then
 * draws a given title (in red); and paintIndividual draws a circle (diameter
 * 20) of the appropriate color at the appropriate location.
 * 
 * @author Robin Hillyard
 */
public class Painter_PepperedMoth extends Painter_ {

	/**
	 * @param title
	 */
	public Painter_PepperedMoth(final String title) {
		super();
		this._title = title;
	}

	/**
	 * @see net.sf.darwin.visualization.Painter_#paintBase(Graphics,
	 *      int, int)
	 */
	@Override
	public void paintBase(final Graphics g, final int width, final int height) {
		super.paintBase(g, width, height);
		// g.setColor(Color.red);
		// g.drawString(getTitle(),0,15);
		// XXX this is where we should figure out how to paint the various
		// visualization models (cascade, tiled, etc.)
	}

	/**
	 * @see net.sf.darwin.visualization.Painter#paintIndividual(Graphics,
	 *      net.sf.darwin.visualization.Avatar)
	 */
	@Override
	public void paintIndividual(final Graphics g, final Avatar avatar) {
		// TODO should draw a moth shape, rather than a pure circle.
		final Point location = avatar.getLocation();
		g.setColor(avatar.getColor());
		final int size = (int) Math.round(avatar.getSize() * ICON_SIZE);
		final int iconWidth = size;
		final int iconHeight = size;
		final int curX = location.x - iconWidth / 2;
		final int curY = location.y - iconHeight / 2;
		g.fillOval(curX, curY, iconWidth, iconHeight);
		g.setColor(Color.black);
		g.drawOval(curX, curY, iconWidth, iconHeight);
		if (isIdentify())
			paintIdentification(g, avatar, location);
	}

	/**
	 * @return the title
	 * 
	 *         XXX this is never used.
	 */
	protected String getTitle() {
		return this._title;
	}

	private static final int ICON_SIZE = 20;

	private final String _title;

}
