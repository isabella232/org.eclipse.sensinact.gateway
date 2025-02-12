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
package org.eclipse.sensinact.gateway.app.manager.json;

import org.eclipse.sensinact.gateway.common.bundle.Mediator;
import org.eclipse.sensinact.gateway.core.message.AbstractSnaMessage;
import org.eclipse.sensinact.gateway.core.message.SnaErrorMessageImpl;

/**
 * @author Remi Druilhe
 * @see AbstractSnaMessage
 */
public class AppSnaMessage extends SnaErrorMessageImpl {
    /**
     * Constructor of the AppSnaMessage
     *
     * @param uri     the URI of the service
     * @param type    the type of the message
     * @param message the string message
     * @see SnaErrorMessageImpl#SnaErrorMessageImpl(Mediator, String, Error, int)
     */
    public AppSnaMessage(String uri, Error type, String message) {
        super(uri, type);
        super.putValue("message", message);
    }
}
