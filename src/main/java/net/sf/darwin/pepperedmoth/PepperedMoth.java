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
 * Module: PepperedMoth.java
 * Created on Feb 24, 2009
 * @version $Revision: 1.17 $
 */

package net.sf.darwin.pepperedmoth;

/**
 * This is a non-graphical, non-interactive implementation of the Peppered Moth
 * evolution.
 * 
 * TODO: this does not work as well as it should because the carbonaria alleles
 * are dying out in the few generations that are run.
 * 
 * @author Robin Hillyard
 * 
 */
public class PepperedMoth implements Plugin {

	// /**
	// * @param args
	// */
	// public static void main(final String[] args) {
	// final BeanContainer beanContainer = new BeanContainer_BeanPot();
	// try {
	// final boolean debug = false;
	//			beanContainer.setConfigurationByResource(PepperedMoth.class, "beansApplication.xml"); //$NON-NLS-1$
	// beanContainer.setDebug(true);
	// beanContainer.configure();
	//
	// if (debug)
	// beanContainer.showBeans();
	//
	// final PrintWriter writer = beanContainer.getWriter();
	//			final Evolution evolution = (Evolution) beanContainer.getBean("Evolution"); //$NON-NLS-1$
	// evolution.addListener(new GenerationListener() {
	// @Override
	// public void onGeneration(final Evolvable evolvable) {
	// if (evolvable != null)
	//						writer.println("evolvable " + evolvable.getIdentifier() + ": generation=" //$NON-NLS-1$ //$NON-NLS-2$
	// + evolvable.getGeneration());
	// else
	//						writer.println("PepperedMoth evolution is finished"); //$NON-NLS-1$
	// }
	// });
	// evolution.init();
	//
	// // schedule an environment change at 5 ticks
	//			final Environment env = (Environment) beanContainer.getBean("EnvironmentExp"); //$NON-NLS-1$
	// final Future<?> future = evolution
	//					.scheduleEvent(5, new EnvironmentChangeEvent(env, "SootDensity", Double.valueOf(7))); //$NON-NLS-1$
	//
	// // XXX consider replacing with BeanContainer.runBeans()
	// evolution.run();
	// final boolean complete = evolution.waitUntilComplete(250);
	//			writer.println("Peppered Moth is " + (complete ? "" : "not ") + "complete"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	// if (complete) {
	// final Object object = future.get();
	//				writer.println("result of scheduled task: " + object); //$NON-NLS-1$
	// }
	// evolution.shutdown();
	// } catch (final InterruptedException e) {
	// e.printStackTrace();
	// } catch (final ExecutionException e) {
	// e.printStackTrace();
	// } catch (final EvolutionException e) {
	// e.printStackTrace();
	// } catch (final BeanContainerException e) {
	// e.printStackTrace();
	// } finally {
	// beanContainer.cleanup();
	// }
	//
	// }
}
