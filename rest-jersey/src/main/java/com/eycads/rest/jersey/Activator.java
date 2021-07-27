package com.eycads.rest.jersey;

import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.net.URI;

public class Activator implements BundleActivator {

  public static final String BASE_URI = "http://localhost:8080/";

  public static Server startServer() {
    final ResourceConfig config = new ResourceConfig();
    config.register(MyResource.class);

    System.out.println("Starting Server........");

    final Server httpServer =
        JettyHttpContainerFactory.createServer(URI.create(BASE_URI), config);

    return httpServer;
  }

  Server httpServer;

  @Override
  public void start(BundleContext bundleContext) throws Exception {
    httpServer = startServer();
  }

  @Override
  public void stop(BundleContext bundleContext) throws Exception {
    httpServer.stop();
  }
}
