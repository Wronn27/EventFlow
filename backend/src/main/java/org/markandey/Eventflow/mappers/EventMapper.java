package org.markandey.Eventflow.mappers;

import org.markandey.Eventflow.domain.CreateEventRequest;
import org.markandey.Eventflow.domain.CreateTicketTypeRequest;
import org.markandey.Eventflow.domain.UpdateEventRequest;
import org.markandey.Eventflow.domain.UpdateTicketTypeRequest;
import org.markandey.Eventflow.domain.dtos.CreateEventRequestDto;
import org.markandey.Eventflow.domain.dtos.CreateEventResponseDto;
import org.markandey.Eventflow.domain.dtos.CreateTicketTypeRequestDto;
import org.markandey.Eventflow.domain.dtos.GetEventDetailsResponseDto;
import org.markandey.Eventflow.domain.dtos.GetEventDetailsTicketTypesResponseDto;
import org.markandey.Eventflow.domain.dtos.GetPublishedEventDetailsResponseDto;
import org.markandey.Eventflow.domain.dtos.GetPublishedEventDetailsTicketTypesResponseDto;
import org.markandey.Eventflow.domain.dtos.ListEventResponseDto;
import org.markandey.Eventflow.domain.dtos.ListEventTicketTypeResponseDto;
import org.markandey.Eventflow.domain.dtos.ListPublishedEventResponseDto;
import org.markandey.Eventflow.domain.dtos.UpdateEventRequestDto;
import org.markandey.Eventflow.domain.dtos.UpdateEventResponseDto;
import org.markandey.Eventflow.domain.dtos.UpdateTicketTypeRequestDto;
import org.markandey.Eventflow.domain.dtos.UpdateTicketTypeResponseDto;
import org.markandey.Eventflow.domain.entities.Event;
import org.markandey.Eventflow.domain.entities.TicketType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

  CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

  CreateEventRequest fromDto(CreateEventRequestDto dto);

  CreateEventResponseDto toDto(Event event);

  ListEventTicketTypeResponseDto toDto(TicketType ticketType);

  ListEventResponseDto toListEventResponseDto(Event event);

  GetEventDetailsTicketTypesResponseDto toGetEventDetailsTicketTypesResponseDto(
      TicketType ticketType);

  GetEventDetailsResponseDto toGetEventDetailsResponseDto(Event event);

  UpdateTicketTypeRequest fromDto(UpdateTicketTypeRequestDto dto);

  UpdateEventRequest fromDto(UpdateEventRequestDto dto);

  UpdateTicketTypeResponseDto toUpdateTicketTypeResponseDto(TicketType ticketType);

  UpdateEventResponseDto toUpdateEventResponseDto(Event event);

  ListPublishedEventResponseDto toListPublishedEventResponseDto(Event event);

  GetPublishedEventDetailsTicketTypesResponseDto toGetPublishedEventDetailsTicketTypesResponseDto(
      TicketType ticketType);

  GetPublishedEventDetailsResponseDto toGetPublishedEventDetailsResponseDto(Event event);
}
