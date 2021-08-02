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

package org.eclipse.sensinact.gateway.core.security.test;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.sensinact.gateway.common.primitive.Describable;
import org.eclipse.sensinact.gateway.core.Core;
import org.eclipse.sensinact.gateway.core.ServiceProvider;
import org.eclipse.sensinact.gateway.core.Session;
import org.eclipse.sensinact.gateway.core.security.Authentication;
import org.eclipse.sensinact.gateway.core.security.Credentials;
import org.eclipse.sensinact.gateway.test.MidOSGiTest;
import org.eclipse.sensinact.gateway.test.MidProxy;
import org.junit.Test;

/**
 *
 * @author <a href="mailto:christophe.munilla@cea.fr">Christophe Munilla</a>
 */
public class TestSecurity extends MidOSGiTest {
	// ********************************************************************//
	// NESTED DECLARATIONS //
	// ********************************************************************//

	// ********************************************************************//
	// ABSTRACT DECLARATIONS //
	// ********************************************************************//

	// ********************************************************************//
	// STATIC DECLARATIONS //
	// ********************************************************************//

	// ********************************************************************//
	// INSTANCE DECLARATIONS //
	// ********************************************************************//

	Method getDescription = null;

	public TestSecurity() throws Exception {
		super();
		getDescription = Describable.class.getDeclaredMethod("getDescription");
	}

	public boolean isExcluded(String fileName) {
		if ("org.apache.felix.framework.security.jar".equals(fileName)) 
			return true;		
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doInit(Map configuration) {
		
		configuration.put("org.osgi.framework.system.capabilities",
				"osgi.ee;osgi.ee:List=\"JavaSE,JavaSE/compact1\";version:List=\"1.0,1.0.0,1.1,1.1.0,1.2,1.2.0,1.3,1.3.0,1.4, 1.4.0,1.5,1.5.0,1.6,1.6.0,1.7,1.7.0,1.8,1.8.0\"");

		configuration.put("org.osgi.framework.system.packages.extra",
		"org.eclipse.sensinact.gateway.test," + 
		"com.sun.net.httpserver," + 
		"javax.mail," + 
		"javax.mail.internet," + 
		"javax.microedition.io," +
		"javax.management.modelmbean," + 
		"javax.management.remote,"	+
		"javax.persistence," +
		"junit.framework," + 
		"junit.textui," + 
		"org.w3c.dom," + 
		"org.xml.sax," + 
		"org.xml.sax.helpers," + 
		"sun.misc,"+ 
		"sun.security.action");

		configuration.put("org.eclipse.sensinact.simulated.gui.enabled", "false");

		configuration.put("org.eclipse.sensinact.gateway.security.jks.filename", "target/felix/bundle/keystore.jks");
		configuration.put("org.eclipse.sensinact.gateway.security.jks.password", "sensiNact_team");

		configuration.put("org.eclipse.sensinact.gateway.security.database", 
				new File("src/test/resources/sensinact.sqlite").getAbsolutePath());
		
		configuration.put("felix.log.level","4");
		
    	configuration.put("felix.auto.start.1",  
           "file:target/felix/bundle/org.osgi.service.component.jar "+ 
           "file:target/felix/bundle/org.osgi.service.cm.jar "+  
           "file:target/felix/bundle/org.osgi.service.metatype.jar "+  
           "file:target/felix/bundle/org.osgi.namespace.extender.jar "+  
           "file:target/felix/bundle/org.osgi.util.promise.jar "+  
           "file:target/felix/bundle/org.osgi.util.function.jar "+  
           "file:target/felix/bundle/org.osgi.util.pushstream.jar "+
           "file:target/felix/bundle/org.osgi.service.log.jar "  +
           "file:target/felix/bundle/org.apache.felix.log.jar " + 
           "file:target/felix/bundle/org.apache.felix.scr.jar " +
           "file:target/felix/bundle/org.apache.felix.fileinstall.jar " +
           "file:target/felix/bundle/org.apache.felix.configadmin.jar " + 
           "file:target/felix/bundle/org.apache.felix.framework.security.jar ");
    	
        configuration.put("felix.auto.install.2",  
        	"file:target/felix/bundle/slf4j-api.jar "+
			"file:target/felix/bundle/sensinact-utils.jar "+ 
			"file:target/felix/bundle/sensinact-datastore-api.jar "+
			"file:target/felix/bundle/sensinact-sqlite-connector.jar "+
			"file:target/felix/bundle/sensinact-common.jar "+
			"file:target/felix/bundle/sensinact-framework-extension.jar "+
			"file:target/felix/bundle/dynamicBundle.jar");

		configuration.put("felix.auto.start.2", 
	        "file:target/felix/bundle/slf4j-simple.jar "+
			"file:target/felix/bundle/sensinact-test-configuration.jar "+
			"file:target/felix/bundle/sensinact-signature-validator.jar " +
			"file:target/felix/bundle/org.apache.felix.http.servlet-api.jar " +
			"file:target/felix/bundle/org.apache.felix.http.api.jar " +
			"file:target/felix/bundle/org.apache.felix.http.jetty.jar " +
			"file:target/felix/bundle/org.apache.aries.javax.jax.rs-api.jar");

		configuration.put("felix.auto.start.3",
			"file:target/felix/bundle/sensinact-core.jar " + 
		    "file:target/felix/bundle/sensinact-generic.jar ");

		configuration.put("felix.auto.start.4", 
			"file:target/felix/bundle/slider.jar " + 
		    "file:target/felix/bundle/fan.jar " + 
			"file:target/felix/bundle/button.jar ");
	}

	@Test
	public void testSecurityAccessInitialization() throws Throwable {
		MidProxy<Core> mid = new MidProxy<Core>(classloader, this, Core.class);

		Core core = mid.buildProxy();
		Session session = core.getAnonymousSession();
		assertNotNull(session);

		Set providers = session.serviceProviders();
		Iterator iterator = providers.iterator();

		while (iterator.hasNext()) {
			MidProxy<ServiceProvider> provider = new MidProxy<ServiceProvider>(classloader, this,
					ServiceProvider.class);

			ServiceProvider serviceProvider = provider.buildProxy(iterator.next());

			System.out.println(serviceProvider.getDescription().getJSON());
		}
		System.out.println("============================================");

		MidProxy<Authentication> midCredentials = new MidProxy<Authentication>(classloader, this, Authentication.class);

		midCredentials.buildProxy(Credentials.class.getCanonicalName(), new Class<?>[] { String.class, String.class },
				new Object[] { "cea", "sensiNact_team" });

		Method method = mid.getContextualizedType().getDeclaredMethod("getSession",
				new Class<?>[] { midCredentials.getContextualizedType() });

		session = (Session) mid.toOSGi(method, new Object[] { midCredentials.getInstance() });

		assertNotNull(session);

		providers = session.serviceProviders();
		iterator = providers.iterator();

		while (iterator.hasNext()) {
			MidProxy<ServiceProvider> provider = new MidProxy<ServiceProvider>(classloader, this,
					ServiceProvider.class);

			ServiceProvider serviceProvider = provider.buildProxy(iterator.next());

			System.out.println(serviceProvider.getDescription().getJSON());
		}

	}

}
