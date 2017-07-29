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
 * Created on Oct 7, 2003
 *
 */

package net.sf.darwin.pepperedmoth;

/**
 * TODO eliminate this class.
 * 
 * <p>
 * This class defines an evolutionary process for a Darwinian System, namely the
 * evolution of the peppered moth. This example does not pretend to be the last
 * word (or even the first) on actual peppered moths. It is just a (toy) sample
 * application whose <i>raison d'etre</i> is documentation and exemplification.
 * Serious applications would be found in the Evolutions subdirectory (parallel
 * to the Darwin subdirectory).
 * </p>
 * <p>
 * The details of the simulation are as follows:
 * <ul>
 * <li>The system is diploid;
 * <li>There is one locus and one trait, and they share the same name:
 * WingColor;
 * <li>A set of values serves for both the trait and the alleles: see
 * {@link #$Colors}.
 * <li>Dominance in the expression of alleles as traits is the extremely
 * arbitrary dictionary order of their names (the allele for BattleshipGrey
 * tends to dominate therefore).
 * <li>There is one environmental factor (other than saturation population):
 * soot density.
 * <li>When evaluating fitness, darker-winged moths fare better in a sootier
 * environment.
 * <li>The system has two populations, a control population where soot density
 * is the mean value and an experimental population where soot density varies
 * according to the run-time arguments.
 * <li>For the ordering/defaults of run-time arguments, see
 * {@link PepperedMoth#main(String[])}
 * </ul>
 * </p>
 * 
 * Note that all the fields and methods of this class are static.
 * 
 * @author Robin Hillyard
 * @version $Revision: 1.31 $
 */
public final class ApplicationDefinitions extends ApplicationDefinitions_ {

	/**
	 * TODO replace this usage by reference to the WingColor enum.
	 * 
	 * An array of four colors: white, typica (light grey), carbonaria (dark
	 * grey), black
	 */
	public static final String[] $Colors = new String[] {
			Messages.getString("PepperedMoth.3"), Messages.getString("PepperedMoth.4"), Messages.getString("PepperedMoth.5"), Messages.getString("PepperedMoth.6") }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

}
