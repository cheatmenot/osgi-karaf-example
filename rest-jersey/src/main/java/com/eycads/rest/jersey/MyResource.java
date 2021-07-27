package com.eycads.rest.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
