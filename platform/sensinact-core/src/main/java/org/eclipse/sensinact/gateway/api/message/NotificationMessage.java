/*
 * Copyright (c) 2017 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    CEA - initial API and implementation
 */
package org.eclipse.sensinact.gateway.api.message;

import org.json.JSONObject;

import org.eclipse.sensinact.gateway.common.props.KeysCollection;
import org.eclipse.sensinact.gateway.common.props.TypedKey;
import org.eclipse.sensinact.gateway.core.message.SnaConstants;

/**
 * @param <S>
 * 
 * @author <a href="mailto:cmunilla@cmssi.fr">Christophe Munilla</a>
 */
public interface NotificationMessage<S extends Enum<S> & MessageSubType & KeysCollection> extends SnaMessage<S> {
	
	public static final TypedKey<?>[] PERMANENT_KEYS = new TypedKey[] {
		new TypedKey<JSONObject>(SnaConstants.NOTIFICATION_KEY, JSONObject.class, false) };

	/**
	 * Returns the {@link JSONObject} notification's content
	 * 
	 * @return the {@link JSONObject} notification's content
	 */
	JSONObject getNotification();

	/**
	 * Defines the {@link JSONObject} notification's content
	 * 
	 * @param jsonObject
	 *            the {@link JSONObject} notification's content
	 */
	void setNotification(JSONObject jsonObject);
}