package org.markandey.Eventflow.services.impl;

import org.markandey.Eventflow.domain.entities.QrCode;
import org.markandey.Eventflow.domain.entities.QrCodeStatusEnum;
import org.markandey.Eventflow.domain.entities.Ticket;
import org.markandey.Eventflow.domain.entities.TicketValidation;
import org.markandey.Eventflow.domain.entities.TicketValidationMethod;
import org.markandey.Eventflow.domain.entities.TicketValidationStatusEnum;
import org.markandey.Eventflow.exceptions.QrCodeNotFoundException;
import org.markandey.Eventflow.exceptions.TicketNotFoundException;
import org.markandey.Eventflow.repositories.QrCodeRepository;
import org.markandey.Eventflow.repositories.TicketRepository;
import org.markandey.Eventflow.repositories.TicketValidationRepository;
import org.markandey.Eventflow.services.TicketValidationService;
import jakarta.transaction.Transactional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketValidationServiceImpl implements TicketValidationService {

  private final QrCodeRepository qrCodeRepository;
  private final TicketValidationRepository ticketValidationRepository;
  private final TicketRepository ticketRepository;

  @Override
  public TicketValidation validateTicketByQrCode(UUID qrCodeId) {
    QrCode qrCode = qrCodeRepository.findByIdAndStatus(qrCodeId, QrCodeStatusEnum.ACTIVE)
        .orElseThrow(() -> new QrCodeNotFoundException(
            String.format(
                "QR Code with ID %s was not found", qrCodeId
            )
        ));

    Ticket ticket = qrCode.getTicket();

    return validateTicket(ticket, TicketValidationMethod.QR_SCAN);
  }

  private TicketValidation validateTicket(Ticket ticket,
      TicketValidationMethod ticketValidationMethod) {
    TicketValidation ticketValidation = new TicketValidation();
    ticketValidation.setTicket(ticket);
    ticketValidation.setValidationMethod(ticketValidationMethod);

    TicketValidationStatusEnum ticketValidationStatus = ticket.getValidations().stream()
        .filter(v -> TicketValidationStatusEnum.VALID.equals(v.getStatus()))
        .findFirst()
        .map(v -> TicketValidationStatusEnum.INVALID)
        .orElse(TicketValidationStatusEnum.VALID);

    ticketValidation.setStatus(ticketValidationStatus);

    return ticketValidationRepository.save(ticketValidation);
  }

  @Override
  public TicketValidation validateTicketManually(UUID ticketId) {
    Ticket ticket = ticketRepository.findById(ticketId)
        .orElseThrow(TicketNotFoundException::new);
    return validateTicket(ticket, TicketValidationMethod.MANUAL);
  }
}
