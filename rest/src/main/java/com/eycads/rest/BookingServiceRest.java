package com.eycads.rest;

import com.eycads.common.Booking;
import com.eycads.rest.redis.DistributedMemory;
import com.eycads.rest.redis.JedisDistributedMemory;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.HostAndPort;

import javax.ws.rs.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Path("/booking")
public class BookingServiceRest implements ApiCrudInterface {

//    @Reference
//    private BookingService bookingService;

//    BookingServiceRest(BookingService svc){
//        bookingService = svc;
//    }
    
    private final Map<Long, Booking> bookings = new HashMap<>();

    private HostAndPort hostAndPort = new HostAndPort("localhost", 6379);
    private DefaultJedisClientConfig conf = DefaultJedisClientConfig.builder()
        .password("alona")
        .build();
    private DistributedMemory dm = new JedisDistributedMemory(hostAndPort, conf);

    @Override
    @Path("/")
    @Produces("application/json")
    @GET
    public Collection<Booking> list() {
        System.out.println(ServiceCatcher.getBookingService());
        return ServiceCatcher.getBookingService().list();
    }

    @Override
    @Path("/{id}")
    @Produces("application/json")
    @GET
    public Booking get(@PathParam("id") Long id) {
        return bookings.get(id);
    }

    @Override
    @Path("/")
    @Consumes("application/json")
    @POST
    public void add(Booking booking) {
        ServiceCatcher.getBookingService().add(booking);
    }

    @Override
    @Path("/")
    @Consumes("application/json")
    @PUT
    public void update(Booking booking) {
        bookings.remove(booking.getId());
        bookings.put(booking.getId(), booking);
    }

    @Override
    @Path("/{id}")
    @DELETE
    public void remove(@PathParam("id") Long id) {
        bookings.remove(id);
    }

    @Path("/redis/{id}")
    @Produces("application/json")
    @GET
    public String getRedis(@PathParam("id") String id) {
        return dm.get(id);
    }

    @Path("/redis")
    @Produces("application/json")
    @POST
    public Booking getRedis(Booking booking) {
        dm.set(booking.getCustomer(), booking.getFlight());
        return booking;
    }
}
