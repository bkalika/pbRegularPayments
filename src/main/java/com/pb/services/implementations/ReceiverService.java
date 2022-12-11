package com.pb.services.implementations;

import com.pb.entities.Receiver;
import com.pb.repositories.ReceiverRepository;
import com.pb.services.IReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author @bkalika
 */
@Service
public class ReceiverService implements IReceiverService {
    private final ReceiverRepository receiverRepository;

    @Autowired
    public ReceiverService(ReceiverRepository receiverRepository) {
        this.receiverRepository = receiverRepository;
    }

    @Override
    public Receiver findByIbanOrCreateReceiver(Receiver receiver) {
        return receiverRepository.findByIban(receiver.getIban())
                .orElseGet(() -> receiverRepository.save(receiver));
    }
}
