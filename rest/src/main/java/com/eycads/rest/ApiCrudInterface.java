package com.eycads.rest;

import com.eycads.common.Booking;

import java.util.Collection;

public interface ApiCrudInterface {
  Collection<Booking> list();

  Booking get(Long id);

  void add(Booking booking);

  void update(Booking booking);

  void remove(Long id);
}
