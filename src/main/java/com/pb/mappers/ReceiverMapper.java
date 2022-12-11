package com.pb.mappers;

import com.pb.dto.ReceiverDto;
import com.pb.entities.Receiver;

/**
 * @author @bkalika
 */
public class ReceiverMapper {
    public static Receiver receiverDtoToReceiver(ReceiverDto receiverDto) {
        Receiver receiver = new Receiver();
        receiver.setId(receiverDto.getId());
        receiver.setIban(receiverDto.getIban());
        receiver.setMfo(receiverDto.getMfo());
        receiver.setOkpo(receiverDto.getOkpo());
        receiver.setName(receiverDto.getName());
        return receiver;
    }

    public static ReceiverDto receiverToReceiverDto(Receiver receiver) {
        ReceiverDto receiverDto = new ReceiverDto();
        receiverDto.setId(receiver.getId());
        receiverDto.setIban(receiver.getIban());
        receiverDto.setMfo(receiver.getMfo());
        receiverDto.setOkpo(receiver.getOkpo());
        receiverDto.setName(receiver.getName());
        return receiverDto;
    }
}
