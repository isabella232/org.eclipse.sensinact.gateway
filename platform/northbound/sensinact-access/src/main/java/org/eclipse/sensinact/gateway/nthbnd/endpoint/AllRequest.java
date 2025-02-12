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
package org.eclipse.sensinact.gateway.nthbnd.endpoint;

import org.eclipse.sensinact.gateway.core.filtering.FilteringCollection;

public class AllRequest extends NorthboundRequest {
    /**
     * @param requestIdentifier
     * @param filteringCollection
     */
    public AllRequest(String requestIdentifier, FilteringCollection filteringCollection) {
        super(requestIdentifier, filteringCollection);
    }

    @Override
    public String getName() {
        return "all";
    }

    @Override
    protected String getMethod() {
        return this.getName();
    }

    @Override
    protected Argument[] getExecutionArguments() {
        Argument[] superArguments = super.getExecutionArguments();
        int length = superArguments == null ? 0 : superArguments.length;
        Argument[] arguments = new Argument[length + 2];
        if (length > 0) {
            System.arraycopy(superArguments, 0, arguments, 0, length);
        }
        arguments[length] = new Argument(String.class, null);
        arguments[length + 1] = new Argument(FilteringCollection.class, super.filteringCollection);
        return arguments;
    }
}
