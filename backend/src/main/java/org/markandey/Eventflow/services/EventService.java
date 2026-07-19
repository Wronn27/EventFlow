package org.markandey.Eventflow.services;

import org.markandey.Eventflow.domain.CreateEventRequest;
import org.markandey.Eventflow.domain.UpdateEventRequest;
import org.markandey.Eventflow.domain.entities.Event;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventService {

  Event createEvent(UUID organizerId, CreateEventRequest event);

  Page<Event> listEventsForOrganizer(UUID organizerId, Pageable pageable);

  Optional<Event> getEventForOrganizer(UUID organizerId, UUID id);

  Event updateEventForOrganizer(UUID organizerId, UUID id, UpdateEventRequest event);

  void deleteEventForOrganizer(UUID organizerId, UUID id);

  Page<Event> listPublishedEvents(Pageable pageable);

  Page<Event> searchPublishedEvents(String query, Pageable pageable);

  Optional<Event> getPublishedEvent(UUID id);
}
