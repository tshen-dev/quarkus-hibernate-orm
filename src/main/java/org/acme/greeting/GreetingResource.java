package org.acme.greeting;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.gift.GiftService;

@Path("/hello")
public class GreetingResource {

  @Inject
  GiftService universalService;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    universalService.createGift(String.valueOf(System.currentTimeMillis()));
    return "Hello RESTEasy";
  }
}
