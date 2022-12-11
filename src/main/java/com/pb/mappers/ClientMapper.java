package com.pb.mappers;

import com.pb.dto.ClientDto;
import com.pb.entities.Client;

/**
 * @author @bkalika
 */
public class ClientMapper {
    public static Client clientDtoToClient(ClientDto clientDto) {
        Client client = new Client();
        client.setId(client.getId());
        client.setFirstName(client.getFirstName());
        client.setLastName(client.getLastName());
        client.setInn(client.getInn());
        return client;
    }

    public static ClientDto clientToClientDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(clientDto.getId());
        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(clientDto.getLastName());
        clientDto.setInn(client.getInn());
        return clientDto;
    }
}
