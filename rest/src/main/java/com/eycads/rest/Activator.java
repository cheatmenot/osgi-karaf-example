package com.eycads.rest;

import com.eycads.common.BookingService;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.BusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.util.tracker.ServiceTracker;

public class Activator implements BundleActivator {

  private ServiceTracker<BookingService, BookingService> bookingServiceTracker;
  private ServiceRegistration clientServiceRegistration;
  private Server server;

  @Override
  public void start(BundleContext bundleContext) throws Exception {
    System.out.println("REST WebSvc Bundle starting...");
    bookingServiceTracker = new ServiceTracker<BookingService, BookingService>(bundleContext, BookingService.class, null) {

      @Override
      public BookingService addingService(ServiceReference<BookingService> reference) {
        BookingService bookingService = bundleContext.getService(reference);
        System.out.println("Got a booking service!");
        ServiceCatcher.setBookingService(bookingService);

        return bookingService;
      }

      @Override
      public void removedService(ServiceReference<BookingService> reference, BookingService service) {
        clientServiceRegistration.unregister();
      }
    };

    bookingServiceTracker.open();
    System.out.println("REST WebSvc Bundle started");

//    ServiceReference<?> sr =  bundleContext.getServiceReference(BookingService.class.getName());
//    BookingService bookingService = (BookingService) bundleContext.getService(sr);
    JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();
    bean.setAddress("/");
    bean.setBus(BusFactory.getDefaultBus());
    bean.setProvider(new JacksonJsonProvider());
    bean.setServiceBean(new BookingServiceRest());
    server = bean.create();
  }

  @Override
  public void stop(BundleContext bundleContext) throws Exception {
    bookingServiceTracker.close();

    if (server != null) {
      server.destroy();
    }
  }

}
