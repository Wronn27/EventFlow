package org.markandey.Eventflow.services;

import org.markandey.Eventflow.domain.entities.QrCode;
import org.markandey.Eventflow.domain.entities.Ticket;
import java.util.UUID;

public interface QrCodeService {

  QrCode generateQrCode(Ticket ticket);

  byte[] getQrCodeImageForUserAndTicket(UUID userId, UUID ticketId);
}
