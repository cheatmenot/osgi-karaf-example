package com.eycads.rest.jersey;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class MyResource {

  // output text
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    return "Jersey hello world example.";
  }

  // output text with argument
  @Path("/{name}")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello(@PathParam("name") String name) {
    return "Jersey: hello " + name;
  }

}
