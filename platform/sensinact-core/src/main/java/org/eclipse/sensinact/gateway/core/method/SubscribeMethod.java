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
package org.eclipse.sensinact.gateway.core.method;

import org.eclipse.sensinact.gateway.common.bundle.Mediator;
import org.json.JSONObject;

/**
 * Subscription {@link AccessMethod}
 * 
 * @author <a href="mailto:christophe.munilla@cea.fr">Christophe Munilla</a>
 */
public class SubscribeMethod extends AbstractAccessMethod<JSONObject, SubscribeResponse> {
	/**
	 * Constructor
	 */
	public SubscribeMethod(Mediator mediator, String uri, AccessMethodExecutor preProcessingExecutor) {
		super(mediator, uri, AccessMethod.SUBSCRIBE, preProcessingExecutor);
	}

	/**
	 * @inheritDoc
	 *
	 * @see org.eclipse.sensinact.gateway.core.method.AbstractAccessMethod#
	 *      createAccessMethodResponseBuilder(java.lang.Object[])
	 */
	@Override
	protected SubscribeResponseBuilder createAccessMethodResponseBuilder(Object[] parameters) {
		return new SubscribeResponseBuilder(uri, parameters);
	}
}
