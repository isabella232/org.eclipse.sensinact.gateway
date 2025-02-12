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
package org.eclipse.sensinact.gateway.device.mqtt.lite.it.util;

/**
 * Abstract class used to configure the base for the integration tests
 */
public abstract class MqttTestITAbstract {
//    protected static final String SENSINACT_HTTP_PORT="8097";
//    protected static final String SENSINACT_VERSION="2.0-SNAPSHOT";
//    protected static final String MQTT_HOST ="127.0.0.1";//sensinact-cea.ddns.net
//    protected static final Integer MQTT_PORT =1883;//5269
//    protected static Option[] combine(Option[]...options){
//        List<Option> optionsnew=new ArrayList<Option>();
//        for(Option[] optionsit:options){
//            optionsnew.addAll(Arrays.asList(OptionUtils.combine(optionsit)));
//        }
//        Option optionResult[]=new Option[optionsnew.size()];
//        return optionsnew.toArray(optionResult);
//    }
//    protected Option[] depProfile1(){
//        return options(
//                systemProperty("org.ops4j.pax.url.mvn.repositories").value("https://repo1.maven.org/maven2/@snapshots@id=ops4j-snapshotkok"),
//                mavenBundle("org.apache.felix", "org.apache.felix.framework.security", "2.6.1"),
//                mavenBundle("org.slf4j", "slf4j-api", "1.7.30").noStart(),
//                mavenBundle("org.slf4j", "slf4j-simple", "1.7.30").noStart(),
//                mavenBundle("org.osgi", "org.osgi.util.pushstream", "1.0.1"),
//                mavenBundle("org.osgi", "org.osgi.service.log", "1.4.0"),
//                mavenBundle("org.apache.felix", "org.apache.felix.gogo.command", "1.1.0"),
//                mavenBundle("org.apache.felix", "org.apache.felix.gogo.runtime", "1.1.2"),
//                mavenBundle("org.fusesource.jansi", "jansi", "1.18")
//        );
//    }
//    protected Option[] depProfile2(){
//        return options(
//                mavenBundle("org.apache.felix", "org.apache.felix.fileinstall", "3.6.4"),
//                mavenBundle("org.apache.felix", "org.apache.felix.scr", "2.1.16"),
//                mavenBundle("org.apache.felix", "org.apache.felix.configadmin", "1.9.16"),
//                mavenBundle("org.osgi", "org.osgi.service.component", "1.4.0"),
//                mavenBundle("org.osgi", "org.osgi.service.cm", "1.6.0"),
//                mavenBundle("org.osgi", "org.osgi.service.metatype", "1.4.0"),
//                mavenBundle("org.osgi", "org.osgi.namespace.extender", "1.0.1"),
//                mavenBundle("org.osgi", "org.osgi.util.function", "1.1.0"),
//                mavenBundle("org.osgi", "org.osgi.util.promise", "1.1.1"),
//                mavenBundle("org.eclipse.sensinact.gateway.sthbnd.mqtt", "mqtt-utils", SENSINACT_VERSION),
//                mavenBundle("org.eclipse.paho", "org.eclipse.paho.client.mqttv3", "1.2.2")
//        );
//    }
//    protected Option[] depProfile3(){
//        return options(
//                mavenBundle("org.eclipse.sensinact.gateway", "sensinact-utils", SENSINACT_VERSION).noStart(),
//                mavenBundle("org.eclipse.sensinact.gateway", "sensinact-common", SENSINACT_VERSION).noStart(),
//                mavenBundle("org.eclipse.sensinact.gateway", "sensinact-datastore-api", SENSINACT_VERSION).noStart(),
//                mavenBundle("org.eclipse.sensinact.gateway", "sensinact-signature-validator", SENSINACT_VERSION).noStart(),
//                mavenBundle("org.eclipse.sensinact.gateway", "sensinact-security-none", SENSINACT_VERSION).noStart(),
//                mavenBundle("org.eclipse.sensinact.gateway", "sensinact-core", SENSINACT_VERSION).start(true),
//                mavenBundle("org.eclipse.sensinact.gateway", "sensinact-generic", SENSINACT_VERSION).noStart(),
//                mavenBundle("org.eclipse.sensinact.gateway", "sensinact-system", SENSINACT_VERSION).start(true),
//                mavenBundle("org.eclipse.sensinact.gateway.nthbnd", "sensinact-northbound-access", SENSINACT_VERSION).noStart()
//        );
//    }
//    protected Option[] depProfile4(){
//        return options(
//                wrappedBundle(mavenJar("org.apache.maven", "maven-aether-provider", "3.3.9")),
//                wrappedBundle(mavenJar("org.eclipse.aether", "aether-connector-basic", "1.1.0")),
//                wrappedBundle(mavenJar("org.eclipse.aether", "aether-spi", "1.1.0")),
//                wrappedBundle(mavenJar("org.eclipse.aether", "aether-transport-file", "1.1.0")),
//                wrappedBundle(mavenJar("org.eclipse.aether", "aether-util", "1.1.0")),
//                wrappedBundle(mavenJar("org.eclipse.aether", "aether-impl", "1.1.0")),
//                wrappedBundle(mavenJar("org.eclipse.aether", "aether-api", "1.1.0"))
//        );
//    }
//    /**
//     * This method bypass the need of having the dependency declared in the pom.xml, allowing the test to declare dependencies not associated
//     * @param groupId
//     * @param artifactId
//     * @param version
//     * @return
//     */
//    private MavenArtifactProvisionOption fetch(String groupId, String artifactId, String version){
//        DefaultServiceLocator locator = MavenRepositorySystemUtils.newServiceLocator();
//        locator.setService(RepositoryConnectorFactory.class, BasicRepositoryConnectorFactory.class);
//        locator.setService(TransporterFactory.class, FileTransporterFactory.class);
//        locator.setService(TransporterFactory.class, HttpTransporterFactory.class);
//        locator.setService(org.eclipse.aether.spi.log.LoggerFactory.class, Slf4jLoggerFactory.class);
//        RepositorySystem system = locator.getService(RepositorySystem.class);
//        RepositorySystemSession session = MavenRepositorySystemUtils.newSession();
//        ((DefaultRepositorySystemSession)session).setLocalRepositoryManager(system.newLocalRepositoryManager(session, new LocalRepository(System.getProperty("user.home")+"/.m2/repository/")));
//        ArtifactRequest req = new ArtifactRequest();
//        req.addRepository(new RemoteRepository.Builder("central", "default", "https://repo1.maven.org/maven2").build());
//        req.setArtifact(new DefaultArtifact(groupId, artifactId, "jar", version));
//        try {
//            ArtifactResult res = system.resolveArtifact(session, req);
//        } catch (ArtifactResolutionException e) {
//            e.printStackTrace();
//        }
//        return mavenBundle(groupId, artifactId, version);
//    }
//    protected Option[] depProfileMqtt(){
//        return options(
//                mavenBundle("org.eclipse.sensinact.gateway.tools", "mqtt-server", SENSINACT_VERSION),
//                mavenBundle("org.eclipse.sensinact.gateway.sthbnd.mqtt", "mqtt-device", SENSINACT_VERSION),
//                mavenBundle("org.eclipse.sensinact.gateway.sthbnd.mqtt", "smart-topic-device", SENSINACT_VERSION)
//        );
//    }
//    protected Option[] depProfileHttp(){
//        return options(
//                mavenBundle("org.eclipse.sensinact.gateway.protocol", "http",SENSINACT_VERSION),
//                mavenBundle("org.eclipse.sensinact.gateway.sthbnd.http", "http-device", SENSINACT_VERSION),
//                mavenBundle("org.eclipse.sensinact.gateway.nthbnd", "http-tools", SENSINACT_VERSION),
//                mavenBundle("org.apache.felix","org.apache.felix.http.servlet-api","1.1.2").noStart(),
//                mavenBundle("org.apache.felix", "org.apache.felix.http.api", "3.0.0"),
//                mavenBundle("org.apache.felix", "org.apache.felix.http.jetty", "4.0.14")
//        );
//    }
//    protected Option[] depProfileREST(){
//        return options(
//                mavenBundle("org.eclipse.sensinact.gateway.nthbnd", "rest-access", SENSINACT_VERSION)
//        );
//    }
//    protected Option[] getBundleRequiredByURLResolvers(){
//        return options(OptionUtils.expand(
//                mavenBundle("org.ops4j.pax.url", "pax-url-mvn").versionAsInProject(),
//                mavenBundle("org.ops4j.pax.url", "pax-url-wrap").versionAsInProject(),
//                mavenBundle("org.ops4j.pax.url", "pax-url-commons").versionAsInProject(),
//                mavenBundle("org.ops4j.pax.swissbox", "pax-swissbox-bnd").versionAsInProject(),
//                mavenBundle("org.ops4j.pax.swissbox", "pax-swissbox-property").versionAsInProject(),
//                mavenBundle("org.ops4j.pax.swissbox", "pax-swissbox-extender").versionAsInProject(),
//                mavenBundle("biz.aQute.bnd", "bndlib").versionAsInProject()
//        ));
//    }
//
//    protected Option[] getProperties(){
//        return options(
//                new FrameworkPropertyOption("org.osgi.framework.system.packages.extra").value("com.google.common.base,javax.net.ssl,javax.smartcardio,sun.security.action,com.sun.net.httpserver,javax.mail,javax.mail.internet,javax.cache.spi,javax.cache,javax.cache.integration,javax.cache.empiry,javax.cache.expiry,javax.cache.configuration,javax.cache.processor,javax.cache.management,javax.cache.event,sun.misc")
//                ,new FrameworkPropertyOption("felix.shutdown.hook").value("false")
//                ,new SystemPropertyOption("org.slf4j.simpleLogger.defaultLogLevel").value("error")
//                ,new FrameworkPropertyOption("org.slf4j.simpleLogger.defaultLogLevel").value("error")
//                ,new FrameworkPropertyOption("org.osgi.service.http.port").value(SENSINACT_HTTP_PORT)
//                ,new FrameworkPropertyOption("org.apache.felix.http.jettyEnabled").value("true")
//                ,new FrameworkPropertyOption("org.apache.felix.http.whiteboardEnabled").value("true")
//                ,new FrameworkPropertyOption("felix.log.level").value("3")
//                ,new FrameworkPropertyOption("sensinact.log.mode").value("debug")
//                ,new FrameworkPropertyOption("sensinact.log.service.filter.property.key").value("description")
//                ,new FrameworkPropertyOption("sensinact.log.service.filter.property.value").value("An SLF4J LogService implementation.")
//                ,new FrameworkPropertyOption("felix.fileinstall.log.level").value("3")
//                ,new FrameworkPropertyOption("felix.fileinstall.dir").value(new File("target/conf").getAbsolutePath())
//                ,new FrameworkPropertyOption("felix.fileinstall.noInitialDelay").value("true")
//                ,new FrameworkPropertyOption("felix.fileinstall.poll").value("1000")
//                ,new FrameworkPropertyOption("felix.fileinstall.bundles.new.start").value("false")
//        );
//    }
//    
//    @Configuration
//    public Option[] config(){	
//        	return combine( 
//                OptionUtils.expand(when(Boolean.getBoolean( "isDebug" )).useOptions(
//                        vmOption( "-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005" ),
//                        systemTimeout( 10000 ))),
//                OptionUtils.expand(getProperties()),
//                OptionUtils.expand(junitBundles()),
//                depProfile1(),
//                depProfile2(),
//                depProfile3(),
//                depProfile4(),
//                depProfileHttp(),
//                depProfileREST(),
//                depProfileMqtt(),
//                getBundleRequiredByURLResolvers());
//    }
//    
//    protected void createConfigurationFile(String providerString, String topic) throws Exception {
//        File f = new File("target/conf/smarttopic-test.cfg");
//        if(f.exists()) {
//        	f.delete();
//        }
//    	FileWriter fw = new FileWriter(f);
//    	fw.write("id="+providerString+"\n");
//    	fw.write("topic="+topic+"\n");
//    	fw.flush();
//    	fw.close();
//    	Thread.sleep(5000);
//    }
//
//    protected void deleteConfigurationFile() throws Exception {
//        File f = new File("target/conf/smarttopic-test.cfg");
//        if(f.exists()) {
//        	f.delete();
//        }
//    	Thread.sleep(2000);
//    }
//    
//    public MqttClient getMqttConnection(String host, int port) throws Exception {
//        MqttBroker broker = new MqttBroker.Builder()
//                .host(host)
//                .port(port)
//                .protocol(MqttBroker.Protocol.TCP)
//                .build();
//        broker.connect();
//        return broker.getClient();
//    }
//    protected JSONObject invokeRestAPI(String URL) throws Exception {
//        Thread.yield();
//        HTTP http = new HTTP();
//        String result = http.submit(String.format("http://localhost:%s/%s", SENSINACT_HTTP_PORT, URL));
//        JSONObject jo = new JSONObject(result);
//        System.out.println(String.format("HTTPResponse body: %s",result));
//        return jo;
//    }
//    protected Set<String> parseJSONArrayIntoSet(JSONArray joArray){
//        final Set<String> resultSet = new HashSet<String>();
//        for(Iterator it=joArray.iterator();it.hasNext();) {
//            resultSet.add((String)it.next());
//        }
//        return resultSet;
//    }
}