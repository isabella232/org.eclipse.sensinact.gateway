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

public class AttributeSetRequest extends AttributeRequest {

    private Argument[] extraArguments;
    private Object argument;

    /**
     * @param serviceProvider
     * @param service
     * @param resource
     * @param attribute
     * @param argument
     */
    public AttributeSetRequest(String requestIdentifier, String serviceProvider, String service, String resource, 
    		String attribute, Object argument, Argument[] extraArguments) {
        super(requestIdentifier, serviceProvider, service, resource, attribute);
        this.argument = argument;
        this.extraArguments = extraArguments;
    }

    /**
     * @inheritDoc
     * @see ServiceProvidersRequest#getExecutionArguments()
     */
    @Override
    protected Argument[] getExecutionArguments() {
    	int offset = this.extraArguments == null?0:this.extraArguments.length;
        Argument[] superArguments = super.getExecutionArguments();
        int length = superArguments == null ? 0 : superArguments.length;
        Argument[] arguments = new Argument[length + offset + 1];
        if (length > 0) 
            System.arraycopy(superArguments, 0, arguments, 0, length);
        arguments[length] = new Argument(Object.class, this.argument);
        if (offset > 0)
            System.arraycopy(this.extraArguments, 0, arguments, length+1, offset);
        return arguments;
    }

    /**
     * @inheritDoc
     * @see ResourceRequest#getMethod()
     */
    @Override
    protected String getMethod() {
        return "set";
    }
}
