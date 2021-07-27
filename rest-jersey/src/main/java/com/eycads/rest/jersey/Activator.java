package com.eycads.rest.jersey;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.net.URI;

public class Activator implements BundleActivator {

  public static final String BASE_URI = "http://localhost:8080/";

  public static HttpServer startServer() {
    final ResourceConfig config = new ResourceConfig();
    config.register(MyResource.class);

    System.out.println("Starting Server........");

    final HttpServer httpServer =
        GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);

    return httpServer;
  }

  HttpServer httpServer;

  @Override
  public void start(BundleContext bundleContext) throws Exception {
    httpServer = startServer();
  }

  @Override
  public void stop(BundleContext bundleContext) throws Exception {
    httpServer.shutdownNow();
  }
}
