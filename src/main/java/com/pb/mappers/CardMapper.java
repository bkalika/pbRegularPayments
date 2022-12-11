package com.pb.mappers;

import com.pb.dto.CardDto;
import com.pb.dto.SenderDto;
import com.pb.entities.Card;
import com.pb.entities.Sender;

/**
 * @author @bkalika
 */
public class CardMapper {
    public static Card cardDtoToCard(CardDto cardDto) {
        Card card = new Card();
        card.setId(card.getId());
        Sender owner = SenderMapper.senderDtoToSender(cardDto.getOwnerDto());
        card.setOwner(owner);
        card.setNumber(cardDto.getNumber());
        return card;
    }

    public static CardDto cardToCardDto(Card card) {
        CardDto cardDto = new CardDto();
        cardDto.setId(card.getId());
        SenderDto ownerDto = SenderMapper.senderToSenderDto(card.getOwner());
        cardDto.setOwnerDto(ownerDto);
        cardDto.setNumber(card.getNumber());
        return cardDto;
    }
}
