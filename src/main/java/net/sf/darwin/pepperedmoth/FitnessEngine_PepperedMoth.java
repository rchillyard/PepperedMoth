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
 * Module: FitnessEngine_PepperedMoth.java
 * Created on Apr 1, 2009
 * @version $Revision: 1.11 $
 */

package net.sf.darwin.pepperedmoth;

/**
 * Fitness engine for the peppered moth.
 * 
 * @author Robin Hillyard
 * 
 */
final public class FitnessEngine_PepperedMoth extends FitnessEngine_ {

	/**
	 * Public secondary constructor. Invoke #{@link FitnessEngine_} constructor.
	 */
	public FitnessEngine_PepperedMoth() {
		this((Realm) null);
	}

	/**
	 * Public primary constructor. Invoke super-constructor.
	 * 
	 * @param evaluator
	 */
	public FitnessEngine_PepperedMoth(final Evaluator evaluator) {
		this(evaluator, null);
	}

	/**
	 * Public primary constructor. Invoke super-constructor.
	 * 
	 * @param evaluator
	 * @param realm
	 *            XXX
	 */
	public FitnessEngine_PepperedMoth(final Evaluator evaluator, final Realm realm) {
		super(evaluator, realm);
	}

	/**
	 * Public primary constructor. Invoke super-constructor.
	 * 
	 * @param realm
	 *            XXX
	 */
	public FitnessEngine_PepperedMoth(final Realm realm) {
		this(null, realm);
	}

	/**
	 * @param evaluator
	 *            the evaluator (or null) for the fitness function
	 */
	@Override
	protected void registerFitnesses(final Evaluator evaluator) {
		putFitness("WingColor/SootDensity", new WcSdFitness(evaluator, this)); //$NON-NLS-1$
		final Realm realm = getRealm();
		if (realm != null)
			realm.getFitnessCache().register(this);
	}

}
