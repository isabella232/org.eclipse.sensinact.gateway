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
package org.eclipse.sensinact.gateway.sthbnd.mqtt.smarttopic.exception;

public class MessageInvalidSmartTopicException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MessageInvalidSmartTopicException() {
        super();
    }

    public MessageInvalidSmartTopicException(String message) {
        super(message);
    }

    public MessageInvalidSmartTopicException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageInvalidSmartTopicException(Throwable cause) {
        super(cause);
    }

    protected MessageInvalidSmartTopicException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
