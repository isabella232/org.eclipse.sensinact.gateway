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
package org.eclipse.sensinact.gateway.commands.gogo.internal;

import org.apache.felix.service.command.Descriptor;
import org.apache.felix.service.command.annotations.GogoCommand;
import org.eclipse.sensinact.gateway.commands.gogo.internal.shell.ShellAccess;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = ServiceCommands.class)
@GogoCommand(
		scope = "sna", 
		function = {"service", "services"}
	)
public class ServiceCommands {
   
	@Reference
	private CommandComponent component;

    /**
     * Display the existing sensiNact service instances
     *
     * @param serviceProviderID the ID of the service provider
     */
    @Descriptor("display the existing sensiNact service instances")
    public void services(@Descriptor("the service provider ID") String serviceProviderID) {
        ShellAccess.proceed(component.getCommandMediator(), new JSONObject().put("uri", CommandServiceMediator.uri(serviceProviderID, null, null, true)));
    }

    /**
     * Display the description of a specific sensiNact service instance
     *
     * @param serviceProviderID the ID of the service provider
     * @param serviceID         the ID of the service
     */
    @Descriptor("display the description of a specific sensiNact service instance")
    public void service(@Descriptor("the service provider ID") String serviceProviderID, @Descriptor("the service ID") String serviceID) {
        ShellAccess.proceed(component.getCommandMediator(), new JSONObject().put("uri", CommandServiceMediator.uri(serviceProviderID, serviceID, null, false)));
    }
}
