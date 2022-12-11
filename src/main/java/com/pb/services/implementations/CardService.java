package com.pb.services.implementations;

import com.pb.entities.Card;
import com.pb.repositories.CardRepository;
import com.pb.services.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author @bkalika
 */
@Service
public class CardService implements ICardService {
    private final CardRepository cardRepository;
    private final SenderService senderService;

    @Autowired
    public CardService(CardRepository cardRepository, SenderService senderService) {
        this.cardRepository = cardRepository;
        this.senderService = senderService;
    }

    @Override
    public Card findByNumberOrCreateCard(Card card) {
        senderService.findByInnOrCreateSender(card.getOwner());

        return cardRepository.findByNumber(card.getNumber())
                .orElseGet(() -> cardRepository.save(card));
    }
}
