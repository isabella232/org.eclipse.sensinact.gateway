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
package org.eclipse.sensinact.gateway.sthbnd.http.task;

import org.eclipse.sensinact.gateway.common.execution.Executable;
import org.eclipse.sensinact.gateway.core.ResourceConfig;
import org.eclipse.sensinact.gateway.generic.TaskTranslator;
import org.eclipse.sensinact.gateway.protocol.http.client.Request;
import org.eclipse.sensinact.gateway.sthbnd.http.SimpleHttpResponse;

/**
 *
 */
public abstract class HttpChainedTask<REQUEST extends Request<SimpleHttpResponse>> extends HttpTaskImpl<SimpleHttpResponse, REQUEST> implements Executable<Object, Void> {
    
    /**
     * @param command
     * @param transmitter
     * @param requestType
     * @param path
     * @param profileId
     * @param resourceConfig
     * @param parameters
     */
    public HttpChainedTask(CommandType command, TaskTranslator transmitter, Class<REQUEST> requestType, String path, String profileId, ResourceConfig resourceConfig, Object[] parameters) {
        super(command, transmitter, requestType, path, profileId, resourceConfig, parameters);
    }

    
    @Override
    public boolean isDirect() {
        return true;
    }
}
