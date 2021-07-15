//package com.eycads.rest;
//
//import com.eycads.common.BookingService;
//import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
//import org.apache.cxf.BusFactory;
//import org.apache.cxf.endpoint.Server;
//import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
//import org.osgi.framework.BundleContext;
//import org.osgi.framework.ServiceReference;
//import org.osgi.service.component.annotations.Activate;
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Deactivate;
//
//@Component
//public class RestService {
//
//    private Server server;
//
//    @Activate
//    public void activate(BundleContext bundleContext) throws Exception {
//        ServiceReference<?> sr =  bundleContext.getServiceReference(BookingService.class.getName());
//        BookingService bookingService = (BookingService) bundleContext.getService(sr);
//        JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();
//        bean.setAddress("/");
//        bean.setBus(BusFactory.getDefaultBus());
//        bean.setProvider(new JacksonJsonProvider());
//        bean.setServiceBean(new BookingServiceRest(bookingService));
//        server = bean.create();
//    }
//
//    @Deactivate
//    public void deactivate() throws Exception {
//        if (server != null) {
//            server.destroy();
//        }
//    }
//
//}
