package com.pb.services;

import com.pb.entities.Card;

/**
 * @author @bkalika
 */
public interface ICardService {
    Card findByNumberOrCreateCard(Card card);
}
