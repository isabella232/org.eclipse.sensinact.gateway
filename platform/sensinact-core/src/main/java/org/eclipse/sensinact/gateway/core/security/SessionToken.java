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

import org.eclipse.sensinact.gateway.core.Session;

/**
 * {@link Authentication} implementation holding an existing sensiNact's {@link Session} authentication material
 * 
 * @author <a href="mailto:christophe.munilla@cea.fr">Christophe Munilla</a>
 */
public class SessionToken implements Authentication<String> {
	private String sessionToken;

	/**
	 * Constructor
	 * 
	 * @param sessionToken the String {@link Session}'s authentication material held
	 * by the SessionToken to be instantiated
	 */
	public SessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	@Override
	public String getAuthenticationMaterial() {
		return this.sessionToken;
	}
}