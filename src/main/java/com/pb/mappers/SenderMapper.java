package com.pb.mappers;

import com.pb.dto.SenderDto;
import com.pb.entities.Sender;

/**
 * @author @bkalika
 */
public class SenderMapper {
    public static Sender senderDtoToSender(SenderDto senderDto) {
        Sender sender = new Sender();
        sender.setId(senderDto.getId());
        sender.setFirstName(senderDto.getFirstName());
        sender.setLastName(senderDto.getLastName());
        sender.setInn(senderDto.getInn());
        return sender;
    }

    public static SenderDto senderToSenderDto(Sender sender) {
        SenderDto senderDto = new SenderDto();
        senderDto.setId(sender.getId());
        senderDto.setFirstName(sender.getFirstName());
        senderDto.setLastName(sender.getLastName());
        senderDto.setInn(sender.getInn());
        return senderDto;
    }
}
