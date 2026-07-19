package org.markandey.Eventflow.services.impl;

import org.markandey.Eventflow.domain.entities.Ticket;
import org.markandey.Eventflow.domain.entities.TicketStatusEnum;
import org.markandey.Eventflow.domain.entities.TicketType;
import org.markandey.Eventflow.domain.entities.User;
import org.markandey.Eventflow.exceptions.TicketTypeNotFoundException;
import org.markandey.Eventflow.exceptions.TicketsSoldOutException;
import org.markandey.Eventflow.exceptions.UserNotFoundException;
import org.markandey.Eventflow.repositories.TicketRepository;
import org.markandey.Eventflow.repositories.TicketTypeRepository;
import org.markandey.Eventflow.repositories.UserRepository;
import org.markandey.Eventflow.services.QrCodeService;
import org.markandey.Eventflow.services.TicketTypeService;
import jakarta.transaction.Transactional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketTypeServiceImpl implements TicketTypeService {

  private final UserRepository userRepository;
  private final TicketTypeRepository ticketTypeRepository;
  private final TicketRepository ticketRepository;
  private final QrCodeService qrCodeService;

  @Override
  @Transactional
  public Ticket purchaseTicket(UUID userId, UUID ticketTypeId) {
    User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(
        String.format("User with ID %s was not found", userId)
    ));

    TicketType ticketType = ticketTypeRepository.findByIdWithLock(ticketTypeId)
        .orElseThrow(() -> new TicketTypeNotFoundException(
            String.format("Ticket type with ID %s was not found", ticketTypeId)
        ));

    int purchasedTickets = ticketRepository.countByTicketTypeId(ticketType.getId());
    Integer totalAvailable = ticketType.getTotalAvailable();

    if(purchasedTickets + 1 > totalAvailable) {
      throw new TicketsSoldOutException();
    }

    Ticket ticket = new Ticket();
    ticket.setStatus(TicketStatusEnum.PURCHASED);
    ticket.setTicketType(ticketType);
    ticket.setPurchaser(user);

    Ticket savedTicket = ticketRepository.save(ticket);
    qrCodeService.generateQrCode(savedTicket);

    return ticketRepository.save(savedTicket);
  }
}
