/*
* Copyright (c) 2020 Kentyou.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
*    Kentyou - initial API and implementation
 */
package org.eclipse.sensinact.gateway.core.security;

import org.eclipse.sensinact.gateway.core.method.AccessMethod;

/**
 * @author <a href="mailto:christophe.munilla@cea.fr">Christophe Munilla</a>
 */
public interface MutableAccessNode extends AccessNode {
	/**
	 * Defines the Map of available {@link AccessMethod.Type} for all pre-defined
	 * {@link AccessLevelOption}s according to the one passed as parameter
	 * 
	 * @param option
	 *            the {@link AccessProfileOption} holding the {@link AccessProfile}
	 *            for which to build the Map of available {@link AccessMethod.Type}
	 *            for pre-defined {@link AccessLevelOption}s
	 */
	void withAccessProfile(AccessProfileOption option);

	/**
	 * Defines the Map of available {@link AccessMethod.Type} for all pre-defined
	 * {@link AccessLevelOption}s according to the {@link AccessProfile} passed as
	 * parameter
	 * 
	 * @param profile
	 *            the {@link AccessProfile} for which to build the Map of available
	 *            {@link AccessMethod.Type} for pre-defined
	 *            {@link AccessLevelOption}s
	 */
	void withAccessProfile(AccessProfile profile);

	/**
	 * @return
	 */
	MutableAccessNode clone();
}
