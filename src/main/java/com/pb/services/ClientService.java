package com.pb.services;

import com.pb.repositories.ClientRepository;
import org.springframework.stereotype.Service;

/**
 * @author @bkalika
 */
@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
}
