package com.eycads.rest;

import com.eycads.common.Booking;
import com.eycads.common.BookingService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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

    @Override
    @Path("/")
    @Produces("application/json")
    @GET
    public Collection<Booking> list() {
        System.out.println(ServiceCatcher.getBookingService());
        return ServiceCatcher.getBookingService().list();
//        return bookingService.list();
//        return bookings.values();
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
//        bookings.put(booking.getId(), booking);
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
}
