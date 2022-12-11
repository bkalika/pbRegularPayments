package com.pb.services.implementations;

import com.pb.entities.Sender;
import com.pb.repositories.SenderRepository;
import com.pb.services.ISenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author @bkalika
 */
@Service
public class SenderService implements ISenderService {
    private final SenderRepository senderRepository;

    @Autowired
    public SenderService(SenderRepository senderRepository) {
        this.senderRepository = senderRepository;
    }

    @Override
    public Sender findByInnOrCreateSender(Sender owner) {
        return senderRepository.findByInn(owner.getInn())
                .orElseGet(() -> senderRepository.save(owner));
    }

    @Override
    public Sender updateSender(Long id, Sender sender) {
        Sender updatedSender = findByInnOrCreateSender(sender);
        updatedSender.setFirstName(sender.getFirstName());
        updatedSender.setLastName(sender.getLastName());
        return updatedSender;
    }
}
