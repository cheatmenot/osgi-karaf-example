package com.eycads.rest;

import com.eycads.common.BookingService;

public class ServiceCatcher {
	private static BookingService _BookingService;
	
	public static void setBookingService(BookingService svc) {
		_BookingService = svc;
	}
	public static BookingService getBookingService() {
		return _BookingService;
	}
}
